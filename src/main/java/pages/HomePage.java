package pages;

import models.Browser;
import org.openqa.selenium.WebDriver;

public class HomePage extends Header {
    private String URL = "https://eldorado.ua/";
//    private Browser browser;
    private WebDriver webDriver;

    public HomePage(Browser browser) {
        super(browser);
        this.webDriver=browser.getWebDriver();
//        webDriver = browser.webDriver;
    }

    public void open() {
        webDriver.navigate().to(URL);
    }

}
