package com.trycloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserStory2Page extends BasePage{

    @FindBy (xpath = "//p[normalize-space()='Wrong username or password.']")
    public WebElement errorMsg;

}
