package com.oranum;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

/**
 * Unit test for simple App.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = { "stepsDef"}, tags = "@oranum", plugin = {"html:target/cucumber-reports/cucumber.html","json:target/cucumber-reports/cucumber.json"})
public class TestRunner {
	
}
