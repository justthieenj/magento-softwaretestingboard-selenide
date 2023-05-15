package stepdefs;

import io.cucumber.java.en.*;
import page.SearchResultPage;

import java.util.HashMap;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AddRemoveItemsInCartStep {
    SearchResultPage searchResultPage = new SearchResultPage();

    private final HashMap<String, Object> state;

    public AddRemoveItemsInCartStep(HashMap<String, Object> state) {
        this.state = state;
    }

    @When("I select size {} and color {} for the product")
    public void selectSizeAndColor(String size, String color) {
        searchResultPage.selectSize((String) state.get("Name"), size);
        searchResultPage.selectColor((String) state.get("Name"), color);
        state.put("Size", size);
        state.put("Color", color);
    }

    @When("I add the product to cart")
    public void addProductToCart() {
        searchResultPage.addItemToCart((String) state.get("Name"));
    }

    @When("I wait until product is added to cart")
    public void waitUntilProductIsAdded() {
        searchResultPage.waitItemAdded((String) state.get("Name"));
    }

    @When("I click on the Shopping Cart icon")
    public void clickCartIcon() {
        searchResultPage.openCart();
    }

    @Then("I should see the product is added into shopping cart as the top most item")
    public void verifyTopMostItemName() {
        searchResultPage.getCartItemsName().get(0).shouldHave(text((String) state.get("Name")));
    }

    @Then("I should be navigated to the product details page")
    public void getNavigatedToProductDetailsPage() {
        $(".base").shouldHave(text((String) state.get("Name")));
    }

    @Then("I should see the product details matches with what I selected")
    public void verifyProductDetails() {
        searchResultPage.openItemDetails();
        searchResultPage.getItemDetailSize().shouldHave(text((String) state.get("Size")));
        searchResultPage.getItemDetailColor().shouldHave(text((String) state.get("Color")));
    }

    @Then("I should see a warning message: {}")
    public void verifyWarningMessage(String message) {
        $("[role=alert]>div>div").shouldHave(text(message));
    }
}
