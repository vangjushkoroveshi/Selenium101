package Tests;

import Base.BaseTest;
import Pages.EmailPopUpPages;
import Pages.FeedbackPages;
import Pages.LoginPages;
import Pages.NewPages;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LambdaTest extends BaseTest {

    @Test
    public void ShouldBeAbleToLogin() {
        LoginPages loginPage = new LoginPages(driver);
        loginPage.visit();
        assertTrue(loginPage.isLoaded());

        loginPage.login("lambda", "lambda123");
        assertTrue(loginPage.isLoggedInSuccessfully());
    }

    @Test(dependsOnMethods = "ShouldBeAbleToLogin")
    public void validateEmailAlert() throws InterruptedException {

        String email = "vangjushkoroveshi@gmail.com";

        EmailPopUpPages emailCheck = new EmailPopUpPages(driver);
        emailCheck.insertEmail(email);
        assertEquals(email,emailCheck.getAlertMsgAndCloseIt());
    }

    @Test(dependsOnMethods = "validateEmailAlert")
    public void validateFeedbackForm(){

        String rateExperience = "90";

        FeedbackPages feedbackPages = new FeedbackPages(driver);

        feedbackPages.selectFrequentlyPurchaseOnCommerce();
        feedbackPages.selectDecisiveFactors();
        feedbackPages.selectPaymentMethod();
        feedbackPages.enableRatingScaleByAcceptingPurchase();
        assertTrue(feedbackPages.isRatingScaleEnabled());
        assertTrue(feedbackPages.isTextFieldEnabled());
        assertEquals(rateExperience, feedbackPages.selectAndValidateRatingExperience(rateExperience));

    }

    @Test(dependsOnMethods = "validateFeedbackForm")
    public void newTab() throws InterruptedException, IOException, AWTException {
        NewPages newPages = new NewPages(driver);

        newPages.openUrlInANewTab();
        newPages.scrollAndDownloadJenkinsLogo();
    }

    @Test(dependsOnMethods = "newTab")
    public void upload(){
        FeedbackPages feedbackPages = new FeedbackPages(driver);
        feedbackPages.uploadImg();
        assertEquals("your image upload sucessfully!!", feedbackPages.verifyUpload());
    }

    @Test(dependsOnMethods = "upload")
    public void submitAndValidate(){

        FeedbackPages feedbackPages = new FeedbackPages(driver);
        feedbackPages.submit();
        assertEquals("Thank you!", feedbackPages.validateSubmitTitle());
        assertEquals("You have successfully submitted the form.", feedbackPages.validateSubmitMEssage());
    }
}
