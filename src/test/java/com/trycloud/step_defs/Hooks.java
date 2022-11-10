package com.trycloud.step_defs;

import com.trycloud.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    //@Before()
    public void setupScenario(){
        System.out.println("Setting up browser using cucumber @Before each scenario");
        Driver.getDriver().get("myURL");
    }

    //@Before (value = "@login", order=2)
    public void setupForLogin(){
        // If you want any code to run before any specific feature/scenario,
        // you can use value= "@tagname" to determine this
        System.out.println("Setting up browser using cucumber @Before @login scenario");
    }

    //@Before (value="@db" , order=3)
    public void setupDatabaseScenario(){
    }

    @After
    public void teardownScenario(Scenario scenario) {
        // We will implement taking screenshot in this method
        //System.out.println("It will be closing browser using cucumber @After each scenario");

        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }
    //@BeforeStep
    public void setupScenarioStep(){
        System.out.println("Setting up browser using cucumber @Before each scenario step");
    }

   // @BeforeStep
    public void setupScenarioStepForLogin(){
        System.out.println("Setting up browser using cucumber @Before each scenario step for login");
    }


}
