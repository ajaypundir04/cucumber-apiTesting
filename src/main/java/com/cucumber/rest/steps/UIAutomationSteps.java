package com.cucumber.rest.steps;

import com.cucumber.rest.Driver.SeleniumWebdriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class UIAutomationSteps {
    WebDriver dr;
    SeleniumWebdriver sb;
    @Given("^navigate to Gmail page$")
    public void navigate() throws Exception{
        sb=new SeleniumWebdriver(SeleniumWebdriver.Browsers.Chrome,"http://www.gmail.com");
    }
    @When("^user logged in using username as \"(.*)\" and password as \"(.*)\"$")
    public void login(String username,String password) throws Exception{
        sb.getWebElement(SeleniumWebdriver.Locators.xpath,"Email").sendKeys(username);
        sb.getWebElement(SeleniumWebdriver.Locators.xpath,"Passwd").sendKeys(username);
        sb.getWebElement(SeleniumWebdriver.Locators.xpath,"signIn").sendKeys(username);
        sb.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Then("^home page should be displayed$")
    public void verifySuccessful()throws  Exception{
        String expectedText="Gmail";
        String actualText= sb.getWebElement(SeleniumWebdriver.Locators.xpath,"//*[@id='gbq1']/div/a/span").getText();
        Assert.assertTrue("Login not successful",expectedText.equals(actualText));
    }
}
