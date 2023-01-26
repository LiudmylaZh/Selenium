import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BirthdayForm {
    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/liudmyla/Desktop/Tel-ran/QA/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "https://demo.guru99.com/test/";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }
    @Test
    public void dateAndTime() throws InterruptedException {
            //sleep(2000);
            //driver.switchTo().frame("gdpr-consent-notice");
            //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            //WebElement aceptCockies = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("save")));
            //aceptCockies.click();
            //WebElement aceptCockies = driver.findElement(By.id("save"));
            //aceptCockies.click();

            WebElement dataInput = driver.findElement(By.cssSelector("[type=\"datetime-local\"]"));
            //dataInput.sendKeys("26.06.1992",Keys.ARROW_RIGHT, "03.25");

            dataInput.sendKeys("26.06.1992",Keys.TAB, "03.25", Keys.ENTER);


            WebElement submitButton = driver.findElement(By.cssSelector("[type=\"submit\"]"));
            submitButton.click();

            assertTrue(dataInput.getAttribute("validationMessage").contains("Введите верное значение"));
            assertFalse(driver.getCurrentUrl().contains("birthdate"));



    }
          @After //выполнение после каждого теса//
            public void tearDown() {
             driver.quit();
           }

}
