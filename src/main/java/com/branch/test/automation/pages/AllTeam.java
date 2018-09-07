package com.branch.test.automation.pages;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.branch.test.automation.utils.PageBase;

public class AllTeam extends PageBase {

	public final static String TITLE = "Team | Branch";

	public final static String ALL_URL = "https://branch.io/team/#all";
	public final static String DATA_URL = "https://branch.io/team/#data";
	public final static String ENGINEERING_URL = "https://branch.io/team/#engineering";
	public final static String MARKETING_URL = "https://branch.io/team/#marketing";
	public final static String OPERATIONS_URL = "https://branch.io/team/#operations";
	public final static String PARTNERGROWTH_URL = "https://branch.io/team/#partner-growth";
	public final static String PRODUCT_URL = "https://branch.io/team/#product";
	public final static String RECRUITING_URL = "https://branch.io/team/#recruiting";

	@FindBy(css = ".footer-inner ul.bds-accordian")
	private WebElement footer;

	@FindBy(css = "section.header")
	private WebElement header;

	@FindBy(css = "div.wrap")
	private List<WebElement> allTeamMembers;

	@FindBy(css = "a[href='#data']")
	private WebElement dataLink;

	@FindBy(xpath = "//div[contains(@class, 'category-data')]/div[2]/div/div[2]/h2")
	private List<WebElement> dataTeamMembers;

	@FindBy(css = "a[href='#engineering']")
	private WebElement engineeringLink;

	@FindBy(xpath = "//div[contains(@class, 'category-engineering')]/div[2]/div/div[2]/h2")
	private List<WebElement> engineeringTeamMembers;

	@FindBy(css = "a[href='#marketing']")
	private WebElement marketingLink;

	@FindBy(xpath = "//div[contains(@class, 'category-marketing')]/div[2]/div/div[2]/h2")
	private List<WebElement> marketingTeamMembers;

	@FindBy(css = "a[href='#operations']")
	private WebElement operationsLink;

	@FindBy(xpath = "//div[contains(@class, 'category-operations')]/div[2]/div/div[2]/h2")
	private List<WebElement> operationsTeamMembers;

	@FindBy(css = "a[href='#partner-growth']")
	private WebElement partnergrowthLink;

	@FindBy(xpath = "//div[contains(@class, 'category-partner-growth')]/div[2]/div/div[2]/h2")
	private List<WebElement> partnergrowthTeamMembers;

	@FindBy(css = "a[href='#product']")
	private WebElement productLink;

	@FindBy(xpath = "//div[contains(@class, 'category-product')]/div[2]/div/div[2]/h2")
	private List<WebElement> productTeamMembers;

	@FindBy(css = "a[href='#recruiting']")
	private WebElement recruitingLink;

	@FindBy(xpath = "//div[contains(@class, 'category-recruiting')]/div[2]/div/div[2]/h2")
	private List<WebElement> recruitingTeamMembers;

	public AllTeam(WebDriver driver) {
		super(driver);
	}

	public AllTeam(String baseURL, WebDriver driver) {
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return (driver.getTitle().equalsIgnoreCase(TITLE)) ? true : false;
	}

	public int totalNumberOfEmployees() {
		return allTeamMembers.size();
	}

	public ArrayList<String> engineerEmployees(String selectedDepartment) {
		pageDown(footer);
		ArrayList<String> al = new ArrayList<String>();
		for (int i = 0; i < allTeamMembers.size(); i++) {
			String dep = allTeamMembers.get(i).findElement(By.cssSelector(".hovereffect div.info-block h4")).getText();
			if (dep.equals(selectedDepartment) || getCxoAddedToList(selectedDepartment, dep)) {
				String engName = allTeamMembers.get(i).findElement(By.cssSelector(".hovereffect div.info-block h2"))
						.getText();
				al.add(engName);
			}
		}
		Collections.sort(al);
		pageUP(header);
		return al;

	}

	public boolean getCxoAddedToList(String selectedDepartment, String dep) {

		boolean flag = false;

		if (((selectedDepartment == "Engineering") && (dep.equals("Co-Founder / CEO")))
				|| ((selectedDepartment == "Engineering") && (dep.equals("Co-Founder / Engineering")))) {
			flag = true;
		} else if ((selectedDepartment == "Marketing") && (dep.equals("Co-Founder / Marketing"))) {
			flag = true;
		} else if ((selectedDepartment == "Partner Growth") && (dep.equals("Co-Founder / COO"))) {
			flag = true;
		}

		return flag;
	}

	public ArrayList<String> getDataTeamMembers() {
		log("==================>Validation for DataTeamMembers");
		pageUP(header);
		dataLink.click();
		assertTrue(driver.getCurrentUrl().equals(DATA_URL));
		pageDown(footer);
		ArrayList<String> al = getTeamMembers(dataTeamMembers);
		return al;

	}

	public ArrayList<String> getEngineeringTeamMembers() {
		log("==================>Validation for EngineeringTeamMembers");
		pageUP(header);
		engineeringLink.click();
		assertTrue(driver.getCurrentUrl().equals(ENGINEERING_URL));
		pageDown(footer);
		ArrayList<String> al = getTeamMembers(engineeringTeamMembers);
		return al;

	}

	public ArrayList<String> getMarketingTeamMembers() {
		log("==================>Validation for MarketingTeamMembers");
		pageUP(header);
		marketingLink.click();
		assertTrue(driver.getCurrentUrl().equals(MARKETING_URL));
		pageDown(footer);
		ArrayList<String> al = getTeamMembers(marketingTeamMembers);
		return al;

	}

	public ArrayList<String> getOperationsTeamMembers() {
		log("==================>Validation for OperationsTeamMembers");
		pageUP(header);
		operationsLink.click();
		assertTrue(driver.getCurrentUrl().equals(OPERATIONS_URL));
		pageDown(footer);
		ArrayList<String> al = getTeamMembers(operationsTeamMembers);
		return al;

	}

	public ArrayList<String> getPartnerGrowthTeamMembers() {
		log("==================>Validation for PartnerGrowthTeamMembers");
		pageUP(header);
		partnergrowthLink.click();
		assertTrue(driver.getCurrentUrl().equals(PARTNERGROWTH_URL));
		pageDown(footer);
		ArrayList<String> al = getTeamMembers(partnergrowthTeamMembers);
		return al;

	}

	public ArrayList<String> getProductTeamMembers() {
		log("==================>Validation for ProductTeamMembers");
		pageUP(header);
		productLink.click();
		assertTrue(driver.getCurrentUrl().equals(PRODUCT_URL));
		pageDown(footer);
		ArrayList<String> al = getTeamMembers(productTeamMembers);
		return al;

	}

	public ArrayList<String> getRecruitingTeamMembers() {
		log("==================>Validation for RecruitingTeamMembers");
		pageUP(header);
		recruitingLink.click();
		assertTrue(driver.getCurrentUrl().equals(RECRUITING_URL));
		pageDown(footer);
		ArrayList<String> al = getTeamMembers(recruitingTeamMembers);
		return al;

	}

	public ArrayList<String> getTeamMembers(List<WebElement> selectedDepartment) {
		ArrayList<String> al = new ArrayList<String>();
		for (int i = 0; i < selectedDepartment.size(); i++) {
			String empName = selectedDepartment.get(i).getText();
			al.add(empName);
		}
		Collections.sort(al);
		return al;

	}

}
