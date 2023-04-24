package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class DemoStep {
    private final HashMap<String, Object> state;

    public DemoStep(HashMap<String, Object> state) {
        this.state = state;
    }

    @When("I navigate to url")
    public void navigate() {
        var url = "https://www.google.com";
        open(url);
        state.put("url", url);
    }

    @Then("I can see url in the address bar")
    public void verifyUrl() {
        var url = (String) state.get("url");
        System.out.println(url);
    }

    @And("I can see list of my orders")
    public void iCanSeeListOfMyOrders(List<String> list) {
        System.out.println(list);
    }

    @But("I dont have anything in this table")
    public void iDontHaveAnythingInThisTable(DataTable table) {
        List<Map<String, String>> rows = table.asMaps(String.class, String.class);
        for (var row : rows) {
            System.out.println(row.get("fruits") + " " + row.get("quantity"));
        }
    }

    @Then("Data table {} without header")
    public void dataTableWithoutHeader(String name, DataTable table) {
        System.out.println(name);
        List<List<String>> rows = table.asLists(String.class);
        var fruits = rows.get(0);
        var quality = rows.get(1);
    }

    @Given("I have a word {}")
    public void iHaveAWordWord(String word) {

    }

    @When("I check if it is palindrome")
    public void iCheckIfItIsPalindrome() {

    }

    @Then("it should return {}")
    public void itShouldReturnResult(String result) {

    }
}
