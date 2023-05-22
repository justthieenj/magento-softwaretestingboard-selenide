package page;

import Data.Product;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import component.Header;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SearchResultPage implements Header {
    private final SelenideElement dropSortBy = $("#sorter");
    public final SelenideElement btnListView = $("#mode-list");
    public final SelenideElement btnGridView = $("#mode-grid");
    public final SelenideElement noticeMessage = $(".message.notice");
    public final SelenideElement searchResultGrid = $(".search.results>.products");
    public final ElementsCollection productNames = $$(".product-item-link");
    public final ElementsCollection productPrices = $$(".product-items>li .price");
    private final String itemName = "//a[@class='product-item-link' and contains(text(),'%s')]";
    private final String itemSize = "//a[@class='product-item-link' and contains(text(),'%s')]//ancestor::li[@class='item product product-item']//div[@aria-label='Size']/div[@option-label='%s']";
    private final String itemColor = "//a[@class='product-item-link' and contains(text(),'%s')]//ancestor::li[@class='item product product-item']//div[@aria-label='Color']/div[@option-label='%s']";
    private final String btnAddToCart = "//a[@class='product-item-link' and contains(text(),'%s')]//ancestor::li[@class='item product product-item']//button[@title='Add to Cart']";
    private final String btnAdded = "//a[@class='product-item-link' and contains(text(),'%s')]//ancestor::li[@class='item product product-item']//button[@title='Added']";

    public void sortBy(String option) {
        dropSortBy.selectOption(option);
    }

    public List<Product> getSearchResult() {
        List<String> names = productNames.texts().stream().map(String::trim).toList();
        List<Double> prices = productPrices.texts().stream().map(s -> Double.parseDouble(s.substring(1))).toList();
        var productList = new ArrayList<Product>();
        for (int i = 0; i < names.size(); i++) {
            productList.add(new Product(names.get(i), prices.get(i)));
        }
        return productList;
    }

    public List<Double> getItemsPrice() {
        var productList = getSearchResult();
        return productList.stream().map(Product::getPrice).toList();
    }

    public void selectSize(String itemName, String size) {
        $x(itemSize.formatted(itemName, size)).click();
    }

    public void selectColor(String itemName, String color) {
        $x(itemColor.formatted(itemName, color)).click();
    }

    public void addItemToCart(String itemName) {
        $x(this.itemName.formatted(itemName)).hover();
        $x(btnAddToCart.formatted(itemName)).click();
    }

    public void waitItemAdded(String itemName) {
        $x(btnAdded.formatted(itemName)).shouldBe(visible);
        iconCartLoading.shouldBe(hidden);
    }
}
