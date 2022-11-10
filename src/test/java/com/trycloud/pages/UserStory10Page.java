package com.trycloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserStory10Page extends BasePage{

    @FindBy (css = "#app-settings-header > button")
    public WebElement settingsBtn;

    @FindBy (xpath = "(//input[@type='checkbox'])[3]")
    public WebElement thirdCheckBox;

    @FindBy (xpath = "//label[.='Show hidden files']")
    public WebElement thirdCheckBoxClick;

    @FindBy (xpath = "(//input[@type='checkbox'])[1]")
    public WebElement firstCheckBox;

    @FindBy (xpath = "//label[.='Show rich workspaces']")
    public WebElement firstCheckBoxClick;

    @FindBy (xpath = "(//input[@type='checkbox'])[2]") // Show recommendations
    public WebElement secondCheckBox;

    @FindBy (xpath = "//label[.='Show recommendations']")
    public WebElement secondCheckBoxClick;

    @FindBy (css = "#quota")  // #quota  // #quota>a>p
    public WebElement checkStorage;


}
