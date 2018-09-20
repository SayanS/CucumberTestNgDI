package models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.HashMap;

public class Browser {
    private WebDriver webDriver;

    public Browser(){
        String pathToFile = "/home/user/IdeaProjects/eldoradoBdd/src/test/resources/downloads";

        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", System.getProperty("user.dir") + new File(pathToFile));

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--start-maximized");

        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("./src/test/resources/webdrivers/chromedriver"))
                .usingAnyFreePort()
                .build();

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        options.merge(capabilities);

        webDriver = new ChromeDriver(service, options);
        //  browser.webDriver.manage().window().maximize();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
