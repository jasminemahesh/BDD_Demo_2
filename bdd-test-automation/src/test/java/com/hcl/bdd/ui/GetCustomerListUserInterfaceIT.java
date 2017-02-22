package com.hcl.bdd.ui;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GetCustomerListUserInterfaceIT {

    private WebDriver driver;

    private static final int TIMEOUT = 120;
    private static final int SLEEPTIME = 120;

    @Given("^the search criteria is \"([^\"]*)\" customerid \"([^\"]*)\"$")
    public void theSearchCriteriaIsCustomerId(String validOrInvalid, String customerId) throws Throwable {

	final DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
	capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

	final File file = new File(
		"D:\\backup\\Projects\\Demo\\spring-mvc-webapp-master\\src\\test\\resources\\IEDriverServer.exe");

	System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
	driver = new InternetExplorerDriver(capabilities);
	driver.get("http://localhost:8080/training-1.0.0-BUILD-SNAPSHOT/");

	// Find the text input element by its name
	WebElement element = driver.findElement(By.id("search"));

	// Enter something to search for
	element.sendKeys(customerId);

    }

    @When("^the \"([^\"]*)\" button is clicked$")
    public void theSearchByIdButtonClicked(String searchButton) throws Throwable {

	// Find the text input element by its name
	WebElement element = driver.findElement(By.id(searchButton));

	// Enter something to search for
	element.sendKeys(Keys.ENTER);
	new WebDriverWait(driver, TIMEOUT, SLEEPTIME);

    }
    
   /* @Then("^the customer details for (\\d+) is retrieved$")
    public void the_customer_details_for_is_retrieved(int accountId){
		String accountIdStr=new Integer(accountId).toString();
		
		// Find the text input element by its name
		WebElement element = driver.findElement(By.id("info"));
		assertTrue(element.getText().contains(accountIdStr));

		driver.quit();
    }*/

    @Then("^the customer details for \"([^\"]*)\" is retrieved$")
    public void the_customer_details_for_customerId_is_retrieved(String customerId) throws Throwable {

	// Find the text input element by its name
	WebElement element = driver.findElement(By.id("info"));
	assertTrue(element.getText().contains(customerId));

	driver.quit();

    }

    @Then("^the error \"([^\"]*)\" is shown$")
    public void the_error_is_shown(String error) throws Throwable {

	// Find the text input element by its name
	WebElement element = driver.findElement(By.id("info"));

	System.out.println(element.getText());
	assertTrue(element.getText().contains(error));

	driver.quit();

    }

}
