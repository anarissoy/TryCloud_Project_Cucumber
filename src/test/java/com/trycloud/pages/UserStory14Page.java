package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils;
import org.junit.Assert;
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

    public String getSearchList(String verify){
        //List<String> setSearchList = new ArrayList<>();
        String set = "";
        for(int i = 0; i<searchList.size()-1; i++){
            BrowserUtils.hover(searchList.get(i));
            BrowserUtils.waitFor(1);
            //setSearchList.add(searchList.get(i).getText());
            set += " " + searchList.get(i).getText();
            //searchList.get(i).isDisplayed();
        }
        System.out.println(set);
        return set;
    }

//    public void verifySearchList(String result){
//        List<String> actualSearchList = getSearchList();
//        String verify = "";
//        for ( String each: actualSearchList){
//            if(each.contains(result)){
//                verify += " "+each;
//            }
//        }
//        System.out.println(verify);
//        Assert.assertTrue(verify.contains(result));
//    }
}
