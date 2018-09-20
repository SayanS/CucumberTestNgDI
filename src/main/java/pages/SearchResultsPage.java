package pages;

import models.Browser;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage{
//    private Browser browser;
    private WebDriver webDriver;

    public SearchResultsPage(Browser browser){
        super(browser);
        this.webDriver=browser.getWebDriver();
    }
    public final String GOOD_CONTAINER=".//div[@class='goods-item-content']";
    public final String GOOD_CONTAINER_GOOD_CODE=".//div[@class='goods-code gilroyed']/span";
    public final String GOOD_CONTAINER_GOOD_DESCRIPTION=".//div[@class='good-description']//a";


}
