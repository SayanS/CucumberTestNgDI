package stepDefinitions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pages.SelectCityPopUp;

public class SelectCityStepDefs {
    private SelectCityPopUp selectCityPopUp;

    public SelectCityStepDefs(SelectCityPopUp selectCityPopUp) {
        this.selectCityPopUp = selectCityPopUp;
    }

    @When("^Click on \"([^\"]*)\" button of Select city pop-up$")
    public void clickOnButtonOfSelectCityPopUp(String buttonName) {
        selectCityPopUp.clickOnByXpath(selectCityPopUp.YES_NO_CONFIRM_CITY_BUTTONS, buttonName);
    }

    @When("^Enter \"([^\"]*)\" into City name field on Select city pop-up$")
    public void enterIntoCityNameFieldOnSelectCityPopUp(String text) throws InterruptedException {
        selectCityPopUp.enterValueIntoField(selectCityPopUp.INPUT_CITY, text);
    }

    @Then("^Each context city on Select city pop-up should start with \"([^\"]*)\"$")
    public void eachContextCityOnSelectCityPopUpShouldStartWith(String text) {
        selectCityPopUp.getListOfContextCities().forEach(cityName -> Assert.assertTrue(cityName.startsWith(text)));
    }

    @When("^Select city \"([^\"]*)\" on Select city pop-up$")
    public void selectCityOnSelectCityPopUp(String cityName) {
        selectCityPopUp.clickOnByXpath(selectCityPopUp.CITY_LINK, cityName);
    }
}
