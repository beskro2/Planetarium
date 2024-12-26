package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DeleteMoonSteps {


    @When("the user provides a valid delete moon name")
    public void the_user_provides_a_valid_delete_moon_name() {
        TestRunner.homePage.enterdeleteobjectname("Luna");
    }

    @When("the user submits the delete moon criteria")
    public void the_user_submits_the_delete_moon_criteria() {
      TestRunner.homePage.clickdelete();
    }

    @Then("the moon will be deleted from the homepage")
    public void the_moon_will_be_deleted_from_the_homepage() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("the user provides a delete moon name {name}")
    public void the_user_provides_a_delete_moon_name_name() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the user should get a delete moon browser alert saying {string}")
    public void theUserShouldGetADeleteMoonBrowserAlertSaying(String expectedMessage) {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        Assert.assertEquals(expectedMessage, alert.getText());
        alert.accept();
    }

    @When("the user provides a delete moon name {string}")
    public void theUserProvidesADeleteMoonName(String arg0) {
    }
}

