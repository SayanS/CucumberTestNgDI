package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.SearchProductAutoSuggestLine;
import org.junit.Assert;
import pages.Header;

import java.util.ArrayList;
import java.util.List;

public class HeaderStepdefs {
    public Header header;

    public HeaderStepdefs(Header header) {
        this.header = header;
    }

    @Then("^Enter \"([^\"]*)\" into Global Search field$")
    public void enterIntoGlobalSearchField(String text) {
        header.enterValueIntoField(header.SEARCH_FIELD,text);
    }

    @Then("Selected city \"([^\"]*)\" should be displayed in Header menu$")
    public void selectedCityShouldBeDisplayedInHeaderMenu(String cityName) {
        if(header.waitForTextToBePresentIn(header.SELECTED_CITY, cityName,5)!=null) {
            Assert.assertEquals(cityName, header.getTextOf(header.SELECTED_CITY));
        }else{
            Assert.assertTrue("Element hasn't been found:TIMEOUT EXCEPTION", false);
        }
    }

    @Then("^Notification message \"([^\"]*)\" should be displayed$")
    public void notificationMessageShouldBeDisplayed(String message) {
        header.waitForVisibilityOfElementLocatedByXpath(header.NOTIFICATION_SELECTED_CITY, 3);
        Assert.assertEquals(message, header.getTextOf(header.NOTIFICATION_SELECTED_CITY));
    }

    @Then("^First item of the Autosuggest list of the Header Search should be$")
    public void firstItemOfTheAutoSuggestListOfTheHeaderSearchShouldBe(DataTable autosuggestLine) {
        SearchProductAutoSuggestLine searchProductAutoSuggestLine=new SearchProductAutoSuggestLine("http://","Телевизор TOSHIBA 49U7750EV","","16999 .-");
        List<SearchProductAutoSuggestLine> autosuggestLines=new ArrayList<>();
        autosuggestLines.add(searchProductAutoSuggestLine);
        try {
            autosuggestLine.diff(DataTable.create(autosuggestLines));
            Assert.assertTrue(true);
        }catch(cucumber.runtime.table.TableDiffException e){
            Assert.assertTrue(e.getMessage(),false);
        }
    }

    @When("^Click on \"([^\"]*)\" button on Autosuggest list$")
    public void clickOnButtonOnAutosuggestList(String buttonName) {
        header.clickOnByXpath(header.BUTTON,buttonName);
    }

    @When("^Click on Show All button on Autosuggest list$")
    public void clickOnShowAllButtonOnAutoSuggestList() throws InterruptedException {
        header.clickOnShowAllButton();
    }
}
