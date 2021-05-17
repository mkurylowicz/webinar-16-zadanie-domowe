import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class searchTest extends BasePage{
    @Test
    public void searchBrownBearNotebook() {

        WebElement artCategory = driver.findElement(By.className("ui-autocomplete-input"));
        artCategory.click();
        artCategory.sendKeys("brown bear notebook");


        WebElement magnifier = driver.findElement(By.cssSelector("button[type=submit]"));
        magnifier.click();

        driver.findElement(By.xpath("//h2[text()=\"Wyniki wyszukiwania\"]"));
        driver.findElement(By.xpath("//section[@id='products']//a[text()='Brown bear notebook']"));
    }

    @Test
    public void searchCushion() {

        WebElement artCategory = driver.findElement(By.className("ui-autocomplete-input"));
        artCategory.click();
        artCategory.sendKeys("cushion");


        WebElement magnifier = driver.findElement(By.cssSelector("button[type=submit]"));
        magnifier.click();

        WebElement number = driver.findElement(By.cssSelector("#js-product-list-top p"));
        String text = number.getText();

        Assert.assertEquals(text,"Jest 3 produktów.");

    }


}
