package com.gymwolf.www;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import viewElements.LandingView;

import java.util.concurrent.TimeUnit;

public class PublicMethods {
    public static String defaultURL ="https://www.gymwolf.com/staging/";


    public static void loginToPage(WebDriver driver, String username, String password){
        WebDriverWait wait = new WebDriverWait(driver, 1);
        driver.findElement(LandingView.toLoginField()).click();
        wait.until(ExpectedConditions.elementToBeClickable(LandingView.emailField())).sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(LandingView.passwordField())).sendKeys(password);
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
