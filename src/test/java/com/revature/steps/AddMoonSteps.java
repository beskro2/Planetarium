package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;

public class AddMoonSteps {

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
      TestRunner.loginPage.setUpLoggedInUser();
    }


    @Given("The Moon is selected")
    public void the_moon_is_selected(){
        TestRunner.homePage.getSelectionType();
    }

    @When("User provides a valid add moon name")
    public void user_provides_a_valid_add_moon_name() {
        TestRunner.homePage.enterMoonName("Sam Wise_22-");
    }

    @And("user provides a valid associated planet")
    public void userProvidesAValidAssociatedPlanet() {
       TestRunner.homePage.enterAssociatedPlanet("frodo");
    }

    @And("the user provides a moon picture {string}")
    public void theUserProvidesAMoonPicture(String arg0) {
    }
            //replace url
    @When("And the user provides a moon picture")
    public void and_the_user_provides_a_moon_picture() {
     TestRunner.homePage.enterImage("image url");
    }

    @When("the user submits the add moon criteria")
    public void the_user_submits_the_add_moon_criteria() {
       TestRunner.homePage.clicksubmit();
    }

    @Then("the user should view the Moon from the home page")
    public void the_user_should_view_the_Moon_from_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user provides add moon name {string}")
    public void theUserProvidesAddMoonName(String MoonName) {
        TestRunner.homePage.enterMoonName(MoonName);
    }


    @And("the user provides associatedPlanet {string}")
    public void theUserProvidesAssociatedPlanet(String associatedPlanet) {
        TestRunner.homePage.enterAssociatedPlanet(associatedPlanet);
    }



    @Then("the user should get a add moon browser alert saying {string}")
    public void the_user_should_get_a_add_moon_browser_alert_saying(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }



}
