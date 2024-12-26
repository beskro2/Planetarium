package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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
     TestRunner.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[3]")));
     Assert.assertEquals(3,TestRunner.homePage.getNumberOfCelestialRows());
    }

    @When("the user provides a delete moon name {string}")
    public void the_user_provides_a_delete_moon_name(String moonName) {
        TestRunner.homePage.enterdeleteobjectname(moonName);
    }


    @Then("the user should get a delete moon browser alert saying {string}")
    public void the_user_should_get_a_delete_moon_browser_alert_saying(String expectedMessage) {
        TestRunner.wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = TestRunner.driver.switchTo().alert();
        Assert.assertEquals(expectedMessage, alert.getText());
        alert.accept();
    }


}

