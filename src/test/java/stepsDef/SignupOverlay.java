package stepsDef;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import driverUtil.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.OranumHomePage;

public class SignupOverlay extends DriverManager {

	public static WebDriver driver;
	OranumHomePage oranumHomePage;
	private static final Logger logger = LoggerFactory.getLogger(SignupOverlay.class);

	@Given("user is on the live chat page")
	public void user_is_on_the_live_chat_page() {
		driver = createDriver();
		oranumHomePage = new OranumHomePage(driver);
		driver.get("https://oranum.com/en/chat/LovePsychyicAnie");
	}

	@When("user clicks on below {string}")
	public void user_clicks_on_below(String button) {
		oranumHomePage.clickButton(button);
	}

	@Then("buttons will trigger a {string} overlay to be displayed")
	public void buttons_will_trigger_a_overlay_to_be_displayed(String signup) {
		assertTrue("Signup overlay is displayed", oranumHomePage.isSignupPopup(signup));
		driver.close();
	}
}
