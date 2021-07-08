package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    public RemoteWebDriver driver;
    String username = "vangjushkoroveshi";
    String accessKey = "hvHHh4MLrulWRIrqfwQW1arpxxHYNNbraAXnx1YFVpq06Wokij";

    @BeforeClass
    public void lunchBrowser(){

//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\browser\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platform", "Windows 10");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("version", "91.0"); // If this cap isn't specified, it will just get the any available one
        capabilities.setCapability("resolution","1024x768");
        capabilities.setCapability("build", "First Test");
        capabilities.setCapability("name", "Sample Test");
        capabilities.setCapability("network", true); // To enable network logs
        capabilities.setCapability("visual", true); // To enable step by step screenshot
        capabilities.setCapability("video", true); // To enable video recording
        capabilities.setCapability("console", true); // To capture console logs

        try {
            driver= new RemoteWebDriver(new URL("https://"+username+":"+accessKey+"@hub.lambdatest.com/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        }

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();


    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }


}
