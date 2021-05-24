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
        String clothesTxt = clothes.getText();
        WebElement produktyPowiazane = driver.findElement(By.cssSelector("#category-6 a"));
        String produktyPowiazaneTxt = produktyPowiazane.getText();
        WebElement art = driver.findElement(By.cssSelector("#category-9 a"));
        String atrTxt = art.getText();

        Assert.assertEquals(clothesTxt, "CLOTHES");
        Assert.assertEquals(produktyPowiazaneTxt, "PRODUKTY POWIĄZANE");
        Assert.assertEquals(atrTxt, "ART");

    }

}
