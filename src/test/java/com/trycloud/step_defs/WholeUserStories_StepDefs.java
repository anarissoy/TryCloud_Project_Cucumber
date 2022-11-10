package com.trycloud.step_defs;


import com.trycloud.pages.*;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class WholeUserStories_StepDefs {

    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();

    UserStory2Page userStory2Page = new UserStory2Page();
    UserStory3Page userStory3Page = new UserStory3Page();
    UserStory4Page userStory4Page = new UserStory4Page();
    UserStory6Page userStory6Page = new UserStory6Page();
    UserStory7Page userStory7Page = new UserStory7Page();
    UserStory8Page userStory8Page = new UserStory8Page();
    UserStory9Page userStory9Page = new UserStory9Page();
    UserStory10Page userStory10Page = new UserStory10Page();
    UserStory11Page userStory11Page = new UserStory11Page();
    UserStory13Page userStory13Page = new UserStory13Page();
    UserStory14Page userStory14Page = new UserStory14Page();
    Faker faker = new Faker();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("trycloud.url"));
    }

    @When("user enters {string} and {string}")
    public void user_enters_and(String string, String string2) {

        loginPage.login(string, string2);
    }

    @When("the user clicks the Files module")
    public void the_user_clicks_the_files_module() {
        BrowserUtils.waitFor(2);
        userStory6Page.fileButton.click();
        BrowserUtils.waitFor(4);
    }

    /**
     * USER STORY 2 ******************************************************************************
     */
    @Then("{string} message should be displayed")
    public void messageShouldBeDisplayed(String message) {
        Assert.assertEquals(message, userStory2Page.errorMsg.getText());
    }

    /**
     * USER STORY 3 ********************************************************************************
     */
    @Then("Verify the user see the following modules {string}")
    public void verifyTheUserSeeTheFollowingModules(String modules) {
        userStory3Page.topModules(modules);

    }

    // second approach to solve US3
    @Then("Verify the user see the following modules:")
    public void verifyTheUserSeeTheFollowingModules(List<String> expectedModuleNames) {

        List<String> actualModuleNames = userStory3Page.getTopModulesText();
        Assert.assertEquals(expectedModuleNames, actualModuleNames);
    }

    /**
     * USER STORY4 TC2  .  TC1 BUG REPORT  Expected :Files - Trycloud QA
     * Actual   :Files - Trycloud
     */
    @And("user click the top-left checkbox of the table")
    public void userClickTheTopLeftCheckboxOfTheTable() {
        BrowserUtils.waitFor(4);
        userStory4Page.checkAllFilesButton.click();
    }

    @Then("verify all the files are selected")
    public void verifyAllTheFilesAreSelected() {
        Assert.assertTrue(BrowserUtils.isAllSelected(userStory4Page.checkFileButtons));
    }

    /**
     * UserStory 5 ****************************************************************************
     */
    @And("the users click action-icon from any file on the page")
    public void theUsersClickActionIconFromAnyFileOnThePage() {
        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(userStory6Page.rightClickOnFile).perform();
    }

    @And("user choose the Add to favorites option")
    public void userChooseTheAddToFavoritesOption() {
        BrowserUtils.waitFor(1);
        if (userStory6Page.addToFavorites.getText().equalsIgnoreCase("Remove from favorites")) {
            Actions actions = new Actions(Driver.getDriver());
            actions.doubleClick(userStory6Page.favoritesBtn).build().perform();
            BrowserUtils.waitFor(1);
        } else {
            userStory6Page.addToFavorites.click();
            BrowserUtils.waitFor(1);
        }
    }

    @Then("Verify the chosen file is listed on the table")
    public void verifyTheChosenFileIsListedOnTheTable() {
        Assert.assertFalse(userStory6Page.verifyFavorites.getText().equalsIgnoreCase("No favorites yet"));
    }

    /**
     * USER STORY 6 TC1 ***************************************************************************
     */
    @When("the users click action-icon from any file on the page to remove")
    public void the_users_click_action_icon_from_any_file_on_the_page_to_remove() {
        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(userStory6Page.rightClickOnFile).perform();
    }

    @When("user choose the Remove from favorites option")
    public void user_choose_the_remove_from_favorites_option() {
        BrowserUtils.waitFor(1);
        if (userStory6Page.addToFavorites.getText().equalsIgnoreCase("Add to favorites")) {
            userStory6Page.addToFavorites.click();
            BrowserUtils.waitFor(1);
            Actions actions2 = new Actions(Driver.getDriver());
            actions2.contextClick(userStory6Page.rightClickOnFile).perform();
            BrowserUtils.waitFor(1);
            userStory6Page.addToFavorites.click();
        } else {
            BrowserUtils.waitFor(1);
            userStory6Page.addToFavorites.click();
            BrowserUtils.waitFor(2);
        }
    }

    @When("user click the Favorites sub-module on the left side")
    public void user_click_the_favorites_sub_module_on_the_left_side() {
        userStory6Page.favoritesBtn.click();
        BrowserUtils.waitFor(3);
    }

    @Then("Verify that the file is removed from the Favorites sub-module’s table")
    public void verify_that_the_file_is_removed_from_the_favorites_sub_module_s_table() {
        if (userStory6Page.verifyNoFavorites.getText().equalsIgnoreCase("No favorites yet")) {
            Assert.assertEquals("FAILED", "No favorites yet", userStory6Page.verifyNoFavorites.getText());
        } else {
            Assert.assertFalse(userStory6Page.rightClickOnFile.getText().equalsIgnoreCase(userStory6Page.verifyFavorites.getText()));
        }
    }

    /**
     * UserStory6 TC2 ****************************************************************************
     */

    String verifyUploadedFileName = "";

    @When("the user clicks the add icon on the top")
    public void theUserClicksTheAddIconOnTheTop() {
    }

    @And("users uploads file with the “upload file” option")
    public void usersUploadsFileWithTheUploadFileOption() {
        BrowserUtils.waitFor(1);
        String uploadedFileName = "anaris - Copy (9).txt";
        verifyUploadedFileName += uploadedFileName;
        userStory6Page.inputButton.sendKeys("C:\\Users\\TRIADA\\Desktop\\CYDEO\\case\\" + uploadedFileName);

        BrowserUtils.waitFor(2);
    }

    @Then("Then verify the file is displayed on the page")
    public void thenVerifyTheFileIsDisplayedOnThePage() {
        BrowserUtils.waitFor(1);
        Driver.getDriver().navigate().refresh();

        userStory6Page.fileCount();

        userStory6Page.verifyUS8TC2(verifyUploadedFileName);
    }

    /**
     * User Story 7  TC1 ************************************************************************************
     */
    @And("user click new folder")
    public void userClickNewFolder() {

        userStory6Page.addIconButton.click();
        BrowserUtils.waitFor(1);
        userStory7Page.newFolder.click();
        BrowserUtils.waitFor(1);
    }

    @And("user write a folder name")
    public void userWriteAFolderName() {
        userStory7Page.inputFolderName.sendKeys(faker.bothify("JAVA-BAKU-###"));
        BrowserUtils.waitFor(1);
    }

    @When("the user click submit icon")
    public void theUserClickSubmitIcon() {
        userStory7Page.submitFolderName.click();
        BrowserUtils.waitFor(3);
    }

    @Then("Verify the folder is displayed on the page")
    public void verifyTheFolderIsDisplayedOnThePage() {
        Assert.assertTrue(userStory7Page.newCreated.getText().contains("JAVA-BAKU"));
        System.out.println(userStory7Page.newCreated.getText());
    }

    /**
     * US7 TC2
     */
    @And("user choose a folder from the page")
    public void userChooseAFolderFromThePage() {
        userStory7Page.selectFolder();
    }

    @And("user clicks the add icon on the top")
    public void userClicksTheAddIconOnTheTop() {
        BrowserUtils.waitFor(1);
    }

    @When("the user uploads a file with the upload file option")
    public void theUserUploadsAFileWithTheUploadFileOption() {
        BrowserUtils.waitFor(1);
        userStory7Page.inputButton.sendKeys("C:\\Users\\TRIADA\\Desktop\\CYDEO\\case\\anaris - Copy (9).txt");
        BrowserUtils.waitFor(1);
    }

    @Then("Verify the file is displayed on the page")
    public void verifyTheFileIsDisplayedOnThePage() {
        userStory7Page.verifyFileName(userStory7Page.filesName, "anaris - Copy (9)");
    }

    /**
     * User Story 8
     */
    @When("the user clicks the {string} module")
    public void theUserClicksTheModule(String files) {
        userStory8Page.selectTopModule(files);
        BrowserUtils.waitFor(2);
    }

    @And("user click action-icon from any file on the page")
    public void userClickActionIconFromAnyFileOnThePage() {
        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(userStory8Page.deletedFileName).build().perform();
        userStory8Page.fileName();
        BrowserUtils.waitFor(2);
    }

    @And("user choose the {string} option")
    public void userChooseTheOption(String deleteF) {
        userStory8Page.deleteFile(deleteF);
        BrowserUtils.waitFor(1);
    }

    @When("the user clicks the {string} sub-module on the left side")
    public void theUserClicksTheSubModuleOnTheLeftSide(String deletedFiles) {
        userStory8Page.deletedFiles.click();
    }

    @Then("Verify the deleted file is displayed on the page.")
    public void verifyTheDeletedFileIsDisplayedOnThePage() {

        userStory8Page.verifyDeletedFileUS8();
    }

    /**
     * User Story 9 *************************************************************************
     */
    @And("the user choose the {string} option")
    public void theUserChooseTheOption(String details) {
        userStory9Page.detailsOnRightClickMenu(details);
        BrowserUtils.waitFor(1);
    }

    @And("user write a comment inside the input box")
    public void userWriteACommentInsideTheInputBox() {
        userStory9Page.commentBtn.click();
        BrowserUtils.waitFor(1);
        String sendMsg = "Lambada7";
        userStory9Page.textAreaInDetails.sendKeys(userStory9Page.sendMsg());
        BrowserUtils.waitFor(1);
    }

    @And("user click the submit button to post it")
    public void userClickTheSubmitButtonToPostIt() {
        userStory9Page.textSubmit.click();
        BrowserUtils.waitFor(1);
    }

    @Then("Verify the comment is displayed in the comment section.")
    public void verifyTheCommentIsDisplayedInTheCommentSection() {
        userStory9Page.verifyMsgUS9();
    }

    /**
     * User Story 10 TC1 *************************************************************************
     */
    @When("user clicks Settings on the left bottom corner")
    public void user_clicks_settings_on_the_left_bottom_corner() {
        userStory10Page.settingsBtn.click();
        BrowserUtils.waitFor(1);
    }

    @Then("the user should be able to click any buttons")
    public void the_user_should_be_able_to_click_any_buttons() {
        System.out.println(userStory10Page.firstCheckBox.isSelected());
        System.out.println(userStory10Page.secondCheckBox.isSelected());
        System.out.println(userStory10Page.thirdCheckBox.isSelected());

        userStory10Page.firstCheckBoxClick.click();
        userStory10Page.secondCheckBoxClick.click();
        userStory10Page.thirdCheckBoxClick.click();

        System.out.println(userStory10Page.firstCheckBox.isSelected());
        System.out.println(userStory10Page.secondCheckBox.isSelected());
        System.out.println(userStory10Page.thirdCheckBox.isSelected());
        BrowserUtils.waitFor(2);
    }


    /**
     * User Story 10 TC2
     *
     * @return
     */
    String before = "";
    String after = "";

    @And("user checks the current storage usage")
    public void userChecksTheCurrentStorageUsage() {
        String a = userStory10Page.checkStorage.getText();
        before += a;
    }

    @And("user uploads file with the upload file option")
    public void userUploadsFileWithTheUploadFileOption() {
        BrowserUtils.waitFor(1);
        userStory6Page.inputButton.sendKeys("C:\\Users\\TRIADA\\Desktop\\CYDEO\\case\\Java - Copy (7).jpg");
        BrowserUtils.waitFor(3);
    }

    @And("user refresh the page")
    public void userRefreshThePage() {
        Driver.getDriver().navigate().refresh();
        BrowserUtils.waitFor(3);
        String b = userStory10Page.checkStorage.getText();
        after += b;
    }

    @Then("the user should be able to see storage usage is increased")
    public void theUserShouldBeAbleToSeeStorageUsageIsIncreased() {
        System.out.println("before upload " + before);
        System.out.println("after upload " + after);
        Assert.assertFalse(before.equalsIgnoreCase(after));
    }

    /**
     * User Story 11 TC1 *************************************************************************
     */
    @And("the user clicks the Talk module")
    public void theUserClicksTheTalkModule() {
        userStory11Page.talkButton.click();
    }

    @Then("verify the page title is {string}")
    public void verifyThePageTitleIs(String expectedTitle) {
        Assert.assertEquals(expectedTitle, Driver.getDriver().getTitle());
        /**
         * Bug report = Expected Title does not match to Actual Title
         *
         * Expected :Talk - Trycloud QA
         * Actual   :Talk - Trycloud
         */
    }

    /**
     * User Story 11 TC2 *************************************************************************
     */
    String str = "";

    @And("user search user from the search box")
    public void userSearchUserFromTheSearchBox() {
        BrowserUtils.waitFor(1);
        userStory11Page.searchBox.sendKeys("user");
        BrowserUtils.waitFor(1);
        userStory11Page.user100.click();
        BrowserUtils.waitFor(1);
    }

    @And("user write a message")
    public void userWriteAMessage() {
        String sendText = faker.address().country();
        str += sendText;
        userStory11Page.msgBox.sendKeys(str);
        BrowserUtils.waitFor(1);
    }

    @And("user clicks to submit button")
    public void userClicksToSubmitButton() {
        userStory11Page.submitMsg.click();
        BrowserUtils.waitFor(1);
    }

    @Then("the user should be able to see the message is displayed on the conversation log")
    public void theUserShouldBeAbleToSeeTheMessageIsDisplayedOnTheConversationLog() {
        userStory11Page.verifyMsg(str);
    }

    /***********************************************************************************
     * User Story 12
     * Bug report = Expected Title does not match to Actual Title
     *
     * Expected :Contacts - Trycloud QA
     * Actual   :Contacts - Trycloud
     **********************************************************************************/

    /**
     * User Story 13 *******************************************************************
     */
    @Then("verify the contact names are in the list")
    public void verifyTheContactNamesAreInTheList() {
        BrowserUtils.waitFor(2);
        userStory13Page.createNewContactBtn.click();
        userStory13Page.inputName.clear();
        String sendKeys = faker.name().fullName();
        userStory13Page.inputName.sendKeys(sendKeys);
        userStory13Page.inputTel.sendKeys(faker.phoneNumber().cellPhone());
        userStory13Page.inputEmail.sendKeys(faker.internet().emailAddress());
        userStory13Page.inputAddress.sendKeys(faker.address().fullAddress());
        userStory13Page.inputPostalCode.sendKeys(faker.address().zipCode());
        userStory13Page.inputCity.sendKeys(faker.address().city());
        userStory13Page.inputState.sendKeys(faker.address().state());
        userStory13Page.inputCountry.sendKeys(faker.address().country());
        BrowserUtils.waitFor(1);
        userStory13Page.clickContactBtn.click();

        userStory13Page.verifyUS13();
    }

    /**
     * USER STORY 14
     */
    String depot = "";

    @Given("the user clicks the magnifier icon on the right top")
    public void theUserClicksTheMagnifierIconOnTheRightTop() {
        userStory14Page.lupaClick.click();
        BrowserUtils.waitFor(2);
    }

    @And("users search any existing file,folder,user name")
    public void usersSearchAnyExistingFileFolderUserName() {
        String send = "User";
        depot += send;
        userStory14Page.searchBox.sendKeys("User" + Keys.ENTER);
        BrowserUtils.waitFor(2);
    }

    @Then("verify the app displays the expected result option")
    public void verifyTheAppDisplaysTheExpectedResultOption() {
        List<String> actualSearchList = userStory14Page.getSearchList();
        System.out.println(actualSearchList);
        Assert.assertTrue(actualSearchList.contains("User"));
    }
}

