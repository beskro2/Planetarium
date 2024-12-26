package com.revature.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private WebDriver driver;


    @FindBy(id = "deleteInput")
    private WebElement deleteObjectInput;

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



    @FindBy(id = "deleteButton")
    private WebElement deleteButton;

    @FindBy(id = "planetNameInput")
    private WebElement planetNameInput;

    @FindBy(id = "moonImageInput")
    private WebElement moonFileInput;

    @FindBy(id = "planetImageInput")
    private WebElement planetFileInput;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void SelectMoonType(){
        Select select = new Select(selectElement);
        select.selectByIndex(0);
    }

    public void SelectPlanetType(){
        Select select = new Select(selectElement);
        select.selectByIndex(1);
    }

    public void enterImage(String imageName){
        photoButton.sendKeys(imageName);
    }


    public void enterMoonName(String moonName){
        moonNameInput.sendKeys(moonName);
    }

    public void enterdeleteobjectname(String objectName){
        deleteObjectInput.sendKeys(objectName);
    }


    public void enterAssociatedPlanet(String associatedPlanet){
        associatedPlanetInput.sendKeys(associatedPlanet);
    }

    public void enterPlanetName(String planetName){
        planetNameInput.sendKeys(planetName);
    }

    public void clicksubmit(){
        submitButton.click();
    }

    public void clickdelete(){
        deleteButton.click();
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

    public void entermoonimage(String url) {
        moonFileInput.sendKeys(url);
    }
    public void enterplanetimage(String url) {
        planetFileInput.sendKeys(url);
    }


}
