package com.trycloud.utilities;

import org.junit.Assert;
import org.openqa.selenium.By;
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

    public List<String> countFileByGetAttribute(List<WebElement> webElement, String attribute){
        int count = 0;
        List<String> fileList = new ArrayList<>();
        for(int i = 0; i< webElement.size(); i++) {
            BrowserUtils.hover(webElement.get(i));
            webElement.get(i).isEnabled();
            //count++;
            fileList.add(webElement.get(i).getAttribute(attribute));
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

    public int returnNumberFromUsage(WebElement element){

        String[] text = element.getText().split(" ");
        return Integer.valueOf(text[0]);

    }

    public void selectFromAddIconDropdown(List<WebElement> listOfElement, String string){
        for (WebElement each: listOfElement){
            if (each.getText().equalsIgnoreCase(string)){
                each.click();
                break;
            }
        }
    }

    public WebElement getModules(String field){
        String locator = "//input[@type ='"+field+"']";
        return Driver.getDriver().findElement(By.xpath(locator));
    }

//    List<WebElement> checkboxes = new ArrayList<>(Arrays.asList(filesPage.showRichWorkspacesCheckbox, filesPage.showRecommendationsCheckbox, filesPage.showHiddenFilesCheckbox));
//        for (WebElement each : checkboxes) {
//        Assert.assertTrue(each.isEnabled());
//    }
}
