package pages;

import models.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.sections.ProductContainer;

public class SearchResultsPage extends BasePage{
    private WebDriver webDriver;

    String PRODUCT_CONTAINERS="(.//div[@class='goods-item-content'])";

    @FindBy(how= How.XPATH, using="//a[@href='/offers/best_offers/']")
    private WebElement title;

    public final String PRODUCT_CONTAINER_GOOD_CODE=".//div[@class='goods-code gilroyed']/span";
    public final String PRODUCT_CONTAINER_GOOD_DESCRIPTION=".//div[@class='good-description']//a";

    Header header;

    public SearchResultsPage(Browser browser, Header header){
        super(browser);
        this.webDriver=browser.getWebDriver();
        this.header=header;
    }


    public void addToCartFirstProduct() {
        (new ProductContainer(webDriver,findBy(PRODUCT_CONTAINERS+"[1]")))
                .clickOnAddToCartButton();
    }
}
