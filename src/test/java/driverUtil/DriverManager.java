package driverUtil;

import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverManager {

	private static final Logger logger = LoggerFactory.getLogger(DriverManager.class);

	public static WebDriver driver;

	public static WebDriver createDriver() {

		System.setProperty("webdriver.chrome.driver",
				Paths.get(System.getProperty("user.dir"), "/src/test/resources/drivers/chromedriver.exe").toString());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
		return driver;
	}
	
	
	
	public static void tearDown() {
        
        if(driver!=null) {
            driver.close();
            driver.quit();
        }
    }

	/*
	 * public ChromeOptions getCapabilities() { ChromeOptions options = new
	 * ChromeOptions(); options.addArguments("--window-size=1580,1280");
	 * 
	 * return options;
	 * 
	 * }
	 */
}
