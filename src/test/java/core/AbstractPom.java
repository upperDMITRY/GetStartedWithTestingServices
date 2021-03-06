package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class AbstractPom {

    private WebDriver driver;

    public AbstractPom(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(driver)),this);
    }
}
