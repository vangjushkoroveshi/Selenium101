package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public final WebDriver driver;
    public String baseUrl;
    public WebDriverWait pageWait;
    public String newTabUrl;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        pageWait = new WebDriverWait(this.driver, 10);
        baseUrl = "https://www.lambdatest.com/automation-demos/";
        newTabUrl = "https://www.lambdatest.com/selenium-automation";
    }

}
