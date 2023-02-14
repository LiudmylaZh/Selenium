import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Integer.parseInt;
import static org.junit.Assert.assertTrue;

public class MathCalc {
    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/liudmyla/Desktop/Tel-ran/QA/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "https://suninjuly.github.io/selects1.html";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }


    @Test
    public  void dropDown (){
        WebElement num1 = driver.findElement(By.id("num1"));
        WebElement num2 = driver.findElement(By.id("num2"));

        int sum = (parseInt(num1.getText())+parseInt(num2.getText()));
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        dropDown.click();
        WebElement answerOption = driver.findElement(By.cssSelector("[value='"+sum +"']"));
        answerOption.click();

        WebElement buttonSubmit = driver.findElement(By.cssSelector("[type= 'submit']"));
        buttonSubmit.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert text: " + alert.getText());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));
}


    @After
    public void tearDown() {
        driver.quit();
    }
}
