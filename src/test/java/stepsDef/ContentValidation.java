package stepsDef;

import static org.junit.Assert.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import driverUtil.DriverManager;
import io.cucumber.java.en.*;
import pages.OranumHomePage;

public class ContentValidation extends DriverManager{

	OranumHomePage oranumHomePage;
	private static final Logger logger = LoggerFactory.getLogger(ContentValidation.class);

	@Given("user is on the home page")
	public void user_is_on_the_home_page() {
		driver = createDriver();
		oranumHomePage = new OranumHomePage(driver);
		driver.get("https://www.oranum.com/en/");
		logger.info("Oranum homepage is displayed");
	}

	@When("user selects {string}")
	public void user_selects(String selection) {
		oranumHomePage.clickOption(selection);
	}

	@Then("content matching {string} is displayed")
	public void content_matching_is_displayed(String selection) throws InterruptedException {
		oranumHomePage.clickPopup();
		oranumHomePage.loadAllResults();
		assertTrue("Selection not found", oranumHomePage.isSelectionPresent(selection));
	}

	@Then("no duplicate content is displayed")
	public void no_duplicate_content_is_displayed() {
		assertTrue("Values are not unique", oranumHomePage.isContentUnique());
		driver.close();
	}
}
