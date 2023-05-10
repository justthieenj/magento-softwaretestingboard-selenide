package cucumbertest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/search-and-filter.feature",
        glue = "stepdefs",
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", "pretty"}
)
public class SearchAndFilterTest extends AbstractTestNGCucumberTests {
}
