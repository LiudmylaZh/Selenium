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

import static org.junit.Assert.assertTrue;

public class FileUpload {
    ChromeDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/liudmyla/Desktop/Tel-ran/QA/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "http://suninjuly.github.io/file_input.html";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Test
    public void uploadFileTest (){
        WebElement firstName = driver.findElement(By.cssSelector("[name=\"firstname\"]"));
        firstName.sendKeys("John");
        WebElement lastName = driver.findElement(By.cssSelector("[name=\"lastname\"]"));
        lastName.sendKeys("McKenzi");
        WebElement email = driver.findElement(By.cssSelector("[name=\"email\"]"));
        email.sendKeys("McKenzi@gmail.com");
        WebElement inputButton = driver.findElement(By.id("file"));
        inputButton.sendKeys("/Users/liudmyla/Downloads/textfile.txt");
        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertTrue(alert.getText().contains("Congrats, you've passed the task!"));

    }
    @After
    public void tearDown() {
        driver.quit();
    }
}

