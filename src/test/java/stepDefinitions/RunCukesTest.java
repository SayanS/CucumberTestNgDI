package stepDefinitions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
//@CucumberOptions(plugin = {"pretty"})
@CucumberOptions(features={"src/test/resources/features/globalSearch.feature"}, tags = "@run")
//@Test
public class RunCukesTest extends AbstractTestNGCucumberTests {
//    WebDriver webDriver;
//    public  RunCukesTest(Browser browser){
//        webDriver=browser.getWebDriver();
//    }
}
