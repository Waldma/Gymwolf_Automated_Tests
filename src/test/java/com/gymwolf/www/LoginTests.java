package com.gymwolf.www;
import Controllers.PublicMethods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import viewElements.MainView;

public class LoginTests {
   private WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod(alwaysRun = true)
    private void setUp(@Optional("chrome") String browser){
        driver = PublicMethods.setupWebDriver(browser);
        PublicMethods.configureWebDriver(driver);
    }

    //test1234@tetsing.com Parool123 Tamm Tammemäe
    @Parameters({"username", "password", "expectedName"})
    @Test(groups = {"positiveTests", "smokeTests"})
    public void positiveLoginTest(String username, String password, String expectedName){
        PublicMethods.loginToPage(driver, username, password);
        Assert.assertTrue(driver.findElement(MainView.nameMenuDropdown()).getText().contains(expectedName), "Cant find user: "+username+" logged in.");
        driver.findElement(MainView.nameMenuDropdown()).click();
        Assert.assertTrue(driver.findElement(MainView.logOutButton()).isDisplayed(), "Logout button is not visible.");
    }

    @Parameters({"username", "password", "expectedMessage"})
    @Test(groups = {"negativeTests", "smokeTests"})
    public void negativeLoginTest(String username, String password, String expectedMessage){
        PublicMethods.loginToPage(driver, username, password);
        String actualMessage = driver.findElement(MainView.invalidLoginErrorField()).getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage), "Expected: \n"+expectedMessage+"\n but got: \n"+actualMessage);
    }

    @AfterMethod(alwaysRun = true)
    private void tearDown(){
        driver.quit();
    }
}
