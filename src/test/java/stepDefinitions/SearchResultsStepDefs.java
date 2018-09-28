package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.SearchResultsPage;

public class SearchResultsStepDefs {
    private SearchResultsPage searchResultsPage;

    public SearchResultsStepDefs(SearchResultsPage searchResultsPage) {
        this.searchResultsPage = searchResultsPage;
    }

    @Then("^All descriptions of the products in Search results should contain \"([^\"]*)\"$")
    public void allDescriptionsOfTheProductsInSearchResultsShouldContain(String text) throws InterruptedException {
        Thread.sleep(4000);
        searchResultsPage.getTextValuesOf(searchResultsPage.PRODUCT_CONTAINER_GOOD_DESCRIPTION)
                .forEach(description ->
                        Assert.assertTrue(description.toLowerCase().contains(text)));
    }

    @When("^Add to cart first product from Search results$")
    public void addToCartFirstProductFromSearchResults() {
        searchResultsPage.addToCartFirstProduct();
    }
}
