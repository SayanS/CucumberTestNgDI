package pages.sections;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.PageHelpers;

public class ProductContainer {
    private WebDriver webDriver;
    private WebElement productContainer;
    private  PageHelpers pageHelpers;

    String ADD_TO_CART_BUTTON=".buy-button.sp.valign-wrapper";
    private WebElement addToCartButton;

    public ProductContainer(WebDriver webDriver, WebElement productContainer){
        this.webDriver=webDriver;
        this.productContainer=productContainer;
        pageHelpers=new PageHelpers(webDriver);
    }

    public void clickOnAddToCartButton() {
        pageHelpers.findBy(ADD_TO_CART_BUTTON)
                .click();
    }

}
