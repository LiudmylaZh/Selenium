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
import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class HugeForm {
    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/liudmyla/Desktop/Tel-ran/QA/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "https://suninjuly.github.io/huge_form.html";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//не явное ожидание, ожидание в целом (что бы не происхожило ожтдает 10 секунд)//
        driver.manage().window().maximize();
    }
    @Test
    public void allFields() throws InterruptedException {
        List<WebElement> inputFields = driver.findElements(By.tagName("input"));
        for (WebElement input: inputFields) {
            input.sendKeys("Testing");
        }

            WebElement submitButton = driver.findElement(By.cssSelector("[class=\'btn btn-default\']"));
            submitButton.click();
            sleep(10000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert text: " + alert.getText());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));

        }




    @After //выполнение после каждого теса//
    public void tearDown() {
        driver.quit();
    }
}
