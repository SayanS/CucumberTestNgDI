package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.SearchProductAutoSuggestLine;
import org.testng.Assert;
import pages.Header;

import java.util.List;

public class HeaderStepdefs {
    private Header header;

    public HeaderStepdefs(Header header) {
        this.header = header;
    }


    @Then("^Enter \"([^\"]*)\" into Global Search field$")
    public void enterIntoGlobalSearchField(String text) throws InterruptedException {
        header.enterValueIntoField(header.SEARCH_FIELD, text);
    }


    @Then("Selected city \"([^\"]*)\" should be displayed in Header menu$")
    public void selectedCityShouldBeDisplayedInHeaderMenu(String cityName) {
        if (header.waitForTextToBePresentIn(header.SELECTED_CITY, cityName, 5) != null) {
            Assert.assertEquals(cityName, header.getTextOf(header.SELECTED_CITY));
        } else {
            Assert.assertTrue(false, "Element hasn't been found:TIMEOUT EXCEPTION");
        }
    }


    @Then("^Notification message \"([^\"]*)\" should be displayed$")
    public void notificationMessageShouldBeDisplayed(String message) {
        header.waitForVisibilityOfElementLocatedByXpath(header.NOTIFICATION_SELECTED_CITY, 3);
        Assert.assertEquals(message, header.getTextOf(header.NOTIFICATION_SELECTED_CITY));
    }


    @Then("^First item of the Autosuggest list of the Header Search should be$")
//    public void firstItemOfTheAutoSuggestListOfTheHeaderSearchShouldBe(DataTable autosuggestLine) {
    public void firstItemOfTheAutoSuggestListOfTheHeaderSearchShouldBe(List<SearchProductAutoSuggestLine> autosuggestLineList) {
        System.out.println(autosuggestLineList.get(0).getImgLink());
        System.out.println(autosuggestLineList.get(0).getProductName());
        System.out.println(autosuggestLineList.get(0).getPrice());
//        SearchProductAutoSuggestLine searchProductAutoSuggestLine = new SearchProductAutoSuggestLine("http://", "Телевизор TOSHIBA 49U7750EV", "", "16999 .-");
//        List<SearchProductAutoSuggestLine> autosuggestLines = new ArrayList<>();
//        autosuggestLines.add(searchProductAutoSuggestLine);
//        try {
//            autosuggestLine.diff(DataTable.create(autosuggestLines));
//            Assert.assertTrue(true);
//        } catch (cucumber.runtime.table.TableDiffException e) {
//            Assert.assertTrue(false, e.getMessage());
//        }
    }


    @When("^Click on \"([^\"]*)\" button on Autosuggest list$")
    public void clickOnButtonOnAutosuggestList(String buttonName) {
        header.clickOnByXpath(header.BUTTON, buttonName);
    }


    @When("^Click on Show All button on Autosuggest list$")
    public void clickOnShowAllButtonOnAutoSuggestList() throws InterruptedException {
        header.clickOnShowAllButton();
    }

    @When("^Click on Global Search button in Header$")
    public void clickOnGlobalSearchButtonInHeader() {
        header.clickOnGlobalSearchButton();
    }

    @When("^Click on Global Search button of Autosuggest field in Header$")
    public void clickOnGlobalSearchButtonOfAutosuggestFieldInHeader() throws Throwable {
      header.clickOnGlobalSearchButtonOfAutosuggestField();
    }
}
