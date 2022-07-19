import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import java.time.Duration;
import java.util.List;
import java.util.Locale;

public class webDriverBasics {
    public static WebDriver driver;

    @BeforeClass
    public static void initWebDriver() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void WebdriverHelloWorldTest() {
        driver.get("http://automationpractice.com/");
        WebElement searchQuery = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
        searchQuery.sendKeys("Dresses");
        WebElement searchBtn = driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button"));
        searchBtn.click();
        List<WebElement> listElement = driver.findElements(By.xpath("//li[contains(@class, \"ajax_block_product\")]"));
        int count = listElement.size();
        WebElement headingCount = driver.findElement(By.className("heading-counter"));
        String text = headingCount.getText();
        String subCount = text.substring(0, 1);
        Assert.assertEquals("7", subCount);
    }

    @Test
    public void findDress() {
        driver.get("http://automationpractice.com/");
        WebElement searchQuery = driver.findElement(By.xpath("//*[@id=\"search_query_top\"]"));
        searchQuery.sendKeys("Dresses");
        WebElement searchBtn = driver.findElement(By.xpath("//*[@id=\"searchbox\"]/button"));
        searchBtn.click();
        List<WebElement> listElement = driver.findElements(By.xpath("//li[contains(@class,\\\"ajax_block_product\\\")]//div/div[2]/h5"));
        WebElement headingCounter = driver.findElement(By.className("heading-counter"));
        for (WebElement i : listElement) {
            String text = i.getText().toLowerCase();
            Assert.assertTrue(text.contains("dress"));
        }


    }

    @Test
    public void logIntoSystem() {
        driver.get("http://the-internet.herokuapp.com/login");
        WebElement userName = driver.findElement(By.id("username"));
        WebElement passWord = driver.findElement(By.id("password"));
        WebElement logInBtn = driver.findElement(By.className("fa-sign-in"));
        userName.sendKeys("tomsmith");
        passWord.sendKeys("SuperSecretPassword!");
        logInBtn.click();
        WebElement logOutBtn= driver.findElement(By.className("icon-signout"));
        logOutBtn.click();
    }
    @Test
    public void errorValidation(){
        driver.get("http://the-internet.herokuapp.com/login");
        WebElement userName = driver.findElement(By.id("username"));
        WebElement passWord = driver.findElement(By.id("password"));
        WebElement logInBtn = driver.findElement(By.className("fa-sign-in"));
        userName.sendKeys("qewrtsgdh");
        passWord.sendKeys("wesdrftyh!");
        logInBtn.click();
        WebElement errorMessage= driver.findElement(By.id("flash"));
        String text= errorMessage.getText();
        Assert.assertTrue(text.contains("invalid"));


    }


}


