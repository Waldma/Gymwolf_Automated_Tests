package Controllers;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import viewElements.MainView;

import java.rmi.UnexpectedException;
import java.util.concurrent.TimeUnit;

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

    public static WebDriver setupWebDriver(String browser) {
        switch (browser){
            case "chrome" :
                ChromeDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "firefox" :
                FirefoxDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            default:
                throw new RuntimeException("Unknown browser: " + browser+" \n Change browser value to 'chrome' or 'firefox' ");
        }
    }

    public static void configureWebDriver(WebDriver driver) {
        driver.manage().window().maximize();
        driver.get(defaultURL);
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
    }
}
