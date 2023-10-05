package stepsDef;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import driverUtil.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.cucumber.java8.En;
import pages.OranumHomePage;

public class SearchFeature extends DriverManager {

	private static final Logger logger = LoggerFactory.getLogger(SearchFeature.class);
	public static WebDriver driver;

	OranumHomePage oranumHomePage;

	@Given("^user is on the oranum home page$")
	public void user_is_on_the_home_page() {
		driver = createDriver();
		oranumHomePage = new OranumHomePage(driver);
		driver.get("https://www.oranum.com/en/");
		logger.info("Oranum Homepage is displayed");
	}

	@When("^user clicks on search box$")
	public void user_clicks_on_search_box() {
		oranumHomePage.clickSerach();
	}

	@When("searches a {string}")
	public void searches_a(String name) {
		oranumHomePage.serachName(name);
	}

	@Then("all results should contain {string}")
	public void valid_result_should_be_displayed(String name) {
		assertTrue("All result does not contain the name: " + name, oranumHomePage.isPartialMatch(name));
		 driver.close();
	}
}
