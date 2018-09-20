package stepDefinitions;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.SearchResultsPage;

public class SearchResultsStepDefs {
    private SearchResultsPage searchResultsPage;

    public SearchResultsStepDefs(SearchResultsPage searchResultsPage){
        this.searchResultsPage=searchResultsPage;
    }

    @Then("^All descriptions of the products in Search results should contain \"([^\"]*)\"$")
    public void allDescriptionsOfTheProductsInSearchResultsShouldContain(String text) throws InterruptedException {
        Thread.sleep(2000);
        searchResultsPage.getTextValuesOf(searchResultsPage.GOOD_CONTAINER_GOOD_DESCRIPTION)
                .forEach(description-> Assert.assertTrue(description.toLowerCase().contains(text)));
    }
}
