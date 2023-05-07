package stepdefs;

import com.github.common.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.HomePage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class SearchAndFilterStep {
    HomePage homePage = new HomePage();

    @Given("I navigate to homepage")
    public void navigateToHomePage() {
        open(Constants.BASE_URL);
    }

    @When("I search with a specific product name: {}")
    public void searchProduct(String name) {
        homePage.search(name);
    }

    @Then("I should see {} displays fist in the search result")
    public void verifyFirstItem(String name) {
        $x("//ol[@class='products list items product-items']/li[1]//a[@class='product-item-link']").shouldHave(text(name));
    }
}
