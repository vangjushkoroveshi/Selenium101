package Base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePages {

    public final RemoteWebDriver driver;
    public String baseUrl;
    public WebDriverWait pageWait;
    public String newTabUrl;
    public JavascriptExecutor js;

    public BasePages(RemoteWebDriver driver) {
        this.driver = driver;
        pageWait = new WebDriverWait(this.driver, 10);
        js = (JavascriptExecutor) driver;
        baseUrl = "https://www.lambdatest.com/automation-demos/";
        newTabUrl = "https://www.lambdatest.com/selenium-automation";
    }

}
