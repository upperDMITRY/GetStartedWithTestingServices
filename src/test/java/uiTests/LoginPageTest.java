package uiTests;

import core.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pom1.LoginPage;

import static entities.BaseClass.PASS;
import static entities.BaseClass.USERNAME;

@Test
public class LoginPageTest extends BaseTest {

    public void test(){

        driver = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
        driver.get("https://github.com/");
        driver.manage().window().maximize();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.signInBtn.click();
        loginPage.username.sendKeys(USERNAME);
        loginPage.password.sendKeys(PASS);
        loginPage.submitBtn.click();

    }
}
