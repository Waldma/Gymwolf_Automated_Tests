package viewElements;

import org.openqa.selenium.By;

public class WorkoutView {

//WORKOUT VIEW
    public static By cardioWorkoutButton(){return By.xpath("//a[@data-form='.workout-mode-cardio']");}

//CARDIO WORKOUT VIEW
    public static By workoutDate(){return By.id("workout_display_date");}
    public static By workoutActivity(){return By.id("exe-name");}
    public static By workoutHeartRate(){return By.id("exe-heart-rate");}
    public static By workoutCalories(){return By.id("exe-cal");}
    public static By workoutDuration(){return By.id("exe-dur");}
    public static By workoutDistance(){return By.id("exe-dist");}
    public static By workoutIncline(){return By.id("exe-incline");}
    public static By workoutBodyweight(){return By.id("bodyweight");}
    public static By workoutNotes(){return By.id("notes-area");}

    public static By workoutSaveButton(){return By.xpath("//button[@class='btn btn-success']");}




}
