package stepdefs;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.Before;
import io.qameta.allure.selenide.AllureSelenide;

public class Hook {
    @Before
    public void beforeScenario() {
        System.out.println("before");
        configSelenide();
    }

    private void configSelenide() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.headless = false;
        Configuration.timeout = 10000;
//        Configuration.pageLoadTimeout;
    }
}
