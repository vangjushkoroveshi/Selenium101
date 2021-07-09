package Pages;

import org.openqa.selenium.*;
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

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value', '"+email+"')", emailInput);
        populateBtn.click();

    }

    public String getAlertMsgAndCloseIt() throws InterruptedException {

        // store alert message in a variable
        pageWait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertMsg = alert.getText();

        //close the alert by accept it
        alert.accept();

        return alertMsg;

    }

}
