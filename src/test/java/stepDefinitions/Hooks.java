package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import models.Browser;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.openqa.selenium.OutputType.BYTES;

public class Hooks {
    private WebDriver webDriver;

    public Hooks(Browser browser) {
        this.webDriver = browser.getWebDriver();
    }


    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot =((TakesScreenshot) webDriver).getScreenshotAs(BYTES);
            scenario.embed(screenshot, "image/png");
            System.out.println("ghhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhsssssss "+screenshot.toString());
            InputStream targetStream = new ByteArrayInputStream(((TakesScreenshot) webDriver).getScreenshotAs(BYTES));
        }
        webDriver.close();
    }
}
