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
import pom.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTestPom extends BaseClass {

    WebDriver driver;

    LoginPage loginPage;

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

        loginPage = new LoginPage(driver);
        // Open the page
        driver.get("https://github.com/");
        driver.manage().window().maximize();

//        // Click on Sign in locator
//        driver.findElement(loginPage.singInButton).click();
//        Thread.sleep(100);
//
//        loginPage.login(USERNAME, PASS);

        // Verify
        WebElement repos = driver.findElement(By.xpath("//h2[contains(text(), 'Repositories')]"));
        assertTrue(repos.isDisplayed());
        assertEquals(repos.getAttribute("placeholder"), "6 digit number");
    }

}

