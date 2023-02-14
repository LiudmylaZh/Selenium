import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static java.lang.Double.parseDouble;
import static java.lang.Math.*;
import static org.junit.Assert.assertTrue;

public class Demoqa {
    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/liudmyla/Desktop/Tel-ran/QA/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "https://demoqa.com/browser-windows";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Test
    public void switchToNewTab() {
        WebElement buttonNewTab = driver.findElement(By.id("tabButton"));
        buttonNewTab.click();
        ArrayList<String> handles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));

        WebElement textInNewTab = driver.findElement(By.id("sampleHeading"));
        assertTrue(textInNewTab.isDisplayed());


      /*  @After
        public void tearDown() {
            driver.quit();
        }*/
    }
}