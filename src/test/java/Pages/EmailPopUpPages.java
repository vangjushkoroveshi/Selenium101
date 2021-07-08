package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailPopUpPages extends BasePage{

    public EmailPopUpPages(WebDriver driver) {
        super(driver);
    }

    public void insertEmail(String email) throws InterruptedException {

        WebElement emailInput = driver.findElement(By.id("developer-name"));
        WebElement populateBtn = driver.findElement(By.id("populate"));

        emailInput.sendKeys(email);
        populateBtn.click();

    }

    public String getAlertMsgAndCloseIt(){

        // store alert message in a variable
        String alertMsg = driver.switchTo().alert().getText();

        //close the alert by accept it
        driver.switchTo().alert().accept();

        return alertMsg;

    }

}
