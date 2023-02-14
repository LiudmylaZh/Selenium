import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static jdk.internal.agent.Agent.getText;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HoverTest {
    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/liudmyla/Desktop/Tel-ran/QA/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "https://crossbrowsertesting.github.io/hover-menu.html";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }
    @Test
    public void hoverTest() throws InterruptedException {
        WebElement dropDown = driver.findElement(By.xpath("//li[@class='dropdown']/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(dropDown).perform();


        WebElement secondaryMenu = driver.findElement(By.cssSelector("[class='secondary-dropdown']>a"));
        actions.moveToElement(secondaryMenu).perform();

        WebElement secondaryAction = driver.findElement(By.cssSelector("[class='dropdown-menu secondary']"));
        actions.moveToElement(secondaryAction).perform();
        secondaryAction.click();
        sleep (5000);

        WebElement title = driver.findElement(By.cssSelector("div.jumbotron.secondary-clicked > h1"));
        assertTrue(title.getText().contains("Secondary Page"));
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
