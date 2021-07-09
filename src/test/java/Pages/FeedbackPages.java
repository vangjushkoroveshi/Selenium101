package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FeedbackPages extends BasePage{

    public FeedbackPages(RemoteWebDriver driver) {
        super(driver);
    }

    public void selectFrequentlyPurchaseOnCommerce(){

        WebElement radioEveryMonth = driver.findElement(By.id("month"));
        radioEveryMonth.click();
    }

    public void selectDecisiveFactors(){
        WebElement discount = driver.findElement(By.name("discounts"));
        discount.click();
    }

    public void selectPaymentMethod(){

        WebElement preferredPayment = driver.findElement(By.id("preferred-payment"));

        Select paymentMethod = new Select(preferredPayment);
        paymentMethod.selectByVisibleText("Credit or Debit card");
    }

    public void enableRatingScaleByAcceptingPurchase(){

        WebElement triedPurchase = driver.findElement(By.id("tried-ecom"));
        triedPurchase.click();
    }

    public boolean isRatingScaleEnabled(){

        WebElement disableBar = driver.findElement(By.className("disablebar"));
        return pageWait.until(ExpectedConditions.visibilityOf(disableBar)).isEnabled();
    }

    public boolean isTextFieldEnabled(){

        WebElement textField = driver.findElement(By.id("comments"));
        return pageWait.until(ExpectedConditions.visibilityOf(textField)).isEnabled();
    }

    public String selectAndValidateRatingExperience(String rateExperience){

        WebElement ratingbar = driver.findElement(By.xpath("//div[@tabindex='0']"));

        while (!ratingbar.getAttribute("aria-valuenow").equals(rateExperience)){
            ratingbar.sendKeys(Keys.ARROW_RIGHT);
        }
        return ratingbar.getAttribute("aria-valuenow");
    }

    public void uploadImg(){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id("comments")));

        WebElement uploadElement = driver.findElement(By.id("file"));

        // enter the file path onto the file-selection input field
        uploadElement.sendKeys(System.getProperty("user.dir")+"\\images\\jenkins.svg");

    }

    public String verifyUpload(){

        // store alert message in a variable
        String uploadMsg = driver.switchTo().alert().getText();

        //close the alert by accept it
        driver.switchTo().alert().accept();

        return uploadMsg;

    }

    public void submit(){

        pageWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("submit-button")))).click();

    }

    public String validateSubmitTitle(){
        return pageWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='container']//h1"))).getText();
    }

    public String validateSubmitMEssage(){

        return pageWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='container']//h1/following-sibling::p"))).getText();

    }

}
