package models;

import org.openqa.selenium.WebDriver;

public class Browser {
    private WebDriver webDriver;
    private String browser;
    private String baseUrl;
    final public  String PATH_DOWNLOAD = "/home/user/IdeaProjects/eldoradoBdd/src/test/resources/downloads";
    final public  String PATH_WEBDRIVER="./src/test/resources/webdrivers";

    public Browser() {
    }

    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    public void setWebDriver(WebDriver webDriver){
        this.webDriver=webDriver;
    }

    public String getBaseUrl() {
        return this.baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getBrowser(){
        return  this.browser;
    }
}

