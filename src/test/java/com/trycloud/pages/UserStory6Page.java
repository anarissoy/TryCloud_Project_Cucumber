package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class UserStory6Page extends BasePage{


    //====================================================

    @FindBy (css = "li[data-id='files'] > a > svg > image")
    public WebElement fileButton;

    @FindBy (xpath = "//tr[1]/td[2]/a/span[2]/a[2]/span[1]")
    public WebElement actionsButton;

    @FindBy (xpath = "//*[@id='rightClickMenu']/ul/li[1]")
    public WebElement addToFavorites;

    @FindBy (xpath = "//*[@id='fileList']/tr/td[1]/a/span[1]/span[1]")
    public WebElement verifyFavorites;

    @FindBy (xpath = "//h2[normalize-space()='No favorites yet']")
    public WebElement verifyNoFavorites;

    @FindBy (xpath = "//li[@data-id='favorites']")
    public WebElement favoritesBtn;

    @FindBy (xpath = "(//span[@class='nametext'])[1]")
    public WebElement rightClickOnFile;

    //TC2

    @FindBy (xpath = "//span[@class='icon icon-add']")
    public WebElement addIconButton;

    @FindBy (xpath = "//label[@data-action='upload']")
    public WebElement uploadButton;

    @FindBy (xpath = "//input[@type ='file']")
    public WebElement inputButton;

    @FindBy (css= "#uploadprocessbar")
    public WebElement uploadBar;

    @FindBy (xpath = "//tbody[@id='fileList']/tr")  // //tbody[@id="fileList"]/tr
    public List<WebElement> recommendBtn;

    @FindBy (xpath = "//span[@class='nametext']") // (//span[@class='nametext'])[5]
    public List<WebElement> uploadedFileList;

    public List<String> fileCount(){
        JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        //js.executeScript("window.scrollBy(0,1200)");
        int count = 0;
        List<String> fileList = new ArrayList<>();
        for(int i = 0; i< recommendBtn.size(); i++) {
            BrowserUtils.hover(recommendBtn.get(i));
            recommendBtn.get(i).isEnabled();
            //count++;
            fileList.add(recommendBtn.get(i).getAttribute("data-file"));
        }
        return fileList;
    }

    public void verifyUS8TC2(String verify){
        JavascriptExecutor js = ((JavascriptExecutor) Driver.getDriver());
        js.executeScript("window.scrollBy(0,1000)");
        String after = "";
        String before = "";
        int count = 0;
        for (int i = recommendBtn.size()-1; i >= 0; i--) {
            BrowserUtils.hover(recommendBtn.get(i));
            before += " "+recommendBtn.get(i).getAttribute("data-file");
            //BrowserUtils.waitFor(1);
            recommendBtn.get(i).isEnabled();
            count++;
            if(recommendBtn.get(i).getAttribute("data-file").equals(verify)){
                after += recommendBtn.get(i).getAttribute("data-file");
                break;
            }
        }
        System.out.println(count);
        System.out.println(before);
        Assert.assertTrue(after.equalsIgnoreCase(verify));
    }


    // US7

//    @FindBy (xpath = "//td[@class='filename ui-draggable ui-draggable-handle']")
//    public List<WebElement> listOfFiles;
//
//    public void listOfFiles(){
//        List<String> list = new ArrayList<>();
//        for(int i = 1; i < listOfFiles.size(); i++){
//            list.add(listOfFiles.get(i).getText());
//            System.out.println(listOfFiles.get(i).getText());
//        }
//        Assert.assertTrue(list.contains("JAVA-BAKU"));
//    }
//
//    @FindBy (xpath = "//span[.='New folder']")
//    public WebElement newFolder;
//
//    @FindBy (xpath = "//input[@id='view13-input-folder']")
//    public WebElement inputFolderName;
//
//    @FindBy (xpath = "(//input[@type='submit'])[2]")
//    public WebElement submitFolderName;
//
//    @FindBy (xpath = "//a[@class='filename']")
//    public WebElement newCreated;
//
//    @FindBy (xpath = "//div[@style='background-image:url(/index.php/apps/theming/img/core/filetypes/folder.svg?v=0);']")
//    public List<WebElement> folderType;
//
//    @FindBy (xpath = "//tr[@data-type='file']")
//    public List<WebElement> fileType;
//
//    @FindBy (xpath = "//tr[@data-type='dir']//label")
//    public List<WebElement> folderCheckBox;
//
//    @FindBy (xpath = "//span[@class='innernametext']")
//    public List<WebElement> filesName;
//
//
//    public void selectFolder(){
//        for(int i = 0; i < folderType.size(); i++){
//            if (folderType.get(i).isDisplayed()){
//                //BrowserUtils.waitFor(1);
//                folderCheckBox.get(i).click();
//            }
//        }
//    }
//
//    public void verifyFileName(List<WebElement> listOfElements, String fileName){
//        String str = "";
//        for (WebElement each : listOfElements){
//            if(each.getText().contains(fileName)){
//                str += "" + each.getText();
//                break;
//            }
//        }
//       Assert.assertEquals(fileName,str);
//    }

    // US8  ********************************************************************

//    public void selectTopModule(String topModules){
//        String locator = "li[data-id='"+topModules+"'] > a > svg > image";
//        Driver.getDriver().findElement(By.cssSelector(locator)).click();
//    }
//    public void deleteFile(String deleteF){
//        String a = "ile";
//        String b = "older";
//        if(rightClickMenuDelete.getText().contains("Delete folder")){
//            String locator = "//div[@id='rightClickMenu']/ul/li[6]/a/span/following-sibling::span[.='"+deleteF+b+"']";
//            Driver.getDriver().findElement(By.xpath(locator)).click();
//        }
//        else if (rightClickMenuDelete.getText().contains("Delete files")){
//            String locator = "//div[@id='rightClickMenu']/ul/li[6]/a/span/following-sibling::span[.='"+deleteF+a+"']";
//            Driver.getDriver().findElement(By.xpath(locator)).click();
//        }
//    }
//
//    @FindBy (xpath = "//div[@id='rightClickMenu']/ul/li[6]/a/span/following-sibling::span[starts-with(.,'Delete f')]")
//    public WebElement rightClickMenuDelete;
//
//    @FindBy (xpath = "//a[.='Deleted files']")
//    public WebElement deletedFiles;
//
//
//    public void deletedFiles(String str){
//        String locator = "//a[.='"+str+"']";
//        Driver.getDriver().findElement(By.xpath(locator)).click();
//    }
//
//    @FindBy (xpath = "(//span[@class='innernametext'])[10]")
//    public WebElement deletedFileName;
//
//    public void fileName(){
//        System.out.println(deletedFileName.getText());
//    }
//
//    @FindBy (xpath = "//span[@class='innernametext']")
//    public List<WebElement> filesNameInDeletedPage;
//
//    public void verifyDeletedFileUS8(){
//        String deletedFileInDeletedFilesPage = "";
//        for (WebElement each: filesNameInDeletedPage){
//            if(each.getText().equalsIgnoreCase(deletedFileName.getText())){
//                break;
//            }
//            deletedFileInDeletedFilesPage += ""+each.getText();
//        }
//        Assert.assertEquals(deletedFileName.getText(), deletedFileInDeletedFilesPage);
//    }




}
