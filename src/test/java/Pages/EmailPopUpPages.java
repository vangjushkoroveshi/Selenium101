package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EmailPopUpPages extends BasePage{

    public EmailPopUpPages(RemoteWebDriver driver) {
        super(driver);
    }

    public void insertEmail(String email) throws InterruptedException {

        WebElement emailInput = driver.findElement(By.id("developer-name"));
        WebElement populateBtn = driver.findElement(By.id("populate"));

        Actions actions = new Actions(driver);
        emailInput.click();
        Thread.sleep(500);
        actions.sendKeys(email);
        actions.build().perform();
//        emailInput.sendKeys(email);
        Thread.sleep(500);
        populateBtn.click();

    }

    public String getAlertMsgAndCloseIt() throws InterruptedException {

        // store alert message in a variable
//        pageWait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);
        String alertMsg = driver.switchTo().alert().getText();

        //close the alert by accept it
        driver.switchTo().alert().accept();

        return alertMsg;

    }

}
