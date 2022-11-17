package com.trycloud.step_defs;

import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("user on the login page")
    public void user_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("trycloud.url"));
    }
    @When("user use username and password and login")
    public void user_use_username_and_password_and_login() {
        loginPage.login(ConfigurationReader.getProperty("user2"),ConfigurationReader.getProperty("password"));
    }
    @Then("verify the user should be at the dashboard page")
    public void verify_the_user_should_be_at_the_dashboard_page() {
        Assert.assertEquals("Dashboard - Trycloud",Driver.getDriver().getTitle());
    }
    @When("user use {string} and {string} and login")
    public void userUseAndAndLogin(String username, String password) {
        loginPage.login(username,password);
    }

    @Given("user on the dashboard page")
    public void userOnTheDashboardPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("trycloud.url"));
        loginPage.login(ConfigurationReader.getProperty("user2"),ConfigurationReader.getProperty("password"));
        BrowserUtils.waitForPageToLoad(20);
    }
    @Given("user enters {string} and {string} and launched the dashboard page")
    public void userEntersAndAndLaunchedTheDashboardPage(String username, String password) {
        Driver.getDriver().get(ConfigurationReader.getProperty("trycloud.url"));
        loginPage.login(username,password);
        BrowserUtils.waitForPageToLoad(20);
    }
}