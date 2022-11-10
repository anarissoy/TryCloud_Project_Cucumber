package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class UserStory3Page extends BasePage{


    @FindBy (xpath = "//ul[@id='appmenu']/li")
    public List<WebElement> topModules;

    @FindBy(xpath = "//ul[@id='appmenu']/li[@id='more-apps']/preceding-sibling::li")
    public List<WebElement> modules;

    public List<String> getTopModulesText(){
        List<String> modulesText = new ArrayList<>();
        for(int i = 0; i<modules.size(); i++){
            BrowserUtils.hover(modules.get(i));
            modules.get(i).isEnabled();
            BrowserUtils.waitFor(1);
            modulesText.add(modules.get(i).getText());
        }
        return modulesText;
    }

    public WebElement findModuleElements(String element){

        String xPath="//ul[@id='appmenu']//a//span[contains(text(),'"+element+"')]";

        return Driver.getDriver().findElement(By.xpath(xPath));
    }


    public void topModules(String topModules){
        String locator = "//a[@aria-label='"+topModules+"']";
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath(locator)).isDisplayed());
        System.out.println(topModules+" Module is Displayed - "+Driver.getDriver().findElement(By.xpath(locator)).isDisplayed());
        Driver.getDriver().findElement(By.xpath(locator)).click();
    }

}
