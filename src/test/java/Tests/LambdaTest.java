package Tests;

import Base.BaseTest;
import Pages.EmailPopUpPages;
import Pages.FeedbackPages;
import Pages.LoginPages;
import Pages.NewPages;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LambdaTest extends BaseTest {

    @Test
    @Parameters({"username","password"})
    public void ShouldBeAbleToLogin(String username, String password) {
        LoginPages loginPage = new LoginPages(driver);
        loginPage.visit();
        assertTrue(loginPage.isLoaded());

        loginPage.login(username, password);
        assertTrue(loginPage.isLoggedInSuccessfully());
    }

    @Test(dependsOnMethods = "ShouldBeAbleToLogin")
    @Parameters({"email"})
    public void validateEmailAlert(String email) throws InterruptedException {
        EmailPopUpPages emailCheck = new EmailPopUpPages(driver);
        emailCheck.insertEmail(email);
        assertEquals(email,emailCheck.getAlertMsgAndCloseIt());
    }

    @Test(dependsOnMethods = "validateEmailAlert")
    @Parameters({"rateExperience"})
    public void validateFeedbackForm(String rateExperience){

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
    public void newTab() throws InterruptedException, AWTException {
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
