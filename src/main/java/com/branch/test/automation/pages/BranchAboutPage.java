package com.branch.test.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.branch.test.automation.utils.PageBase;

public class BranchAboutPage extends PageBase {

	public final static String TITLE = "About Branch | The Leader in Deep Linking";

	public final static String URL = "https://branch.io/about/";

	@FindBy(css = ".footer-inner ul.bds-accordian")
	private WebElement footer;

	// @FindBy(css=".footer-inner ul.bds-accordian
	// li.bds-accordian-menu:nth-child(1) ul.bds-accordian-list li:nth-child(2)")
	@FindBy(linkText = "Team")
	private WebElement teamLink;

	public BranchAboutPage(WebDriver driver) {
		super(driver);
	}

	public BranchAboutPage(String baseURL, WebDriver driver) {
		super(driver);
		log("URL " + baseURL);
		driver.get(baseURL);
		PageFactory.initElements(driver, this);
	}

	/**
	 * Check page title
	 */
	public boolean checkPageTitle() {
		log("Checking Current URL contains branch: " + driver.getCurrentUrl());
		log("Checking page title to see if it contains: " + TITLE);
		return (driver.getTitle().equalsIgnoreCase(TITLE)) ? true : false;
	}

	/**
	 * Check page title
	 */
	public AllTeam clickOnTeamLink() {
		pageDown(footer);
		teamLink.click();
		return PageFactory.initElements(driver, AllTeam.class);
	}

}
