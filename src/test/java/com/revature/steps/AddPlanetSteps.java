package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AddPlanetSteps {



    @Given("The Planet is selected")
    public void the_planet_is_selected(){
        TestRunner.homePage.SelectPlanetType();
    }

    @When("the user provides a valid add planet name")
    public void the_user_provides_a_valid_add_planet_name() {
    TestRunner.homePage.enterPlanetName("Treader -2_2");
    }


    @When("And the user provides a valid planet file type")
    public void and_the_user_provides_a_valid_planet_file_type() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user submits the add planet criteria")
    public void the_user_submits_the_add_planet_criteria() {
    TestRunner.homePage.clicksubmit();
    }

    @Then("a new planet is added")
    public void a_new_planet_is_added()  {
        TestRunner.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[6]")));
       Assert.assertEquals(5, TestRunner.homePage.getNumberOfCelestialRows());
    }

    @Then("a user should get a add planet browser alert saying {string}")
    public void aUserShouldGetAAddPlanetBrowserAlertSaying(String expectedAlert) {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        Assert.assertEquals(expectedAlert, alert.getText());
        alert.accept();
    }

    @When("the user provides a add planet name {string}")
    public void theUserProvidesAAddPlanetName(String planetName) {
        TestRunner.homePage.enterPlanetName(planetName);
    }

    @And("the user provides a valid planet file type")
    public void theUserProvidesAValidPlanetFileType() {
        TestRunner.homePage.enterplanetimage("C:\\Users\\eskro\\OneDrive\\Desktop\\Testing project 1\\Planetarium_Project\\earth-blue-planet-globe-planet-87651.jpeg");
        
    }

    @And("the user provides a planet image  <{string}>")
    public void theUserProvidesAPlanetImage(String expectedMessage) {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        Assert.assertEquals(expectedMessage, alert.getText());
        alert.accept();
    }
}
