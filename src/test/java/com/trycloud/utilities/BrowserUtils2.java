package com.trycloud.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class BrowserUtils2 {
    //Methods are static. Because we do not want to create an object to call those methods.
    // We just want to call those methods with class name. That is why they are static type


    /**
     * This method is used to pause the code for given seconds
     * It is static method we can call with class name
     * BrowserUtils.sleep(3);
     * @param seconds
     */
    public static void sleep(int seconds){
         // 1 second = 1000 millis
        // millis = seconds*1000
         try {
             Thread.sleep(seconds*1000);
         }catch(InterruptedException e){
             e.printStackTrace();
             System.out.println("Exception happened in sleep method!");
         }
     }


     //Method info:
    //• Name: verifyTitle()
    //• Return type: void
    //• Arg1: WebDriver
    //• Arg2: String expectedTitle
    // BrowserUtils.verifyTitle(driver,"Google")
    public static void verifyTitle(WebDriver driver, String expectedTitle){
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    public static void verifyTitleJunit(String expectedTitle){

        Assert.assertEquals(expectedTitle,Driver.getDriver().getTitle());
    }

    public static void waitForInvisibilityOf(WebElement element, int second){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),second);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void waitForVisibilityOf(WebElement element, int second){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),second);
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    /**
     * This method will accept dropdown as a WebElement
     * and return all the options' text in a List of String
     * @return List<String>
     */
    public static List<String> dropdownOptionsAsString(WebElement dropdownElement){

        Select select = new Select(dropdownElement);

        //List of all ACTUAL month <options> as a WebElement
        List<WebElement> actualOptionsAsWebElement = select.getOptions();

        //List of all ACTUAL month options as a String
        List<String> actualOptionsAsString = new ArrayList<>();

        // with using for loop we will convert each WebElement of options to String wit using getText() method
        // with using add() method we will add each String option in List<String> actual options as String
        for (WebElement each : actualOptionsAsWebElement) {
            actualOptionsAsString.add(each.getText());
        }
        return actualOptionsAsString;
    }

    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue) {
        for (WebElement eachButton : radioButtons) {
            if (eachButton.getAttribute("value").equalsIgnoreCase(attributeValue)) {
                eachButton.click();
            }
        }
    }



    public static void switchToWindow(String targetTitle) {
        String origin = Driver. getDriver ().getWindowHandle();
        for (String handle : Driver. getDriver ().getWindowHandles()) {
            Driver. getDriver ().switchTo().window(handle);
            if (Driver. getDriver ().getTitle().equals(targetTitle)) {
                return ;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }


}
