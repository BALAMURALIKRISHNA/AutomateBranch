package com.branch.test.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.branch.test.automation.pages.AllTeam;

import com.branch.test.automation.utils.PageBase;

public class GoogleSearchPage extends PageBase {

	public final static String TITLE = "Google";

	public final static String URL = "http://www.google.com";

	public GoogleSearchPage(WebDriver driver) {
		super(driver);
	}

	public GoogleSearchPage(String baseURL, WebDriver driver) {
		super(driver);
		log("URL " + baseURL);
		driver.get(baseURL);
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[name='q']")
	private WebElement search_textfield;

	@FindBy(name = "btnK")
	private WebElement search_button;

	@FindBy(xpath = "//a[contains(text(),'image024')]")
	private WebElement download_link;

	public void search(String text) {
		log("Search for: " + text);
		search_textfield.sendKeys(text);
		search_button.submit();
	}


	public boolean checkPageTitle() {
		log("Checking page title to see if it contains: " + TITLE);
		return (driver.getTitle().equalsIgnoreCase(TITLE)) ? true : false;
	}

	public BranchAboutPage clickOnAboutBranch() {
		log("Checking Current URL contains branch: " + driver.getCurrentUrl());
		WebElement aboutBranch_Link = driver.findElement(By.linkText("About Branch"));
		aboutBranch_Link.click();
		return PageFactory.initElements(driver, BranchAboutPage.class);
	}

}
