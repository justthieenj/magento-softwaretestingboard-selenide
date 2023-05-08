package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class SearchResultPage {
    private final SelenideElement dropSortBy = $("#sorter");

    public void sortBy(String rule) {
        dropSortBy.selectOption(rule);
    }
}
