package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeletePlanetSteps {



    @When("the user provides a valid delete planet name")
    public void the_user_provides_a_valid_delete_planet_name() {
      TestRunner.homePage.enterdeleteobjectname("Earth");
    }



    @Then("the planet will be deleted from the homepage")
    public void the_planet_will_be_deleted_from_the_homepage() {
        TestRunner.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[3]")));
        Assert.assertEquals(2,TestRunner.homePage.getNumberOfCelestialRows());
    }

 

    @When("the user submits the delete planet criteria")
    public void the_user_submits_the_delete_planet_criteria() {
        TestRunner.homePage.clickdelete();
    }

 

    @When("the user provides a delete planet name {string}")
    public void theUserProvidesADeletePlanetName(String planetName) {
        TestRunner.homePage.enterdeleteobjectname(planetName);
    }

    @Then("the user should get a delete planet browser alert saying {string}")
    public void theUserShouldGetADeletePlanetBrowserAlertSaying(String expectedMessage) {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        Assert.assertEquals(expectedMessage, alert.getText());
        alert.accept();
    }
}
