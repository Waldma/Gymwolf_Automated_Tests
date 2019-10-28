package com.gymwolf.www;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import viewElements.LandingView;

public class PublicMethods {
    public static String defaultURL ="https://www.gymwolf.com/staging/";


    public static void loginToPage(WebDriver driver, String username, String password){
       /* wait.until(ExpectedConditions.elementToBeClickable(LandingView.toLoginField())).click();
        wait.until(ExpectedConditions.elementToBeClickable(LandingView.emailField())).sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(LandingView.passwordField())).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(LandingView.loginButton())).click(); */
        driver.findElement(LandingView.toLoginField()).click();
        driver.findElement(LandingView.emailField()).sendKeys(username);
        driver.findElement(LandingView.passwordField()).sendKeys(password);
        driver.findElement(LandingView.loginButton()).click();
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
