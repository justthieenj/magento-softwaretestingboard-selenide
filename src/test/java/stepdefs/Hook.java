package stepdefs;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.selenide.AllureSelenide;

public class Hook {
    @Before
    public void beforeScenario() {
        configSelenide();
    }

    @After
    public void afterScenario() {
        Selenide.closeWebDriver();
    }

    private void configSelenide() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.headless = false;
        Configuration.timeout = 10000;
    }
}
