package component;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public interface Header {
    String topBarNav = "//nav[@class='navigation']//span[text()='%s']";
    SelenideElement searchBox = $("#search");
    SelenideElement iconCart = $(".minicart-wrapper");
    ElementsCollection cartItemsName = $$("#mini-cart>.product-item .product-item-name>a");
    ElementsCollection btnSeeDetails = $$("div.product.options");
    SelenideElement iconCartLoading = $(".loader");

    default SelenideElement getTopBarItem(String item) {
        return $x(topBarNav.formatted(item));
    }

    default void search(String name) {
        searchBox.setValue(name).pressEnter();
    }

    default ElementsCollection getCartItemsName() {
        return cartItemsName;
    }

    default void openItemDetails() {
        btnSeeDetails.get(0).click();
    }

    default SelenideElement getItemDetailSize() {
        return $x("//dt[text()='Size']/following-sibling::dd[1]/span");
    }

    default SelenideElement getItemDetailColor() {
        return $x("//dt[text()='Color']/following-sibling::dd[1]/span");
    }

    default void openCart() {
        iconCart.click();
    }
}
