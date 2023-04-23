package stepdefs;

import common.Constants;
import element.ElementWait;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.AccountPage;
import page.CreateAccountPage;
import utils.BrowserFactory;

public class CreateAccountStep {
    WebDriver driver = BrowserFactory.getDriver();
    CreateAccountPage createAccountPage = new CreateAccountPage();
    AccountPage accountPage = new AccountPage();
    String password = "Test@123";
    int currentTimestamp = (int) System.currentTimeMillis();

    @Given("I click on Create Account link")
    public void clickOnCreateAccountLink() {
        driver.get(createAccountPage.getUrl());
    }

    @When("I try to create a customer account with valid information")
    public void createValidCustomerAccount() {
        createAccountPage.createCustomerAccount("Frank", "Nguyen", "beokei14+" + currentTimestamp + "@gmail.com", password, password);
    }

    @When("I try to create a customer account with empty first name")
    public void createCustomerAccountWithEmptyFirstName() {
        createAccountPage.createCustomerAccount("", "Nguyen", "beokei14+" + currentTimestamp + "@gmail.com", password, password);
    }

    @When("I try to create a customer account with empty last name")
    public void createCustomerAccountWithEmptyLastName() {
        createAccountPage.createCustomerAccount("Frank", "", "beokei14+" + currentTimestamp + "@gmail.com", password, password);
    }

    @Then("I created a customer account successfully")
    public void createdCustomerAccountSuccessfully() {
        Assert.assertEquals(accountPage.getUrl(), driver.getCurrentUrl());
        Assert.assertTrue(ElementWait.waitVisible(driver, By.cssSelector(".message-success")).isDisplayed());
    }

    @Then("Show error message that first name is required")
    public void showErrMsgFirstNameIsRequired() {
        Assert.assertEquals(createAccountPage.getUrl(), driver.getCurrentUrl());
        Assert.assertEquals(createAccountPage.getErMsgFirstName(), Constants.ER_MSG_REQUIRED_FIELD);
    }

    @Then("Show error message that last name is required")
    public void showErrMsgLastNameIsRequired() {
        Assert.assertEquals(createAccountPage.getUrl(), driver.getCurrentUrl());
        Assert.assertEquals(createAccountPage.getErMsgLastName(), Constants.ER_MSG_REQUIRED_FIELD);
    }
}
