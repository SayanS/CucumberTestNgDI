package stepDefinitions;

import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import models.Browser;
import models.User;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.GenerateUniqueEmail;
import utils.TestListener;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Listeners(TestListener.class)
@Test
public class HomePageStepDefs {
    private HomePage homePage;
    public Browser browser;


    public HomePageStepDefs(HomePage homePage, Browser browser) {
        this.homePage = homePage;
        this.browser=browser;
    }

    @Given("^Home page is opened$")
    public void homePageIsOpened() throws Throwable {
        homePage.open();
    }

    @Given("^User credentials$")
    public void userCredentialsAnd(List<User> user) {
        User testUser = new User("test", "password", new HashSet<String>(Arrays.asList("testSkill")));
        User secondTestUser = new User();
        secondTestUser = testUser;
        user.get(0).setSkills(testUser.getSkills());
        user.get(0).addSkill("Java+Junit+Cucumber");
        System.out.println(user.get(0).getLogin() + " - " + user.get(0).getPassword() + " - " + user.get(0).getSkills());
    }

    @Then("^Change user \"([^\"]*)\" to unique value$")
    public void changeUserToUniqueValue(@Transform(GenerateUniqueEmail.class) String email) {
        System.out.println(email);
    }


    @When("^Print Super value$")
    public void printSuperValue() throws Throwable {
        System.out.println("SHARED VALUE SHARED VALUE SHARED VALUE SHARED VALUE SHARED VALUE SHARED VALUE");
        System.out.println(browser.getSuperValue());
        browser.setSuperValue("ну просто супер передача параметра!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
