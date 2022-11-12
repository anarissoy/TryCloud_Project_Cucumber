package com.trycloud.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MyMethods {

    public static String returnNumberFromString(String str){ // for future
        String number = "";
        for(int i = 0; i < str.length(); i++){
            if (Character.isDigit(str.charAt(i))){
                number += str.charAt(i);
            }
        }
        return number;
    }

    public void verifyFileName(List<WebElement> listOfElements, String expected){
        String actual = "";
        for (WebElement each : listOfElements){
            if(each.getText().equalsIgnoreCase(expected)){
                actual += "" + each.getText();
                break;
            }
        }
        System.out.println(actual);
        Assert.assertEquals(expected,actual);
    }

    public  void assertCheckButtonsisChecked(List<WebElement> webElement){
        for (WebElement checkFileButton : webElement) {
            Assert.assertTrue(checkFileButton.isSelected());
        }
    }

    public List<String> countFileByGetAttribute(List<WebElement> webElement){
        int count = 0;
        List<String> fileList = new ArrayList<>();
        for(int i = 0; i< webElement.size(); i++) {
            BrowserUtils.hover(webElement.get(i));
            webElement.get(i).isEnabled();
            //count++;
            fileList.add(webElement.get(i).getAttribute("data-file"));
        }
        return fileList;
    }

    public String searchList(String verify, List<WebElement> webElement){
        String set = "";
        for(int i = 0; i<webElement.size()-1; i++){
            BrowserUtils.hover(webElement.get(i));
            BrowserUtils.waitFor(1);
            //setSearchList.add(searchList.get(i).getText());
            set += " " + webElement.get(i).getText();
            //searchList.get(i).isDisplayed();
        }
        System.out.println(set);
        return set;
    }
}
