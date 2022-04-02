package ui;

import entities.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseClass {

    WebDriver driver;

    @BeforeTest
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeClass
    void setupTest() {
        driver = new ChromeDriver();
    }

    @AfterClass
    void teardown() {
        driver.quit();
    }

    @Test
    public void testGitHubLoginSuccess() throws InterruptedException {

        // Open the page
        driver.get("https://github.com/");
        driver.manage().window().maximize();

        // Click on Sign in locator
        driver.findElement(By.partialLinkText("Sign")).click();
        Thread.sleep(100);

        //Enter userName Locator = ID
        driver.findElement(By.id("login_field")).clear();
        driver.findElement(By.id("login_field")).sendKeys(USERNAME);
        Thread.sleep(100);

        //Enter userName Locator = name
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(PASS);
        Thread.sleep(100);

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // Verify
        WebElement repos = driver.findElement(By.xpath("//h2[contains(text(), 'Repositories')]"));
        assertTrue(repos.isDisplayed());
    }

}
