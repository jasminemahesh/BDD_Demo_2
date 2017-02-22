package com.hcl.bdd;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.bdd.domain.Customer;

import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateAccountStepDefinitonIT extends SpringIntegrationTest {

    private MockMvc mockMvc;
    ResultActions resultActions = null;
    Customer customer;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @When("^Create Account for user$")
    public void create_Customer_with_firstname(DataTable accountDataTable) throws Throwable {
	List<List<String>> customerList = accountDataTable.raw();

	customer = new Customer();
	customer.setFirstname(customerList.get(0).get(0));
	customer.setLastname(customerList.get(0).get(1));
	customer.setGender(customerList.get(0).get(2));
	customer.setPhone(customerList.get(0).get(3));
	customer.setEmail(customerList.get(0).get(4));
	customer.setNationalId(customerList.get(0).get(5));
	customer.setAddress(customerList.get(0).get(6));
	customer.setCity(customerList.get(0).get(7));
	customer.setPostalCode(customerList.get(0).get(8));
	customer.setCountry(customerList.get(0).get(9));
	customer.setAccountType(customerList.get(0).get(10));
	customer.setBalance(new Double(customerList.get(0).get(11)));

	mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

	resultActions = mockMvc.perform(post("/customer/create").contentType(MediaType.APPLICATION_JSON_UTF8).content(
		new ObjectMapper().writeValueAsBytes(customer)));

    }

    @Then("^An Account for \"([^\"]*)\" \"([^\"]*)\" is created$")
    public void a_Account_for_Daniel_Smith_is_created(String firstname, String lastname) throws Throwable {
	resultActions.andExpect(status().isCreated())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andExpect(jsonPath("$.firstname", equalTo(firstname)))
		.andExpect(jsonPath("$.lastname", equalTo(lastname)));
    }

    @Then("^Service throws error (\\d+)$")
    public void service_throws(int status) throws Throwable {
	resultActions.andExpect(status().is(status)).andExpect(
		content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

}
