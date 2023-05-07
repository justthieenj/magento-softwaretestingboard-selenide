package component;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public interface TopBar {
    String topBarNav = "//nav[@class='navigation']//span[text()='%s']";
    SelenideElement searchBox = $("#search");

    default SelenideElement getTopBarItem(String item) {
        return $x(topBarNav.formatted(item));
    }

    default void search(String name) {
        searchBox.setValue(name).pressEnter();
    }
}
