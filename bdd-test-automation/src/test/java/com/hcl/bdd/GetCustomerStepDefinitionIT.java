package com.hcl.bdd;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.hcl.bdd.domain.Customer;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GetCustomerStepDefinitionIT {

    private MockMvc mockMvc;
    ResultActions resultActions = null;
    Customer customer = null;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @When("^Get the Customer Details for Account Id (\\d+)$")
    public void get_the_Customer_with_Customer_Id(int customerId) throws Throwable {
	mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	resultActions = mockMvc
		.perform(get("/customer/get/" + customerId).contentType(MediaType.APPLICATION_JSON_UTF8));
    }

    @Then("^Customer Details for Account Id (\\d+) is retrieved$")
    public void a_Customer_with_Customer_Id_is_retrieved(int customerId) throws Throwable {
	resultActions.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andExpect(jsonPath("$.accountId", equalTo(customerId)));
    }
    
    @Then("^Service Throws Error (\\d+)$")
    public void service_Throws_Error(int status) throws Throwable {
	resultActions.andExpect(status().is(status)).andExpect(
		content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
    }

}
