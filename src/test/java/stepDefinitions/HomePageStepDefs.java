package stepDefinitions;

import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import models.User;
import pages.HomePage;
import utils.GenerateUniqueEmail;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class HomePageStepDefs {
    private HomePage homePage;
    public HomePageStepDefs(HomePage homePage) {
        this.homePage=homePage;
    }

    @Given("^Home page is opened$")
    public void homePageIsOpened() throws Throwable {
        homePage.open();
    }

    @Given("^User credentials$")
    public void userCredentialsAnd(List<User> user) {
        User testUser=new User("test","password", new HashSet<String>(Arrays.asList("testSkill")));
        User secondTestUser=new User();
        secondTestUser=testUser;
        user.get(0).setSkills(testUser.getSkills());
        user.get(0).addSkill("Java+Junit+Cucumber");
        System.out.println(user.get(0).getLogin()+ " - "+user.get(0).getPassword()+" - "+user.get(0).getSkills());
    }

    @Then("^Change user \"([^\"]*)\" to unique value$")
    public void changeUserToUniqueValue(@Transform(GenerateUniqueEmail.class) String email) {
        System.out.println(email);
    }
}
