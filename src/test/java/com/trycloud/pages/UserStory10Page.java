package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class UserStory10Page extends BasePage {

    @FindBy(css = "#app-settings-header > button")
    public WebElement settingsBtn;

    @FindBy(xpath = "(//input[@type='checkbox'])[3]")
    public WebElement thirdCheckBox;

    @FindBy(xpath = "//label[.='Show hidden files']")
    public WebElement thirdCheckBoxClick;

    @FindBy(xpath = "(//input[@type='checkbox'])[1]")
    public WebElement firstCheckBox;

    @FindBy(xpath = "//label[.='Show rich workspaces']")
    public WebElement firstCheckBoxClick;

    @FindBy(xpath = "(//input[@type='checkbox'])[2]") // Show recommendations
    public WebElement secondCheckBox;

    @FindBy(xpath = "//label[.='Show recommendations']")
    public WebElement secondCheckBoxClick;

    @FindBy(css = "#quota")  // #quota  // #quota>a>p
    public WebElement checkStorage;

    public void deleteFile(String input) {
        Actions actions = new Actions(Driver.getDriver());
        for (int i = 0; i < new UserStory6Page().recommendBtn.size(); i++) {
            BrowserUtils.hover(new UserStory6Page().recommendBtn.get(i));
            new UserStory6Page().recommendBtn.get(i).isEnabled();
            if (new UserStory6Page().recommendBtn.get(i).getAttribute("data-file").equals(input)) {
                actions.contextClick(new UserStory6Page().recommendBtn.get(i)).perform();
                BrowserUtils.waitFor(1);
                new UserStory6Page().deleteContextMenu.click();
                BrowserUtils.waitFor(1);
                break;
            }
        }

    }


}
