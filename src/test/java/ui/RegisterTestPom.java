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
import pom.RegisterPage;

import static org.testng.Assert.assertTrue;

public class RegisterTestPom extends BaseClass {

    WebDriver driver;

    RegisterPage registerPage;

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
    public void testGitHubRegisterSuccess() throws InterruptedException {

        registerPage = new RegisterPage(driver);
        // Open the page
        driver.get("https://github.com/");
        driver.manage().window().maximize();

        // Click on Sign up locator
        driver.findElement(registerPage.singUpButton).click();
        Thread.sleep(3000);

       // registerPage.register(EMAIL, PASSWORD, RegisterUtils.USERNAME, DO_NOT_RECEIVE_PRODUCT);

        // Verify
        WebElement repos = driver.findElement(By.xpath("//h2[contains(text(), 'Repositories')]"));
        assertTrue(repos.isDisplayed());
    }

}

