package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/features/additional.feature"},
                 glue="stepDefinitions" ,
                 tags = "@run",
                 plugin = {"html:target/cucumber-pretty/2","json:target/cucumber-report2.json"})
public class RunCukesTest2 extends AbstractTestNGCucumberTests {
}
