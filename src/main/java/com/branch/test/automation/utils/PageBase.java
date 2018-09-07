package com.branch.test.automation.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.log4j.Logger;

public class PageBase {

	protected WebDriver driver;
	protected WebDriverWait wait;
	public static Logger log = null;

	public PageBase(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
	}

	protected void waitForPageTitle(final String title, long sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().contains(title);
			}
		});
	}

	protected void log(String message) { // default is info level
		System.out.println(message);
	}

	protected void pageDown(WebElement e) {
		// Actions builder = new Actions(driver);
		// Action movePageDown = builder.keyDown(e, Keys.ARROW_DOWN).build();
		// movePageDown.perform();

		// Create instance of Javascript executor

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", e);

	}

	protected void pageUP(WebElement e) {

		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", e);

	}

}
