package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    public WebDriver driver;

    @BeforeClass
    public void lunchBrowser(){

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\browser\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("build", "your build name");
//        capabilities.setCapability("name", "your test name");
//        capabilities.setCapability("platform", "Windows 10");
//        capabilities.setCapability("browserName", "Chrome");
//        capabilities.setCapability("version","91.0");

    }

    @AfterClass
    public void teardown(){
        driver.quit();
    }


}
