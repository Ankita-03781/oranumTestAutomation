package pages;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OranumHomePage {

	WebDriver driver;
	WebDriverWait wait;

	By popup = By.xpath("//div[@class='notifier-message-content']/a");
	By showMore = By.xpath("//a[@class='btn btn--large showmore']");
	By footer = By.xpath("//div[@class='page-foot-main-container']");
	By thumbList = By.xpath("//article[@data-type='performer']//div[@class='thumb-data-willingness-list']");
	By performers = By.xpath("//article[@data-type='performer']");
	By links = By.tagName("a");
	By endOfshowMore = By.xpath("//*[@class='btn btn--large showmore' and @style='display: none;']");
	By search = By.xpath("//input[@class='toolbar-search-input']");
	By searchSuggestion = By
			.xpath("//ul[@class='toolbar-autosuggest autosuggest']/li[@class='toolbar-autosuggest-row']");
	By leftBar = By.xpath("//div[@class='toolbar js_toolbar']");
	By getCredit = By.xpath("//div[@data-id = 'buyCreditIcon']");
	By addFavorite = By.xpath("//*[@class='mc_heart_anim_container']");
	By suprise = By.xpath("//*[@data-id='surpriseIcon']");
	By startSession = By.xpath("//*[@id='mc_btn_start_private']");
	By loginOverlay = By.xpath("//*[@class='mc_js_login_or_signup']");

	public OranumHomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void clickOption(String selection) {
		WebElement option = driver.findElement(By.partialLinkText(selection));
		wait.until(ExpectedConditions.visibilityOf(option));
		option.click();
	}

	public void clickSerach() {
		WebElement serachText = driver.findElement(search);
		wait.until(ExpectedConditions.visibilityOf(serachText));
		serachText.click();
	}

	public void serachName(String name) {
		WebElement serachText = driver.findElement(search);
		serachText.sendKeys(name);
	}

	public void clickButton(String button) {
		WebElement leftBarArea = driver.findElement(leftBar);

		Actions act = new Actions(driver);
		act.moveToElement(leftBarArea).perform();

		WebElement getCreditButton = driver.findElement(getCredit);
		WebElement addFavoriteButton = driver.findElement(addFavorite);
		WebElement supriseButton = driver.findElement(suprise);
		WebElement startSessionButton = driver.findElement(startSession);

		switch (button) {
		case "Get Credits":
			getCreditButton.click();
			break;

		case "Add to favorites":
			addFavoriteButton.click();
			break;

		case "Surprise":
			supriseButton.click();
			break;

		case "Start Session":
			startSessionButton.click();
			break;
		}
	}

	public boolean isPartialMatch(String name) {
		List<WebElement> results = driver.findElements(searchSuggestion);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(searchSuggestion));
		boolean flag = false;

		for (WebElement element : results) {
			String resultStr = element.getText().toString();
			flag = containsIgnoreCase(resultStr, name);
		}

		return flag;
	}

	public boolean isSignupPopup(String signup) {
		WebElement overlay = driver.findElement(loginOverlay);
		String signupPopup = overlay.getText();
		return containsIgnoreCase(signupPopup, signup);
	}

	public static boolean containsIgnoreCase(String resultStr, String name) {
		final int length = name.length();
		if (length == 0)
			return true;

		final char firstLo = Character.toLowerCase(name.charAt(0));
		final char firstUp = Character.toUpperCase(name.charAt(0));

		for (int i = resultStr.length() - length; i >= 0; i--) {
			final char ch = resultStr.charAt(i);
			if (ch != firstLo && ch != firstUp)
				continue;

			if (resultStr.regionMatches(true, i, name, 0, length))
				return true;
		}

		return false;
	}

	public void clickPopup() {
		WebElement alert = driver.findElement(popup);
		wait.until(ExpectedConditions.visibilityOf(alert));
		alert.click();
	}
	
	public boolean isElementVisible(){
		 try {
		        driver.findElement(showMore);
		        return true;
		    } catch (org.openqa.selenium.NoSuchElementException e) {
		        return false;
		    }
	}

	public WebElement showMore() {
		WebElement showButton = driver.findElement(showMore);
		// wait.until(ExpectedConditions.visibilityOf(showButton));
		return showButton;
	}

	public WebElement footer() {
		WebElement pageFooter = driver.findElement(footer);
		wait.until(ExpectedConditions.visibilityOf(pageFooter));
		return pageFooter;
	}

	public List<WebElement> thumbList() {
		List<WebElement> optionList = driver.findElements(thumbList);
		wait.until(ExpectedConditions.visibilityOfAllElements(optionList));
		return optionList;
	}

	public List<WebElement> performers() {
		List<WebElement> performerList = driver.findElements(performers);
		wait.until(ExpectedConditions.visibilityOfAllElements(performerList));
		return performerList;
	}

	public void loadAllResults() throws InterruptedException {
		if (isElementVisible()) {
			List<WebElement> performerList = driver.findElements(performers);
			scrollToView();

			while (showMore().isDisplayed() && showMore().isEnabled()) {
				scrollToView();
				if(isShowMoreClickable())
				{
				wait.until(ExpectedConditions.visibilityOfAllElements(performerList));
				scrollToView();
				}

			}
		}
	}
	
	public boolean isShowMoreClickable()
	{
		try {
		showMore().click();
		return true;
		}
		
		catch(ElementNotInteractableException e)
		{
			return false;
		}
	}

	public void scrollToView() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView(true);", showMore());
		js.executeScript("arguments[0].scrollIntoView(true);", footer());
	}

	public boolean isSelectionPresent(String selection) {

		boolean elementPresent = false;

		int noOfExperts = thumbList().size();
		List<WebElement> selectionOccurence = driver.findElements(By.xpath(
				"//article[@data-type='performer']//div[@class='thumb-data-willingness-list']//a[contains(text()," + "'"
						+ selection + "'" + ")]"));
		int noOfSelection = selectionOccurence.size();

		if (noOfExperts == noOfSelection) {
			elementPresent = true;
		}
		return elementPresent;
	}

	public boolean isContentUnique() {

		Set<String> uniqueValues = new HashSet<>();
		boolean uniqueFlag = true;

		for (WebElement performer : performers()) {

			String name = performer.getAttribute("data-displayname");

			if (!uniqueValues.add(name)) {
				uniqueFlag = false;
				return uniqueFlag;
			}
		}
		return uniqueFlag;
	}
}
