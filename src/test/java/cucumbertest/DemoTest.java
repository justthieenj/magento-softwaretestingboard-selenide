package cucumbertest;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/demo.feature",
        glue = "stepdefs",
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm", "pretty"}
)
public class DemoTest extends AbstractCucumber {
}
