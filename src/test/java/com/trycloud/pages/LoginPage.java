package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "input#user")
    public WebElement inputUsername;

    @FindBy (css = "input#password")
    public WebElement inputPassword;

    @FindBy (css = "input#submit-form")
    public WebElement loginButton;

    public void login(String userName, String passWord){
        inputUsername.sendKeys(userName);
        inputPassword.sendKeys(passWord);
        loginButton.click();
    }
}
