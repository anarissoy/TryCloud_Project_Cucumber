package com.trycloud.utilities;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

    public static void getDownloadedFile(String fileName) {
        File fileLocation = new File("/Users/seraytugcu/Downloads/");
        System.out.println(fileLocation);
        File[] Allfile = fileLocation.listFiles();
        assert Allfile != null;
        for (File file : Allfile) {
            if (file.getName().equals(fileName)) {
                System.out.println("Downloaded");
            }
        }
    }
    public static void takeScreenShot(String testName) throws IOException {
        LocalDateTime localDateTime = LocalDateTime.now();
        String timeFormat = DateTimeFormatter.ofPattern("MMM-dd-yyyy_HH-mm").format(localDateTime);
        TakesScreenshot screenshot = ((TakesScreenshot) Driver.getDriver());
        File file = screenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(testName + "_" + timeFormat + ".png");
        FileUtils.copyFile(file, destination);
    }


    public String verifyDownloadedFile(String fileName){
        File fileLocation = new File("C:\\Users\\TRIADA\\Downloads");
        File[] files = fileLocation.listFiles();

        for (File file : files) {
            if (file.getName().equals(fileName)) {
                return file.getName();
            }
        }
        return null;
    }


    public void hoverImages(List<WebElement> element) {
        Actions actions = new Actions(Driver.getDriver());
        int i = 1;
        String s;
        for (WebElement each : element) {
            actions.moveToElement(each).build().perform();
            s = Driver.getDriver().findElement(By.xpath("(//div[@class='figcaption']/h5)[" + i + "]")).getText();
            i++;
            System.out.println(s);
        }

    }

//    List<WebElement> checkboxes = new ArrayList<>(Arrays.asList(filesPage.showRichWorkspacesCheckbox, filesPage.showRecommendationsCheckbox, filesPage.showHiddenFilesCheckbox));
//        for (WebElement each : checkboxes) {
//        Assert.assertTrue(each.isEnabled());
//    }
}
