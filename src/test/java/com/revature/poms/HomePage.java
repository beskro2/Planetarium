package com.revature.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HomePage {
    private WebDriver driver;


    @FindBy(id = "moonImageInput")
    private WebElement photoButton;

    @FindBy(xpath = "//button[@class ='submit-button']")
    private WebElement submitButton;

    @FindBy(id = "locationSelect")
    private WebElement selectElement;

    @FindBy(id = "moonNameInput")
    private WebElement moonNameInput;

    @FindBy(id ="orbitedPlanetInput")
    private WebElement associatedPlanetInput;

    @FindBy(id = "greeting")
    private WebElement greetingHeader;

    @FindBy(id = "logoutButton")
    private WebElement logoutButton;

    @FindBy(tagName = "tr")
    private List<WebElement> tableRows;




    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
//check this works
    public void getSelectionType(){
        Select select = new Select(selectElement);
        select.selectByIndex(0);
    }

    public void enterImage(String imageName){
        photoButton.sendKeys(imageName);
    }


    public void enterMoonName(String moonName){
        moonNameInput.sendKeys(moonName);
    }

    public void enterAssociatedPlanet(String associatedPlanet){
        associatedPlanetInput.sendKeys(associatedPlanet);
    }

    public void clicksubmit(){
        submitButton.click();
    }

    public String getHomePageGreeting(){
        return greetingHeader.getText();
    }

    public int getNumberOfCelestialRows(){
        return tableRows.size()-1;
    }

    public void tryToAccessHomePageDirectly(){
        driver.get("http://localhost:8080/planetarium");
    }

    public void logout(){
        logoutButton.click();
    }

}
