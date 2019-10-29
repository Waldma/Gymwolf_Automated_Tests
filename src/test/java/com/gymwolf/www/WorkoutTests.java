package com.gymwolf.www;

import Controllers.PublicMethods;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import viewElements.MainView;
import viewElements.WorkoutView;

import java.util.concurrent.TimeUnit;

public class WorkoutTests {
    private WebDriver driver;

    @Parameters({"browser", "username", "password"})
    @BeforeMethod(alwaysRun = true)
    private void setUp(@Optional("chrome") String browser, String username, String password){
        switch (browser){
            case "chrome" :
                ChromeDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox" :
                FirefoxDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("unknown browser: "+browser+" Starting default browser chrome instead");
                ChromeDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.get(PublicMethods.defaultURL);
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);

        PublicMethods.loginToPage(driver, username, password);
    }

    @Test
    public void LatestCardioWorkoutTest(String expectedName, String activity, String notes, String duration, String distance, String hearthrate, String calories, String incline, String bodyweight, String date){
        driver.findElement(MainView.newWorkoutButton()).click();
        driver.findElement(WorkoutView.cardioWorkoutButton()).click();

        PublicMethods.addNewCardioWorkout(driver, activity, notes, duration, distance, hearthrate, calories, incline, bodyweight, date);


    }



    @AfterMethod(alwaysRun = true)
    private void tearDown() {
        driver.quit();
    }
}