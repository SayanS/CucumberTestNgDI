package runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features={"src/test/resources/features"},
        glue="stepDefinitions" ,
        tags = "@run,~@ignore",
        plugin = {"html:target/cucumber-pretty","json:target/cucumber.json"})
public class RunCukesTestSeries extends AbstractTestNGCucumberTests{

}
