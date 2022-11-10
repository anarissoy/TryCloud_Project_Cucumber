package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserStory13Page extends BasePage {

    Faker faker = new Faker();

    @FindBy(css = "#new-contact-button")
    public WebElement createNewContactBtn;

    @FindBy(css = "input[inputmode='tel']")
    public WebElement inputTel;

    @FindBy(css = "input[inputmode='email']")
    public WebElement inputEmail;

    @FindBy(xpath = "//div[normalize-space()='Address']/input")
    public WebElement inputAddress;

    @FindBy(xpath = "//div[normalize-space()='Postal code']/input")
    public WebElement inputPostalCode;

    @FindBy(xpath = "//div[normalize-space()='City']/input")
    public WebElement inputCity;

    @FindBy(xpath = "//div[normalize-space()='State or province']/input")
    public WebElement inputState;

    @FindBy(xpath = "//div[normalize-space()='Country']/input")
    public WebElement inputCountry;

    @FindBy(xpath = "//h2/input[@type='text']")
    public WebElement inputName;

    @FindBy(xpath = "//li[@data-id='contacts']/a[@aria-label='Contacts']")
    public WebElement clickContactBtn;

    public void verifyUS13(){
        for (int i = 1; i <= 3; i++) {
            WebElement set = Driver.getDriver().findElement(By.xpath("(//div[@class='app-content-list-item-line-one'])[" + i + "]"));
            if (set.isDisplayed()) {
                Assert.assertTrue(set.isDisplayed());
            }
            System.out.println(set.getText());
        }
    }

}
