package page;

import Data.Product;
import com.codeborne.selenide.SelenideElement;
import component.Header;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage implements Header {
    private final SelenideElement dropSortBy = $("#sorter");
    private final SelenideElement btnList = $("#mode-list");
    private final SelenideElement btnGrid = $("#mode-grid");
    public final SelenideElement noticeMessage = $(".message.notice");
    public final SelenideElement searchResultGrid = $(".search.results>.products");
    public List<Product> productList = new ArrayList<>();

    public void sortBy(String option) {
        dropSortBy.selectOption(option);
    }

    public void listView() {
        btnList.click();
    }

    public void gridView() {
        btnGrid.click();
    }

    public List<Product> getSearchResult() {
        List<String> productNames = $$(".product-item-link").texts().stream().map(String::trim).toList();
        List<Double> productPrices = $$(".product-items>li .price").texts().stream().map(s -> Double.parseDouble(s.substring(1))).toList();
        for (int i = 0; i < productNames.size(); i++) {
            productList.add(new Product(productNames.get(i), productPrices.get(i)));
        }
        return productList;
    }

    public List<Double> getItemsPrice() {
        getSearchResult();
        return productList.stream().map(Product::getPrice).toList();
    }
}
