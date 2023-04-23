package stepdefs;

import element.ElementWait;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import page.HomePage;
import utils.BrowserFactory;
import utils.MouseAction;
import utils.Utils;

import java.util.List;

public class TopBarNavigationStep {
    WebDriver driver = BrowserFactory.getDriver();
    HomePage homePage = new HomePage();

    @Given("I go to the home page")
    public void goToHomePage() {
    }


    @When("I navigate to {} on the top bar")
    public void iNavigateToWomenTopsJacketsOnTheTopBar(String items) {
        List<String> navItems = List.of(items.split("->"));
        //TODO: wait for the top bar to be stable
        Utils.sleep(1);
        for (int i = 0; i < navItems.size(); i++) {
            if (i == navItems.size() - 1) {
                homePage.getTopBarItem(navItems.get(i)).click();
            } else {
                MouseAction.hover(driver, homePage.getTopBarItem(navItems.get(i)));
            }
        }
    }

    @Then("I should see the {} page display with correct {} title")
    public void womenJacketsPageDisplay(String pageURL, String title) {
        Assert.assertEquals(title, ElementWait.waitVisible(driver, By.cssSelector(".base")).getText());
        Assert.assertEquals(pageURL, driver.getCurrentUrl());
    }
}
