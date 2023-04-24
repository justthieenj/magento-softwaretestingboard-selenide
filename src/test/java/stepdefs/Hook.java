package stepdefs;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.qameta.allure.selenide.AllureSelenide;

import java.util.HashMap;

public class Hook {
    private final HashMap<String, Object> state;

    public Hook(HashMap<String, Object> state) {
        this.state = state;
    }

    @Before
    public void beforeScenario() {
        System.out.println("before scenario");
        configSelenide();
    }

    @After
    public void afterScenario() {
        System.out.println("after scenario");
        state.clear();
    }

    private void configSelenide() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.headless = false;
        Configuration.timeout = 10000;
//        Configuration.pageLoadTimeout;
    }
}
