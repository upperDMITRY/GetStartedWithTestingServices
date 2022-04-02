package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver webDriver;

    public By singInButton = By.partialLinkText("Sign");

    public By loginField = By.id("login_field");

    public By passField = By.name("password");

    public By submitButton = By.xpath("//input[@type='submit']");

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void login(String username, String password){
        webDriver.findElement(loginField).clear();
        webDriver.findElement(loginField).sendKeys(username);
        webDriver.findElement(passField).clear();
        webDriver.findElement(passField).sendKeys(password);
        webDriver.findElement(submitButton).click();
    }



}
