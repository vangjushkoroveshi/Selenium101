package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPages extends BasePage {

    public LoginPages(WebDriver driver) {
        super(driver);
    }

    public void visit() {
        driver.get(baseUrl);
    }

    public boolean isLoaded(){

        //Check for login form if it is visible on the page
        WebElement loginform = driver.findElement(By.id("formcontent"));
        return pageWait.until(ExpectedConditions.visibilityOf(loginform)).isDisplayed();
    }

    public void login(String username, String password){

        // Enter User credential and click login
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type=\"submit\"]"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();

    }

    // Check if user is loggedIn successfully
    public boolean isLoggedInSuccessfully(){
        WebElement toastNotification = driver.findElement(By.className("automation__toast"));
        return pageWait.until(ExpectedConditions.invisibilityOf(toastNotification));
    }

}
