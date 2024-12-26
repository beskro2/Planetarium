package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddMoonSteps {

    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
      TestRunner.loginPage.setUpLoggedInUser();
    }


    @Given("The Moon is selected")
    public void the_moon_is_selected(){
        TestRunner.homePage.SelectMoonType();
    }

    @When("User provides a valid add moon name")
    public void user_provides_a_valid_add_moon_name() {
        TestRunner.homePage.enterMoonName("Sam Wise_22-");
    }

    @And("user provides a valid associated planet")
    public void userProvidesAValidAssociatedPlanet() {
       TestRunner.homePage.enterAssociatedPlanet("1");
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
    public void the_user_should_view_the_Moon_from_the_home_page()  {
        TestRunner.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[5]")));
        Assert.assertEquals(5, TestRunner.homePage.getNumberOfCelestialRows());
    }






    @And("the user provides associatedPlanet {string}")
    public void theUserProvidesAssociatedPlanet(String associatedPlanet) {
        TestRunner.homePage.enterAssociatedPlanet(associatedPlanet);
    }



    @Then("the user should get a add moon browser alert saying {string}")
    public void the_user_should_get_a_add_moon_browser_alert_saying(String expectedMessage) {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        Assert.assertEquals(expectedMessage, alert.getText());
        alert.accept();
    }


    @When("the user provides a delete moon name  {string}")
    public void theUserProvidesADeleteMoonName(String MoonName) {
        TestRunner.homePage.enterMoonName(MoonName);
    }



}
