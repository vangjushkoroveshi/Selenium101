package Base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public RemoteWebDriver driver;
    String username = "vangjushkoroveshi";
    String accessKey = "hvHHh4MLrulWRIrqfwQW1arpxxHYNNbraAXnx1YFVpq06Wokij";

    @Parameters({"platform","browser","version"})
    @BeforeClass
    public void lunchBrowser(String platform, String browser, String version) throws MalformedURLException {

        if (browser.equals("Chrome")){
            ChromeOptions options = new ChromeOptions();
            Map<String, Object> prefs = new HashMap<String, Object>();
            prefs.put("download.prompt_for_download", false);
            options.setExperimentalOption("prefs", prefs);

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platform", platform);
            capabilities.setCapability("browserName", browser);
            capabilities.setCapability("version", version); // If this cap isn't specified, it will just get the any available one
            capabilities.setCapability("resolution","1024x768");
            capabilities.setCapability("build", "Test");
            capabilities.setCapability("name", "Sample Test");
            capabilities.setCapability("selenium_version","3.141.59");
            capabilities.setCapability("network", true); // To enable network logs
            capabilities.setCapability("visual", true); // To enable step by step screenshot
            capabilities.setCapability("video", true); // To enable video recording
            capabilities.setCapability("console", true); // To capture console logs
            capabilities = DesiredCapabilities.chrome();
            options.merge(capabilities);

            driver= new RemoteWebDriver(new URL("https://"+username+":"+accessKey+"@hub.lambdatest.com/wd/hub"), options);
        } else {

            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platform", platform);
            capabilities.setCapability("browserName", browser);
            capabilities.setCapability("version", version); // If this cap isn't specified, it will just get the any available one
            capabilities.setCapability("resolution","1024x768");
            capabilities.setCapability("build", "Test");
            capabilities.setCapability("name", "Sample Test");
            capabilities.setCapability("selenium_version","3.141.59");
            capabilities.setCapability("network", true); // To enable network logs
            capabilities.setCapability("visual", true); // To enable step by step screenshot
            capabilities.setCapability("video", true); // To enable video recording
            capabilities.setCapability("console", true); // To capture console logs
            driver= new RemoteWebDriver(new URL("https://"+username+":"+accessKey+"@hub.lambdatest.com/wd/hub"), capabilities);
        }


        driver.setFileDetector(new LocalFileDetector());
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }


}
