import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.ArrayList;

import static io.ous.jtoml.JToml.parseString;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Math.*;
import static org.junit.Assert.assertTrue;

public class SwitchToTab {
    ChromeDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/liudmyla/Desktop/Tel-ran/QA/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "http://suninjuly.github.io/redirect_accept.html";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }



    @Test public void switchToAnotherTab(){
        WebElement button = driver.findElement(By.cssSelector("[type=\"submit\"]"));
        button.click();
        ArrayList<String> handles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(handles.get(1));
        WebElement xValue = driver.findElement(By.id("input_value"));
        double x = parseDouble(xValue.getText());
        double result = (log(abs(sin(x)*12)));

        WebElement inputResult = driver.findElement(By.id("answer"));
        inputResult.sendKeys(String.valueOf(result));
        WebElement buttonSubmit = driver.findElement(By.cssSelector("[type= 'submit']"));
        buttonSubmit.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert text: " + alert.getText());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));

    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
