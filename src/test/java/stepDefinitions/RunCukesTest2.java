package stepDefinitions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
//@CucumberOptions(plugin = {"pretty"})
@CucumberOptions(features={"src/test/resources/features/additional.feature"}, tags = "@run")
//@Test
public class RunCukesTest2 extends AbstractTestNGCucumberTests {
//    WebDriver webDriver;
//    public  RunCukesTest2(Browser browser){
//        webDriver=browser.getWebDriver();
//    }
}
