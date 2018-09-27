package pages;

import models.Browser;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class SelectCityPopUp extends BasePage {
    private WebDriver webDriver;

    public SelectCityPopUp(Browser browser) {
        super(browser);
        this.webDriver = browser.getWebDriver();
    }

    public String YES_NO_CONFIRM_CITY_BUTTONS = ".//div[@class='select-city-li']//*[contains(@class,'button') and .='$KeyWord']";
    public String INPUT_CITY = ".//div[@class='city-select']//input[@class='react-autosuggest__input']";
    public String CONTEXT_CITIES = ".//ul[@class='city-select-content row']/li/div";
    public String CITY_LINK=".//ul[@class='city-select-content row']/li/div[.='$KeyWord']";

    public List<String> getListOfContextCities() {
      return getTextValuesOf(CONTEXT_CITIES);
    }


}
