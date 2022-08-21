package google;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;


public class SearchImageTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @Test
    public void testSearchForImage() {
        driver.findElement(By.cssSelector("a[href*=imghp]")).click();
        driver.findElement(By.cssSelector("input[spellcheck=false]")).sendKeys("cat");
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        List<WebElement> elementCat = driver.findElements(By.cssSelector("img[jsname]"));
        assertTrue(elementCat.size() > 0);
        assertTrue(elementCat.get(0).isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
