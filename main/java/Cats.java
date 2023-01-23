import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

import static java.awt.SystemColor.text;
import static org.junit.Assert.assertEquals;

public class Cats {
    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/liudmyla/Desktop/Tel-ran/QA/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "http://suninjuly.github.io/cats.html";
        driver.get(BASE_URL);
    }


        @Test //отметка о тесте//
                public void checkHeaderText() {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
             //для одного элемента//
            WebElement header = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("jumbotron-heading")));
            wait.until(ExpectedConditions.visibilityOf(header)); // явное ожидание, пока не наступит событие.//
            String expectedHeaderText = "Cat memes";
            assertEquals("Element does not contains text:" + expectedHeaderText, expectedHeaderText,
                    header.getText());

        }
        @Test
        public void checkCatsCardsQuantity() {
            List<WebElement> catsCards = driver.findElements(By.className("col-sm-4")); //для коллекции элементов//
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(catsCards.get(0)));
            assertEquals("Quantity of cat's cards are not 6", 6, catsCards.size());


        }
    @Test
    public void checkNameOfSecondCat() {
        WebElement nameOfSecondCat = driver.findElement(By.cssSelector("[class='col-sm-4']:nth-child(2) .card-body [class='card-text second']"));
        String expectedNameOfSecondCat = "Serious cat";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(nameOfSecondCat));
        assertEquals("Element does not contains text:" + expectedNameOfSecondCat, expectedNameOfSecondCat,
                nameOfSecondCat.getText());


    }


    @Test
    public void checkButtonOfForthCat() {
        WebElement buttonOfForthCat = driver.findElement(By.cssSelector("[class='col-sm-4']:nth-child(4) .card-body [class=\"btn btn-sm btn-outline-secondary\"]:nth-child(1)"));
        String expectedNameOfButton = "View";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(buttonOfForthCat));
        assertEquals("Element does not contains text:" + expectedNameOfButton, expectedNameOfButton,
                buttonOfForthCat.getText());
    }

    @Test
    public void checkTimeOfSixthCat() {
        WebElement timeOfSixthCat = driver.findElement(By.cssSelector("[class='col-sm-4']:nth-child(6) .card-body [class=\"text-muted\"]"));
        String expectedTime = "9 mins";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(timeOfSixthCat));
        assertEquals("Element does not contains text:" + expectedTime, expectedTime,
                timeOfSixthCat.getText());


    }

        @After //выполнение после каждого теса//
    public void tearDown() {
        driver.quit();
        }


    }




