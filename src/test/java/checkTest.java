import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class checkTest extends BasePage{

    @Test
    public void pageTitle(){
        String pageTitle = driver.getTitle();

        Assert.assertEquals(pageTitle, "Automation Sample Shop");
    }

    @Test
    public void pageLogo(){
        WebElement logoElement = driver.findElement(By.id("_desktop_logo"));

        Assert.assertTrue(logoElement.isDisplayed());
    }

    @Test
    public void checkMenu(){
        WebElement clothes = driver.findElement(By.cssSelector("#category-3 a"));
        WebElement produktyPowiazane = driver.findElement(By.cssSelector("#category-6 a"));
        WebElement art = driver.findElement(By.cssSelector("#category-9 a"));

        Assert.assertTrue(clothes.isDisplayed());
        Assert.assertTrue(produktyPowiazane.isDisplayed());
        Assert.assertTrue(art.isDisplayed());
    }

}
