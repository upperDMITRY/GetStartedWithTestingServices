package pom1;

import core.AbstractPom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPom {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submitBtn;

    @FindBy(name = "login")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(partialLinkText = "Sign")
    public WebElement signInBtn;
}
