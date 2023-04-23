package page;

import com.codeborne.selenide.SelenideElement;
import com.github.common.Constants;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CreateAccountPage implements IPage {
    @Override
    public String getUrl() {
        return Constants.BASE_URL + "customer/account/create/";
    }

    private final SelenideElement txtFirstName = $("#firstname");
    private final SelenideElement erMsgFirstName = $("#firstname-error");
    private final SelenideElement txtLastName = $("#lastname");
    private final SelenideElement erMsgLastName = $("#lastname-error");
    private final SelenideElement txtEmail = $("#email_address");
    private final SelenideElement erMsgEmail = $("#email_address-error");
    private final SelenideElement txtPassword = $("[name=password]#password");
    private final SelenideElement erMsgPassword = $("#password-error");
    private final SelenideElement lblPasswordStrength = $("#password-strength-meter-label");
    private final SelenideElement txtConfirmPassword = $("[name=password_confirmation]#password-confirmation");
    private final SelenideElement erMsgConfirmPassword = $("#password-confirmation-error");
    private final SelenideElement btnCreateAnAccount = $(".action.submit.primary");
    private final SelenideElement erMsgExistedEmail = $x("//div[contains(text(),'There is already an account with this email address')]");

    public void inputInformation(String firstName, String lastName, String email, String password, String confirmPassword) {
        txtFirstName.setValue(firstName);
        txtLastName.setValue(lastName);
        txtEmail.setValue(email);
        txtPassword.setValue(password);
        txtConfirmPassword.setValue(confirmPassword);
    }

    public void createCustomerAccount(String firstName, String lastName, String email, String password, String confirmPassword) {
        inputInformation(firstName, lastName, email, password, confirmPassword);
        btnCreateAnAccount.click();
    }
}
