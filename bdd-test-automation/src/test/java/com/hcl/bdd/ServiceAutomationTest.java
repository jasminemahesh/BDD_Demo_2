package com.hcl.bdd;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/service", plugin = { "pretty", "html:target/cucumber" })
public class ServiceAutomationTest {

}
