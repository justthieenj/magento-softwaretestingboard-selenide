package stepdefs;

import com.codeborne.selenide.Selenide;
import com.github.common.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import page.HomePage;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TopBarNavigationStep {
    HomePage homePage = new HomePage();

    @Given("I go to the home page")
    public void goToHomePage() {
        open(Constants.BASE_URL);
        Selenide.webdriver().driver().getWebDriver().manage().window().fullscreen();
    }

    @When("I navigate to {} on the top bar")
    public void iNavigateToWomenTopsJacketsOnTheTopBar(String items) {
        List<String> navItems = List.of(items.split("->"));
        //TODO: wait for the top bar to be stable
        Selenide.sleep(1000);
        for (int i = 0; i < navItems.size(); i++) {
            if (i == navItems.size() - 1) {
                homePage.getTopBarItem(navItems.get(i)).click();
            } else {
                homePage.getTopBarItem(navItems.get(i)).hover();
            }
        }
    }

    @Then("I should see the {} page display with correct {} title")
    public void womenJacketsPageDisplay(String pageURL, String title) {
        $(".base").shouldHave(text(title + " ab"));
        Assert.assertEquals(pageURL, Selenide.webdriver().driver().url());
    }
}
