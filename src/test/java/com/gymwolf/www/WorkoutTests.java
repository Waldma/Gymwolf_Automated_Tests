package com.gymwolf.www;

import Controllers.PublicMethods;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import viewElements.MainView;
import viewElements.WorkoutView;

import java.util.concurrent.TimeUnit;

public class WorkoutTests {
    private WebDriver driver;

    @Parameters({"browser", "username", "password"})
    @BeforeMethod(alwaysRun = true)
    private void setUp(@Optional("chrome") String browser, String username, String password){
        driver = PublicMethods.setupWebDriver(browser);
        PublicMethods.configureWebDriver(driver);
        PublicMethods.loginToPage(driver, username, password);
    }

    @Parameters({"expectedName", "activity", "notes", "duration", "distance", "heartrate", "calories", "incline", "bodyweight", "date" })
    @Test(groups = {"workoutTests", "smokeTests"})
    public void latestCardioWorkoutTest(String expectedName, String activity, String notes, String duration, String distance, String heartrate, String calories, String incline, String bodyweight, String date){
        driver.findElement(MainView.newWorkoutButton()).click();
        driver.findElement(WorkoutView.cardioWorkoutButton()).click();

        PublicMethods.addNewCardioWorkout(driver, activity, notes, duration, distance, heartrate, calories, incline, bodyweight, date);
        driver.get(PublicMethods.defaultURL);

        String latestWorkoutField = driver.findElement(MainView.latestWorkouts()).getText();
        Assert.assertTrue(latestWorkoutField.contains(expectedName), "cant find right person in feed");
        Assert.assertTrue(latestWorkoutField.contains(notes), "cant find note in feed");
    }



    @AfterMethod(alwaysRun = true)
    private void tearDown() {
        driver.quit();
    }
}
