import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.header;
import static org.junit.Assert.*;

public class Registration {
    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/liudmyla/Desktop/Tel-ran/QA/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "https://suninjuly.github.io/registration1.html";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//не явное ожидание, ожидание в целом (что бы не происхожило ожтдает 10 секунд)//
        driver.manage().window().maximize();
    }
    @Test
    public void onlyRequiredFields() throws InterruptedException {
        WebElement firstNameInputField = driver.findElement(By.cssSelector("[placeholder=\'Input your first name\']"));
        firstNameInputField.sendKeys("John");
        Thread.sleep(500);

        WebElement lastNameInputField = driver.findElement(By.cssSelector("[placeholder=\'Input your last name\']"));
        lastNameInputField.sendKeys("McCarthy");
        Thread.sleep(500);

        WebElement emailInputField = driver.findElement(By.cssSelector("[placeholder=\'Input your email\']"));
        emailInputField.sendKeys("McCarthy@gmail.com");
        Thread.sleep(500);

        WebElement submitButton = driver.findElement(By.cssSelector("[class=\'btn btn-default\']"));
        submitButton.click();
        Thread.sleep(1000);

        WebElement header = driver.findElement(By.tagName("h1"));
        //assertEquals("Congratulations! You have successfully registered!", header.getText());//
        assertTrue(header.getText().contains("Congratulations"));
    }
    @Test
    public void allFields() throws InterruptedException {
        WebElement firstNameInputField = driver.findElement(By.cssSelector("[placeholder=\'Input your first name\']"));
        firstNameInputField.sendKeys("John");
        Thread.sleep(500);

        WebElement lastNameInputField = driver.findElement(By.cssSelector("[placeholder=\'Input your last name\']"));
        lastNameInputField.sendKeys("McCarthy");
        Thread.sleep(500);

        WebElement emailInputField = driver.findElement(By.cssSelector("[placeholder=\'Input your email\']"));
        emailInputField.sendKeys("McCarthy@gmail.com");
        Thread.sleep(500);

        WebElement phoneInputField = driver.findElement(By.cssSelector("[placeholder=\'Input your phone:\']"));
        phoneInputField.sendKeys("+49 152 55656 5656");
        Thread.sleep(500);

        WebElement addressInputField = driver.findElement(By.cssSelector("[placeholder=\'Input your address:\']"));
        addressInputField.sendKeys("Germany, 65782, München, StroblStraße, 23");
        Thread.sleep(500);

        WebElement submitButton = driver.findElement(By.cssSelector("[class=\'btn btn-default\']"));
        submitButton.click();
        Thread.sleep(1000);

        WebElement header = driver.findElement(By.tagName("h1"));
        //assertEquals("Congratulations! You have successfully registered!", header.getText());//
        assertTrue(header.getText().contains("Congratulations"));

        System.out.println("Current URL: " + driver.getCurrentUrl());

    }
    @Test
    public void notAllRequiredFielads() throws InterruptedException {
        WebElement firstNameInputField = driver.findElement(By.cssSelector("[placeholder=\'Input your first name\']"));
        firstNameInputField.sendKeys("John");
        sleep(500);

        WebElement lastNameInputField = driver.findElement(By.cssSelector("[placeholder=\'Input your last name\']"));
        lastNameInputField.sendKeys("McCarthy");
        sleep(500);

        WebElement submitButton = driver.findElement(By.cssSelector("[class=\'btn btn-default\']"));
        submitButton.click();
        sleep(1000);

        assertFalse(driver.getCurrentUrl().contains("result"));
    }

    @After //выполнение после каждого теса//
    public void tearDown() {
        driver.quit();
    }
}
