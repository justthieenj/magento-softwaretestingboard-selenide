package stepdefs;

import com.codeborne.selenide.Selenide;
import com.github.common.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import page.AccountPage;
import page.CreateAccountPage;

import java.util.HashMap;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CreateAccountStep {
    CreateAccountPage createAccountPage = new CreateAccountPage();
    AccountPage accountPage = new AccountPage();
    String password = "Test@123";

    private final HashMap<String, Object> state;

    public CreateAccountStep(HashMap<String, Object> state) {
        this.state = state;
    }

    @Given("I click on Create Account link")
    public void clickOnCreateAccountLink() {
        open(Constants.BASE_URL);
    }

    @When("I try to create a customer account with valid information")
    public void createValidCustomerAccount() {
        createAccountPage.createCustomerAccount("Frank", "Nguyen", "beokei14+" + System.currentTimeMillis() + "@gmail.com", password, password);
    }

    @When("I try to create a customer account with empty first name")
    public void createCustomerAccountWithEmptyFirstName() {
        createAccountPage.createCustomerAccount("", "Nguyen", "beokei14+" + System.currentTimeMillis() + "@gmail.com", password, password);
    }

    @When("I try to create a customer account with empty last name")
    public void createCustomerAccountWithEmptyLastName() {
        createAccountPage.createCustomerAccount("Frank", "", "beokei14+" + System.currentTimeMillis() + "@gmail.com", password, password);
    }

    @Then("I created a customer account successfully")
    public void createdCustomerAccountSuccessfully() {
        Assert.assertEquals(accountPage.getUrl(), Selenide.webdriver().driver().url());
        $(".message-success").shouldBe(visible);
    }

    @Then("Show error message that first name is required")
    public void showErrMsgFirstNameIsRequired() {
        Assert.assertEquals(createAccountPage.getUrl(), Selenide.webdriver().driver().url());
        createAccountPage.erMsgPassword.shouldHave(text(Constants.ER_MSG_REQUIRED_FIELD));
    }

    @Then("Show error message that last name is required")
    public void showErrMsgLastNameIsRequired() {
        Assert.assertEquals(createAccountPage.getUrl(), Selenide.webdriver().driver().url());
        createAccountPage.erMsgLastName.shouldHave(text(Constants.ER_MSG_REQUIRED_FIELD));
    }
}
