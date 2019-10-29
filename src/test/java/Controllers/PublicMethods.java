package Controllers;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import viewElements.MainView;
import viewElements.WorkoutView;

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

    public static void addNewCardioWorkout( WebDriver driver, String activity, String notes, String duration, String distance, String heartrate, String calories, String incline, String bodyweight, String date) {
        driver.findElement(WorkoutView.workoutDate()).sendKeys(Keys.chord(Keys.CONTROL, "a"), date);
        driver.findElement(WorkoutView.workoutActivity()).sendKeys(activity);
        driver.findElement(WorkoutView.workoutHeartRate()).sendKeys(heartrate);
        driver.findElement(WorkoutView.workoutCalories()).sendKeys(calories);
        driver.findElement(WorkoutView.workoutDuration()).sendKeys(Keys.chord(Keys.CONTROL, "a"),duration);
        driver.findElement(WorkoutView.workoutDistance()).sendKeys(distance);
        driver.findElement(WorkoutView.workoutIncline()).sendKeys(incline);
        driver.findElement(WorkoutView.workoutBodyweight()).sendKeys(bodyweight);
        driver.findElement(WorkoutView.workoutNotes()).sendKeys(notes);

        driver.findElement(WorkoutView.workoutSaveButton()).click();
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
