package com.revature.steps;

import com.revature.TestRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.revature.TestRunner.driver;

public class LoginSteps {


    @When("the user provides a valid login username")
    public void the_user_provides_a_valid_login_username() {
        TestRunner.loginPage.enterLoginUsername("Batman");
    }

    @When("the user provides a valid login password")
    public void the_user_provides_a_valid_longin_password() {
    TestRunner.loginPage.enterLoginPassword("Iamthenight1939");
    }



    @When("the user submits the login credentials")
    public void the_user_submits_the_login_credentials() {
        TestRunner.loginPage.clickSubmit();
    }


    @Then("The user will be directed to the home page")
    public void the_user_will_be_directed_to_the_home_page() {
        TestRunner.wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("Welcome to the Home Page Batman")));
        Assert.assertEquals("Welcome to the Home Page Batman", driver.getTitle());
    }

    @When("the user provides login username {string}")
    public void the_user_provides_login_username(String username){
    TestRunner.loginPage.enterLoginUsername(username);
    }

    @When("the user provides login password {string}")
    public void the_user_provides_login_password(String password) {
       TestRunner.loginPage.enterLoginPassword(password);
    }

    @Then("the user should get a browser login alert saying {alert}")
        public void the_user_should_get_a_browser_login_alert_saying(String expectedMessage){
            TestRunner.wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = TestRunner.driver.switchTo().alert();
            Assert.assertEquals(expectedMessage, alert.getText());
            alert.accept();
        }

    }


