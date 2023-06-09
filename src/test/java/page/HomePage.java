package page;

import com.codeborne.selenide.SelenideElement;
import com.github.common.Constants;
import component.Header;

import static com.codeborne.selenide.Selenide.$;

public class HomePage implements IPage, Header {

    @Override
    public String getUrl() {
        return Constants.BASE_URL;
    }

    private final SelenideElement createAccountLink = $("header .authorization-link+li>a");

    public void clickCreateAccountLink() {
        createAccountLink.click();
    }

}
