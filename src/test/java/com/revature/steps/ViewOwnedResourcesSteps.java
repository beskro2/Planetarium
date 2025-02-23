package com.revature.steps;


import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class ViewOwnedResourcesSteps {

    @Given("the user is logged in on the home page")
    public void the_user_is_logged_in_on_the_home_page() {
        TestRunner.loginPage.setUpLoggedInUser();
    }

    @Given("the user is not logged in")
    public void the_user_is_not_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.loginPage.openLoginPage();
    }





    @When("the user tries to directly access the home page")
    public void the_user_tries_to_directly_access_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        TestRunner.homePage.tryToAccessHomePageDirectly();
    }


    @Then("they should see their planets and moons")
    public void they_should_see_their_planets_and_moons() {
        // Write code here that turns the phrase above into concrete actions
        try{
            TestRunner.wait.until(ExpectedConditions.titleIs("Home"));
            Assert.assertEquals(
                    String.format(
                            "Expected 'Welcome to the Home Page Batman, but got %s",
                            TestRunner.homePage.getHomePageGreeting()
                    ),
                    "Welcome to the Home Page Batman",
                    TestRunner.homePage.getHomePageGreeting());
            Assert.assertEquals(4, TestRunner.homePage.getNumberOfCelestialRows());
        } finally {
            TestRunner.homePage.logout();
        }
    }

    @Then("the user should be denied access")
    public void the_user_should_be_denied_access() {
        // Write code here that turns the phrase above into concrete actions
        Assert.assertNotEquals("Home", TestRunner.driver.getTitle());
    }
}
