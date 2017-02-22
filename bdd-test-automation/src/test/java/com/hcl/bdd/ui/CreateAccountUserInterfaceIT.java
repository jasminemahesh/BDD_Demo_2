package com.hcl.bdd.ui;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateAccountUserInterfaceIT {

    private WebDriver driver;

    private static final int TIMEOUT = 120;
    private static final int SLEEPTIME = 120;

    @When("^the Customer information is keyed in$")
    public void the_Customer_is_created_with_Details(DataTable customerDataTable) throws Throwable {

	final DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
	capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);

	final File file = new File(
		"D:\\backup\\Projects\\Demo\\spring-mvc-webapp-master\\src\\test\\resources\\IEDriverServer.exe");

	System.setProperty("webdriver.ie.driver", file.getAbsolutePath());

	driver = new InternetExplorerDriver(capabilities);

	driver.get("http://localhost:8080/training-1.0.0-BUILD-SNAPSHOT/customer/create");

	List<List<String>> customerList = customerDataTable.raw();
	driver.findElement(By.id("firstname")).sendKeys(customerList.get(0).get(0));
	driver.findElement(By.id("lastname")).sendKeys(customerList.get(0).get(1));
	driver.findElement(By.id("gender")).sendKeys(customerList.get(0).get(2));
	driver.findElement(By.id("phone")).sendKeys(customerList.get(0).get(3));
	driver.findElement(By.id("email")).sendKeys(customerList.get(0).get(4));
	driver.findElement(By.id("nationalId")).sendKeys(customerList.get(0).get(5));
	driver.findElement(By.id("address")).sendKeys(customerList.get(0).get(6));
	driver.findElement(By.id("city")).sendKeys(customerList.get(0).get(7));
	driver.findElement(By.id("postalCode")).sendKeys(customerList.get(0).get(8));
	driver.findElement(By.id("country")).sendKeys(customerList.get(0).get(9));
	driver.findElement(By.id("accountType")).sendKeys(customerList.get(0).get(10));
	driver.findElement(By.id("balance")).sendKeys(customerList.get(0).get(11));

	new WebDriverWait(driver, TIMEOUT, SLEEPTIME);
    }

    @Then("^customer is created successfully$")
    public void customer_is_created_successfully() throws Throwable {
	driver.findElement(By.id("createCustomer")).sendKeys(Keys.ENTER);
	assertEquals("Customer creation Failed", driver.getTitle(), "Customer Management - Create Customer");
	new WebDriverWait(driver, TIMEOUT, SLEEPTIME);

	driver.quit();
    }

}
