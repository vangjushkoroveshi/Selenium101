package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class NewPages extends BasePage{

    public NewPages(WebDriver driver) {
        super(driver);
    }

    JavascriptExecutor js = (JavascriptExecutor) driver;
    ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());

    public void openUrlInANewTab() throws InterruptedException {

        js.executeScript("window.open('"+newTabUrl+"','_blank');");

        tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

    }


    public void scrollAndDownloadJenkinsLogo(){

        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/section[7]/div/h2")));
        pageWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//img[@title='Jenkins']"))));

//        String src = driver.findElement(By.xpath("//img[@title='Jenkins']")).getAttribute("src");
//        js.executeScript("window.open('"+src+"','_blank');");
//        tabs = new ArrayList<> (driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(2));

//
//        //Locate Image
//        WebElement Image = driver.findElement(By.xpath("//img[@title='Jenkins']"));
//
//        String wget_commond = "cmd /c C:\\Users\\vangjush\\Downloads\\wget.exe -P C:\\Users\\vangjush\\Downloads --no-check-certificate" +src;
//
//        try {
//            Process exec = Runtime.getRuntime().exec(wget_commond);
//            int exitVal = exec.waitFor();
//            System.out.println("Exit value: " + exitVal);
//        } catch (InterruptedException | IOException ex) {
//            System.out.println(ex.toString());
//        }

        //Navigate back to previews tab

        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));

    }
}
