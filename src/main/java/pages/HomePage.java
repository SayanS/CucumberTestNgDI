package pages;

import models.Browser;
import org.openqa.selenium.WebDriver;

public class HomePage extends Header {
    private String url;
    private WebDriver webDriver;

    public HomePage(Browser browser) {
        super(browser);
        this.webDriver=browser.getWebDriver();
        this.url=browser.getBaseUrl();
    }

    public void open() {
        webDriver.navigate().to(url);
    }

}
