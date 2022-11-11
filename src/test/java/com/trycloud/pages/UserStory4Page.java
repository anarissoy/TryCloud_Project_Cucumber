package com.trycloud.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class UserStory4Page extends BasePage{

    @FindBy(xpath = "//div[@class='app-content-list-item-line-one']")
    public List<WebElement> contactNamesElements;

    @FindBy (xpath = "//table[@id='filestable']/thead/tr/th[@id='headerSelection']")
    public WebElement checkAll;

    @FindBy (css = "li[data-id='files'] > a > svg > image")
    public WebElement filesModule;

    @FindBy(xpath = "//label[contains(@for,'select-files')]/../input")
    public List<WebElement> checkFileButtons;


    public List<String> getContactNames() {
        List<String> contactNames = new ArrayList<>();
        for (WebElement namesElement : contactNamesElements) {
            contactNames.add(namesElement.getText());
        }
        return contactNames;
    }

    public  void assertCheckButtonsisChecked(){
        for (WebElement checkFileButton : checkFileButtons) {
            Assert.assertTrue(checkFileButton.isSelected());
        }
    }
}
