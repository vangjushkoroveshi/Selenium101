package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class NewPages extends BasePage{

    public NewPages(RemoteWebDriver driver) {
        super(driver);
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;
    ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());

    public void openUrlInANewTab() throws InterruptedException {

        js.executeScript("window.open('"+newTabUrl+"','_blank');");

        tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

    }


    public void scrollAndDownloadJenkinsLogo() throws AWTException, InterruptedException {

        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/section[7]/div/h2")));
        pageWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[@title='Jenkins']"))));

        String src = driver.findElement(By.xpath("//img[@title='Jenkins']")).getAttribute("src");
        js.executeScript("window.open('"+src+"');");

        tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(2));

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_S);

        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_ENTER);

        //Navigate back to previews tab

        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(2000);

    }
}
