package stepdefs;

import com.codeborne.selenide.Selenide;
import com.github.common.Constants;
import com.github.common.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import page.HomePage;
import page.SearchResultPage;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchAndFilterStep {
    HomePage homePage = new HomePage();
    SearchResultPage searchResultPage = new SearchResultPage();

    @Given("I navigate to homepage")
    public void navigateToHomePage() {
        open(Constants.BASE_URL);
        Selenide.webdriver().driver().getWebDriver().manage().window().maximize();
    }

    @When("I search with an invalid keyword: {}")
    @When("I search with a valid keyword: {}")
    public void searchWithKeyword(String keyword) {
        homePage.search(keyword);
    }

    @When("I click the List button")
    public void clickListButton() {
        searchResultPage.listView();
    }

    @When("I search with a specific product name: {}")
    public void searchWithKeyWord(String keyword) {
        homePage.search(keyword);
    }

    @When("I select option {string} at Sort By box")
    public void sortByPrice(String option) {
        searchResultPage.sortBy(option);
    }

    @Then("I should see {} displays fist in the search result")
    public void productIsDisplayedFirst(String item) {
        Assert.assertEquals(item, searchResultPage.getSearchResult().get(0).getName());
    }

    @Then("I should see the search result return no item")
    public void searchResultReturnNoItem() {
        searchResultPage.noticeMessage.shouldHave(text("Your search returned no results."));
    }

    @Then("I see the search result items are displayed as a list")
    public void itemDisplayAsAList() {
        searchResultPage.searchResultGrid.shouldHave(cssClass("list"));
    }

    @Then("The search result items are sorted by price")
    public void itemsSortedByPrice() {
        Assert.assertTrue(Utils.isSortedDes(searchResultPage.getItemsPrice()));
    }
}
