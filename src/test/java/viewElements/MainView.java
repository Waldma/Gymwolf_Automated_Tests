package viewElements;

import org.openqa.selenium.By;

public class MainView {

// LANDING ELEMENTS
    public static By toLoginField(){
        return By.xpath("//a[@href='#login-front']");
    }
    public static By emailField(){
        return By.xpath(("//div[@id='login-front']/div[@class='modal-dialog']//form//input[@name='email']"));
    }
    public static By passwordField(){
        return By.xpath("//div[@id='login-front']/div[@class='modal-dialog']//form//input[@name='password']");
    }
    public static By loginButton(){
        return By.xpath("//div[@id='login-front']/div[@class='modal-dialog']/div[@class='modal-content']//form//button[@type='submit']");
    }

    public static By invalidLoginErrorField(){ return By.xpath("//div[@class='alert alert-danger']");}

// HEADER ELEMENTS
    public static By nameMenuDropdown(){return By.xpath("//span[@class='menu-name-label']"); }
        public static By logOutButton(){
        return By.xpath("//div[@id='main-menu']/ul[@class='nav navbar-nav navbar-right']//ul[@class='dropdown-menu']//a[@href='/staging/logout']");
        }

//MAIN PAGE VIEW
    public static By newWorkoutButton(){return By.xpath("//a[@class='btn btn-lg btn-block btn-success']");}






}


