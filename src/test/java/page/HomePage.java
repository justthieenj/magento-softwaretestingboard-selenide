package page;

import com.codeborne.selenide.SelenideElement;
import com.github.common.Constants;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage implements IPage {

    @Override
    public String getUrl() {
        return Constants.BASE_URL;
    }

    private final SelenideElement createAccountLink = $("header .authorization-link+li>a");
    private final String topBarNav = "//nav[@class='navigation']//span[text()='%s']";

    public void clickCreateAccountLink() {
        createAccountLink.click();
    }

    public SelenideElement getTopBarItem(String item) {
        return $x(topBarNav.formatted(item));
    }
}
