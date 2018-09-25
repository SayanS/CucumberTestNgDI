package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/features/globalSearch.feature"}, tags = "@run", plugin = {"html:target/cucumber-pretty","json:target/cucumber-report.json"})
public class RunCukesTest extends AbstractTestNGCucumberTests {
//    @DataProvider(parallel = true)
//    @Override
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }
}
