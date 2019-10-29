package Controllers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import viewElements.MainView;

public class PublicMethods {
    public static String defaultURL ="https://www.gymwolf.com/staging/";

    public static void loginToPage(WebDriver driver, String username, String password){
        WebDriverWait wait = new WebDriverWait(driver, 1);
        driver.findElement(MainView.toLoginField()).click();
        wait.until(ExpectedConditions.elementToBeClickable(MainView.emailField())).sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(MainView.passwordField())).sendKeys(password);
        driver.findElement(MainView.loginButton()).click();
    }

    public static void addNewCardioWorkout( WebDriver driver, String activity, String notes, String duration, String distance, String hearthrate, String calories, String incline, String bodyweight, String date) {
    

    }

    //for debugging
    public static void sleep(long m) {
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
