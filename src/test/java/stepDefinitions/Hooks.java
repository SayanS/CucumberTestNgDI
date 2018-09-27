package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import models.Browser;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;

import static org.openqa.selenium.OutputType.BYTES;


public class Hooks {
    private Browser browser;

    public Hooks(Browser browser) throws InterruptedException {
        this.browser = browser;
    }

    @Before
    public void setUpBrowser() throws InterruptedException {
        browser.setBrowser(System.getProperty("browser"));
        this.browser.setBaseUrl(System.getProperty("baseUrl"));
        System.out.println(this.browser);
         switch (browser.getBrowser()) {
            case "chrome": {
                HashMap<String, Object> chromePrefs = new HashMap();
                chromePrefs.put("profile.default_content_settings.popups", 0);
                chromePrefs.put("download.default_directory", System.getProperty("user.dir") + new File(browser.PATH_DOWNLOAD));
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", chromePrefs);
                options.addArguments(new String[]{"--disable-popup-blocking"});
                options.addArguments(new String[]{"--start-maximized"});
                ChromeDriverService service = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File(browser.PATH_WEBDRIVER+"/chromedriver"))
                        .usingAnyFreePort()
                        .build();
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                options.merge(capabilities);
                browser.setWebDriver(new ChromeDriver(service, options));
                break;
            }
            case "firefox": {
                break;
            }
            default: {
                HashMap<String, Object> chromePrefs = new HashMap();
                chromePrefs.put("profile.default_content_settings.popups", 0);
                chromePrefs.put("download.default_directory", System.getProperty("user.dir") + new File(browser.PATH_DOWNLOAD));
                ChromeOptions options = new ChromeOptions();
                options.setExperimentalOption("prefs", chromePrefs);
                options.addArguments(new String[]{"--disable-popup-blocking"});
                options.addArguments(new String[]{"--start-maximized"});
                ChromeDriverService service = new ChromeDriverService.Builder()
                        .usingDriverExecutable(new File(browser.PATH_WEBDRIVER+"/chromedriver"))
                        .usingAnyFreePort()
                        .build();
                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                options.merge(capabilities);
                browser.setWebDriver(new ChromeDriver(service, options));
                break;
            }
        }
        this.browser.getWebDriver().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot =((TakesScreenshot) browser.getWebDriver()).getScreenshotAs(BYTES);
            scenario.embed(screenshot, "image/png");
            System.out.println("ghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhsssssss "+screenshot.toString());
            InputStream targetStream = new ByteArrayInputStream(((TakesScreenshot) browser.getWebDriver()).getScreenshotAs(BYTES));
        }
        browser.getWebDriver().close();
    }
}
