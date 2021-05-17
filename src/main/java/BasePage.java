import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("http://sampleshop.inqa.pl/");
        driver.manage().window().maximize();
        //Dodatkowa metoda, służąca do powiększenia okna strony
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    //Wspólna metoda do inicjalizacji przeglądarki z przejściem do adresu

    @BeforeMethod
    public void methodSetup(){
        System.out.println("Uruchamiam kolejną metodę");
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
        //Zamknięcie okna przeglądarki
    }
    //Podobnie jak BeforeClass uruchamianie przy każdej klasie testowej
    //W tym wypadku na jej końcu. Zapewnia zamknięcie okna przeglądarki
    //po testach
}
