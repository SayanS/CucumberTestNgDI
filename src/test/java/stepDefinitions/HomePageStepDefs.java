package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import models.User;
import pages.HomePage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;

public class HomePageStepDefs {
    private HomePage homePage;

    public HomePageStepDefs(HomePage homePage) {
        this.homePage = homePage;
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
    public void changeUserToUniqueValue(String email) {
        DateFormat sdf = new SimpleDateFormat("MMddHHmmss");
        Calendar cal = Calendar.getInstance();
        email=email+sdf.format(cal.getTime());
        System.out.println(email);
    }
}
