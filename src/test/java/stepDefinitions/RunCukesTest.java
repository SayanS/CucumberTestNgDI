package stepDefinitions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

//@RunWith(Cucumber.class)
//@CucumberOptions(plugin = {"pretty"})
@CucumberOptions(features={"src/test/resources/features"}, tags = "@run")
@Test
public class RunCukesTest extends AbstractTestNGCucumberTests {
}
