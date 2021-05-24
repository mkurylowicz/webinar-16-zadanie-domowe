import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.lang.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductDetailsTest extends BasePage{

    @Test
    public void addToCartButton(){
        driver.get("http://sampleshop.inqa.pl/men/1-1-hummingbird-printed-t-shirt.html#/1-rozmiar-s/8-kolor-bialy");

        WebElement addToCard = driver.findElement(By.cssSelector(".btn.btn-primary.add-to-cart"));

        String buttonColor = addToCard.getCssValue("background-color");
        System.out.println(buttonColor);
        String buttonColorHex = Color.fromString(buttonColor).asHex();
        System.out.println(buttonColorHex);

        Assert.assertEquals(buttonColorHex, "#2fb5d2");

        String textColor = addToCard.getCssValue("color");
        System.out.println(textColor);
        String fontColorHex = Color.fromString(textColor).asHex();
        System.out.println(fontColorHex);

        Assert.assertEquals(fontColorHex, "#ffffff");
    }

    @Test
    public void choiceColorOfPillow() throws IOException, InterruptedException {
        driver.get("http://sampleshop.inqa.pl/home-accessories/10-24-brown-bear-cushion.html#/8-kolor-bialy");

        List<WebElement> radioButtons = driver.findElements(By.cssSelector("#group_2 li"));

        WebElement firstRadioButton = radioButtons.get(0).findElement(By.tagName("input"));
        WebElement secondRadioButton = radioButtons.get(1).findElement(By.tagName("input"));

        firstRadioButton.click();
        Assert.assertTrue(firstRadioButton.isSelected());
        Assert.assertFalse(secondRadioButton.isSelected());

        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("./target/screenshotpillow1.png"));

        secondRadioButton.click();
        Assert.assertFalse(firstRadioButton.isSelected());
        Assert.assertTrue(secondRadioButton.isSelected());
        Thread.sleep(2000);
        File scrFile2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile2, new File("./target/screenshotpillow2.png"));

        firstRadioButton.click();
        Assert.assertTrue(firstRadioButton.isSelected());
        Assert.assertFalse(secondRadioButton.isSelected());

    }
}
