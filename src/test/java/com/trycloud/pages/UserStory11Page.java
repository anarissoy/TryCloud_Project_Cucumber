package com.trycloud.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class UserStory11Page extends BasePage {

    @FindBy(css = "li[data-id='spreed']>a>svg")
    public WebElement talkButton;

    @FindBy (css = "input[type='text']")
    public WebElement searchBox;

    @FindBy (xpath = "//span[normalize-space()='User100']")
    public WebElement user100;

    @FindBy (xpath = "//div[@placeholder='Write message, @ to mention someone …']")
    public WebElement msgBox;

    @FindBy (xpath = "//button[@type='submit']")
    public WebElement submitMsg;

    @FindBy (xpath = "//div[@class='rich-text--wrapper']")
    public List<WebElement> msgArea;

    public void verifyMsg(String expectedMsg){
        String str2 = "";
        for (WebElement each: msgArea){
            if(each.getText().equalsIgnoreCase(expectedMsg)){
                str2 += each.getText();
                break;
            }
        }
        Assert.assertEquals(expectedMsg,str2);
    }
}
