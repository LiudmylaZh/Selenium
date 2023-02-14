import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

import static java.lang.Double.parseDouble;
import static java.lang.Math.*;
import static org.junit.Assert.assertTrue;

public class JavaScript {
    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/liudmyla/Desktop/Tel-ran/QA/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "https://suninjuly.github.io/execute_script.html";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }
    @Test
            public void Calculation () {
        WebElement xValue = driver.findElement(By.id("input_value"));
        double x = parseDouble(xValue.getText());
        double result = (log(abs(sin(x) * 12)));
        WebElement inputResult = driver.findElement(By.id("answer"));
        inputResult.sendKeys(String.valueOf(result));
        WebElement robotCheckBox = driver.findElement(By.id("robotCheckBox"));
        robotCheckBox.click();
        WebElement robotRule = driver.findElement(By.id("robotsRule"));
        ChromeDriver js = driver;
        js.executeScript ("arguments[0].scrollIntoView(true);", robotRule);
        robotRule.click();
        WebElement buttonSubmit = driver.findElement(By.cssSelector("[type= 'submit']"));
        buttonSubmit.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
