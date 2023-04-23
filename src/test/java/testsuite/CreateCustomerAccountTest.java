package testsuite;//package testsuite;
//
//import basetest.BaseTest;
//import common.Constants;
//import element.ElementWait;
//import io.qameta.allure.Allure;
//import org.openqa.selenium.By;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import page.AccountPage;
//import page.CreateAccountPage;
//import page.HomePage;
//import utils.Utils;
//
//public class CreateCustomerAccountTest extends BaseTest {
//    HomePage homePage = new HomePage(driver);
//    CreateAccountPage createAccountPage = new CreateAccountPage(driver);
//    AccountPage accountPage = new AccountPage(driver);
//    String password = "Test@123";
//    int currentTimestamp = (int) System.currentTimeMillis();
//
//    @Test(description = "Create customer account successfully")
//    public void createCustomerAccountSuccess() {
//        homePage.clickCreateAccountLinkByJs();
//        createAccountPage.createCustomerAccount("Frank", "Nguyen", "beokei14+" + currentTimestamp + "@gmail.com", password, password);
//
//        Assert.assertEquals(accountPage.getUrl(), driver.getCurrentUrl());
//        Assert.assertTrue(ElementWait.waitVisible(driver, By.cssSelector(".message-success")).isDisplayed());
//    }
//
//    @Test(description = "Create customer account fail: Empty first name")
//    public void createCustomerAccountFailEmptyFirstName() {
//        homePage.clickCreateAccountLink();
//        createAccountPage.inputInformation("", "Nguyen", "beokei14@gmail.com", password, password);
//        createAccountPage.clickCreateAnAccountButton();
//
//        Assert.assertEquals(createAccountPage.getUrl(), driver.getCurrentUrl());
//        Assert.assertEquals(createAccountPage.getErMsgFirstName(), Constants.ER_MSG_REQUIRED_FIELD);
//    }
//
//    @Test(description = "Create customer account fail: Empty last name")
//    public void createCustomerAccountFailEmptyLastName() {
//        homePage.clickCreateAccountLink();
//        createAccountPage.inputInformation("Frank", "", "beokei14@gmail.com", password, password);
//        createAccountPage.clickCreateAnAccountButton();
//
//        Assert.assertEquals(createAccountPage.getUrl(), driver.getCurrentUrl());
//        Assert.assertEquals(createAccountPage.getErMsgLastName(), Constants.ER_MSG_REQUIRED_FIELD);
//    }
//
//    @Test(description = "Create customer account fail: Empty email")
//    public void createCustomerAccountFailEmptyEmail() {
//        homePage.clickCreateAccountLink();
//        createAccountPage.inputInformation("Frank", "Nguyen", "", password, password);
//        createAccountPage.clickCreateAnAccountButton();
//
//        Assert.assertEquals(createAccountPage.getUrl(), driver.getCurrentUrl());
//        Assert.assertEquals(createAccountPage.getErMsgEmail(), Constants.ER_MSG_REQUIRED_FIELD);
//    }
//
//    @Test(description = "Create customer account fail: Wrong email format")
//    public void createCustomerAccountFailWrongEmailFormat() {
//        homePage.clickCreateAccountLink();
//        createAccountPage.inputInformation("Frank", "Nguyen", "abc123", password, password);
//        createAccountPage.clickCreateAnAccountButton();
//
//        Assert.assertEquals(createAccountPage.getUrl(), driver.getCurrentUrl());
//        Assert.assertEquals(createAccountPage.getErMsgEmail(), "Please enter a valid email address (Ex: johndoe@domain.com).");
//    }
//
//    @Test(description = "Create customer account fail: Empty password")
//    public void createCustomerAccountFailEmptyPassword() {
//        homePage.clickCreateAccountLink();
//        createAccountPage.inputInformation("Frank", "Nguyen", "beokei14@gmail.com", "", password);
//        createAccountPage.clickCreateAnAccountButton();
//
//        Assert.assertEquals(createAccountPage.getUrl(), driver.getCurrentUrl());
//        Assert.assertEquals(createAccountPage.getErMsgPassword(), Constants.ER_MSG_REQUIRED_FIELD);
//    }
//
//    @Test(description = "Create customer account fail: Empty confirm password")
//    public void createCustomerAccountFailEmptyConfirmPassword() {
//        homePage.clickCreateAccountLink();
//        createAccountPage.inputInformation("Frank", "Nguyen", "beokei14@gmail.com", password, "");
//        createAccountPage.clickCreateAnAccountButton();
//
//        Assert.assertEquals(createAccountPage.getUrl(), driver.getCurrentUrl());
//        Assert.assertEquals(createAccountPage.getErMsgConfirmPassword(), Constants.ER_MSG_REQUIRED_FIELD);
//    }
//
//    @Test(description = "Create customer account fail: Existed email")
//    public void createCustomerAccountFailExistedEmail() {
//        var email = "beokei14@gmail.com";
//        homePage.clickCreateAccountLink();
//        createAccountPage.inputInformation("Frank", "Nguyen", email, password, password);
//        createAccountPage.clickCreateAnAccountButton();
//
//        Assert.assertEquals(createAccountPage.getUrl(), driver.getCurrentUrl());
//        Assert.assertTrue(createAccountPage.erMsgExistedEmail().isDisplayed(), "Email %s is existed".formatted(email));
//    }
//
//    @Test(description = "Create customer account fail: Wrong confirm password")
//    public void createCustomerAccountFailWrongConfirmPassword() {
//        homePage.clickCreateAccountLink();
//        createAccountPage.inputInformation("Frank", "Nguyen", "beokei14@gmail.com", password, password + "123");
//        createAccountPage.clickCreateAnAccountButton();
//
//        Assert.assertEquals(createAccountPage.getUrl(), driver.getCurrentUrl());
//        Assert.assertEquals(createAccountPage.getErMsgConfirmPassword(), Constants.ER_MSG_CONFIRM_PASSWORD);
//    }
//
//    @Test(description = "Create customer account fail: Short password")
//    public void createCustomerAccountFailShortPassword() {
//        String shortPassword = "123";
//        homePage.clickCreateAccountLink();
//        createAccountPage.inputInformation("Frank", "Nguyen", "beokei14@gmail.com", shortPassword, shortPassword);
//        createAccountPage.clickCreateAnAccountButton();
//
//        Assert.assertEquals(createAccountPage.getUrl(), driver.getCurrentUrl());
//        Assert.assertEquals(createAccountPage.getErMsgPassword(), Constants.ER_MSG_SHORT_PASSWORD);
//    }
//
//    @Test(description = "Create customer account fail: Weak password")
//    public void createCustomerAccountFailWeakPassword() {
//        String weakPassword = "1234abcd";
//        homePage.clickCreateAccountLink();
//        createAccountPage.inputInformation("Frank", "Nguyen", "beokei14@gmail.com", weakPassword, weakPassword);
//        createAccountPage.clickCreateAnAccountButton();
//
//        Assert.assertEquals(createAccountPage.getUrl(), driver.getCurrentUrl());
//        Assert.assertEquals(createAccountPage.getErMsgPassword(), Constants.ER_MSG_WEAK_PASSWORD);
//        Assert.assertEquals(createAccountPage.getPasswordStrength(), "Weak");
//    }
//
//    @Test(description = "Dummy test")
//    public void createCustomerAccount() {
//        homePage = new HomePage(driver);
//        Utils.sleep(2);
//        Allure.step("Click Create Account Link", () -> homePage.clickCreateAccountLink());
//        Allure.step("Check text", () -> Assert.assertTrue(false));
//    }
//}
