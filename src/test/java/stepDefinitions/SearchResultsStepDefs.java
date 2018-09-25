package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.Browser;
import org.testng.Assert;
import pages.SearchResultsPage;

public class SearchResultsStepDefs {
    private SearchResultsPage searchResultsPage;
    public Browser browser;

    public SearchResultsStepDefs(SearchResultsPage searchResultsPage, Browser browser) {
        this.searchResultsPage = searchResultsPage;
    }

    @Then("^All descriptions of the products in Search results should contain \"([^\"]*)\"$")
    public void allDescriptionsOfTheProductsInSearchResultsShouldContain(String text) throws InterruptedException {
        Thread.sleep(4000);
        searchResultsPage.getTextValuesOf(searchResultsPage.GOOD_CONTAINER_GOOD_DESCRIPTION)
                .forEach(description ->
                        Assert.assertTrue(description.toLowerCase().contains(text)));
    }

    @When("^New Repeated step of printing Super value$")
    public void newRepeatedStepOfPrintingSuperValue() throws Throwable {
        System.out.println("JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ");
    }
}
