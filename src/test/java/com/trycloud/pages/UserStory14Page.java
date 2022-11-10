package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class UserStory14Page extends BasePage{

    @FindBy (xpath = "//span[@aria-label='Magnify icon']//*[name()='svg']")
    public WebElement lupaClick;

    @FindBy (xpath = "//input[@type='search']")
    public WebElement searchBox;


    @FindBy (xpath = "//div[@id=\"header-menu-unified-search\"]//ul[@aria-label='Conversations']/li")
    public List <WebElement> searchList;

    public List<String> getSearchList(){
        List<String> setSearchList = new ArrayList<>();
        for(int i = 0; i<searchList.size()-1; i++){
            BrowserUtils.hover(searchList.get(i));
            BrowserUtils.waitFor(1);
            setSearchList.add(searchList.get(i).getText());
            searchList.get(i).isDisplayed();
        }
        return setSearchList;
    }
}
