import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class DragAndDrop {
    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/liudmyla/Desktop/Tel-ran/QA/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "https://crossbrowsertesting.github.io/drag-and-drop.html";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    @Test
    public void dragAndDropTest (){
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        Actions actions = new Actions(driver);
        //actions.dragAndDrop(draggable, droppable);
        actions.moveToElement(draggable).clickAndHold().
                moveToElement(droppable).release().perform();

        WebElement title = driver.findElement(By.id("droppable"));
        assertTrue(title.getText().contains("Dropped"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
