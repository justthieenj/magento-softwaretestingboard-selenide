package cucumbertest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/add-remove-items-in-cart.feature",
        glue = "stepdefs",
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", "pretty"}
)
public class AddRemoveCartItemsTest extends AbstractTestNGCucumberTests {
}
