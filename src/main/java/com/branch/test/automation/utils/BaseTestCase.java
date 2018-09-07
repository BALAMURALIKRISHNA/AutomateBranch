package com.branch.test.automation.utils;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTestCase {

	public static Logger log = Logger.getLogger("InfoLogging");;
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;

	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "/Users/bkrishnankutty/tools/selenium-server/lib/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		log.info("Opening Browser.");
	}

	protected void log(String message) {
		System.out.println(message);
	}

	@AfterSuite
	public void tearDown() {
		driver.quit();
		log.info("Closing Browser");
	}

}
