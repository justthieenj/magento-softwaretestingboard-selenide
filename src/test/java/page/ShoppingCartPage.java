package page;

import com.codeborne.selenide.SelenideElement;
import com.github.common.Constants;
import component.Header;

import static com.codeborne.selenide.Selenide.$;

public class ShoppingCartPage implements IPage, Header {
    @Override
    public String getUrl() {
        return Constants.BASE_URL + "checkout/cart/";
    }

    public SelenideElement msgCartEmpty = $(".cart-empty");
    public SelenideElement btnRemove = $(".action-delete");
}
