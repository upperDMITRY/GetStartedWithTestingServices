package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    WebDriver webDriver;

    public By singUpButton = By.partialLinkText("Sign up");

    public By emailField = By.id("email");

    public By continueEmailButton = By.xpath("//button[contains(text(),'Continue')]");

    public By continuePasswordButton = By.xpath("//button[contains(@data-continue-to,'username-container')]");

    public By continueUsernameButton = By.xpath("//button[contains(@data-continue-to,'opt-in-container')]");

    public By continueProductButton = By.xpath("//button[contains(@data-continue-to,'captcha-and-submit-container')]");

    public By passwordField = By.xpath("//input[@type='password']");

    public By usernameField = By.xpath("//input[@name='user[login]']");

    public By receiveProductField = By.xpath("//input[@id='opt_in']");

    public By puzzleButton = By.xpath("//button[@id='home_children_button']");

    public RegisterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void register(String email, String password, String username, String product) throws InterruptedException {
        webDriver.findElement(emailField).clear();
        webDriver.findElement(emailField).sendKeys(email);
        Thread.sleep(2000);
        webDriver.findElement(continueEmailButton).click();
        Thread.sleep(1000);

        webDriver.findElement(passwordField).clear();
        webDriver.findElement(passwordField).sendKeys(password);
        Thread.sleep(1000);
        webDriver.findElement(continuePasswordButton).click();
        Thread.sleep(1000);

        webDriver.findElement(usernameField).clear();
        webDriver.findElement(usernameField).sendKeys(username);
        Thread.sleep(1500);
        webDriver.findElement(continueUsernameButton).click();
        Thread.sleep(1000);

        webDriver.findElement(receiveProductField).clear();
        webDriver.findElement(receiveProductField).sendKeys(product);
        Thread.sleep(1000);
        webDriver.findElement(continueProductButton).click();
        Thread.sleep(10000);

        webDriver.findElement(puzzleButton).click();
        Thread.sleep(3000);

    }



}
