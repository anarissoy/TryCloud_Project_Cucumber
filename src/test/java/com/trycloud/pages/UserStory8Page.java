package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserStory8Page extends BasePage{

    public UserStory8Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void selectTopModule(String topModules){
        String locator = "li[data-id='"+topModules+"'] > a > svg > image";
        Driver.getDriver().findElement(By.cssSelector(locator.toLowerCase().trim())).click();
    }
    public void deleteFile(String deleteF){
        String a = "ile";
        String b = "older";
        if(rightClickMenuDelete.getText().contains("Delete folder")){
            String locator = "//div[@id='rightClickMenu']/ul/li[6]/a/span/following-sibling::span[.='"+deleteF+b+"']";
            Driver.getDriver().findElement(By.xpath(locator)).click();
        }
        else if (rightClickMenuDelete.getText().contains("Delete file")){
            String locator = "//div[@id='rightClickMenu']/ul/li[6]/a/span/following-sibling::span[.='"+deleteF+a+"']";
            Driver.getDriver().findElement(By.xpath(locator)).click();
        }
    }

    @FindBy (xpath = "//div[@id='rightClickMenu']/ul/li[6]/a/span/following-sibling::span[contains(.,'Delete f')]")
    public WebElement rightClickMenuDelete;

    @FindBy (xpath = "//a[.='Deleted files']")
    public WebElement deletedFiles;


    public void deletedFiles(String str){
        String locator = "//a[.='"+str+"']";
        Driver.getDriver().findElement(By.xpath(locator)).click();
    }

    @FindBy (xpath = "(//span[@class='innernametext'])[6]")
    public WebElement deletedFileName;

    public void fileName(){
        System.out.println(deletedFileName.getText());
    }

    @FindBy (xpath = "//span[@class='innernametext']")
    public List<WebElement> filesNameInDeletedPage;

    public void verifyDeletedFileUS8(){
        String deletedFileInDeletedFilesPage = "";
        for (WebElement each: filesNameInDeletedPage){
            if(each.getText().equalsIgnoreCase(deletedFileName.getText())){
                break;
            }
            deletedFileInDeletedFilesPage += ""+each.getText();
        }
        Assert.assertEquals(deletedFileName.getText(), deletedFileInDeletedFilesPage);
    }
}
