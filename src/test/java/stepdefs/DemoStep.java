package stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;

public class DemoStep {
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
