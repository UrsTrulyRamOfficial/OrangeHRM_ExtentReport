package com.qa.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.qa.automation.base.TestBase;
import com.qa.automation.util.UtilFunctions;

public class OrangeHrmAdminPage extends TestBase {

	@FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][.='Admin']")
	WebElement adminTab;

	@FindBy(xpath = "//div[@class='orangehrm-header-container']/button[@type='button']")
	WebElement addBtn;

	@FindBy(xpath = "//div/div[1]/div/div[2]/div[@class='oxd-select-wrapper']/div//i")
	WebElement userRoleDrop;

	public static By selectUserRoleDrop(String userRole) {
		return By.xpath("//*[contains(text(),'" + userRole + "')]");
	}

	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	WebElement loginProfileName;

	@FindBy(xpath = "//input[@placeholder='Type for hints...']")
	WebElement employeeNameTxtBox;

	@FindBy(xpath = "//label[text()='Status']/../..//div[@class='oxd-select-text-input']")
	WebElement statusDrop;

	public static By selectStsatusDrop(String status) {
		return By.xpath("//*[contains(text(),'" + status + "')]");
	}

	@FindBy(xpath = "//label[text()='Username']/../../div//input[@class='oxd-input oxd-input--active']")
	WebElement userName;

	@FindBy(xpath = "(//label[contains(text(),'Password')])[1]/../..//input[@class='oxd-input oxd-input--active']")
	WebElement password;

	@FindBy(xpath = "//label[contains(text(),'Confirm Password')]/../..//input[@class='oxd-input oxd-input--active']")
	WebElement confirmPassword;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveBtn;

	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	WebElement userLogName;

	@FindBy(xpath = "//h5[.='System Users']")
	WebElement systemUsersTitle;
	
	// Constructor
	public OrangeHrmAdminPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void adminFunctionality() throws Exception {
		UtilFunctions.wait(10);
		adminTab.click();
		test.log(Status.INFO, "Clicked Admin Tab Successfully");

		addBtn.click();
		test.log(Status.INFO, "Clicked +Add button Successfully");

		userRoleDrop.click();
		test.log(Status.INFO, "Clicked User Role Successfully");

		selectUserRoleDrop(prop.getProperty("userRoleDrop"));
		test.log(Status.INFO, "Selected User Role drop down with: " + prop.getProperty("userRoleDrop"));

		String logUserName = loginProfileName.getText();
		employeeNameTxtBox.sendKeys(logUserName);
		employeeNameTxtBox.sendKeys(Keys.DOWN, Keys.ENTER);
		test.log(Status.INFO, "Entered employee name with: " + logUserName);

		statusDrop.click();
		test.log(Status.INFO, "Clicked status drop down successfully");

		selectStsatusDrop(prop.getProperty("statusDrop"));
		test.log(Status.INFO, "Selected Status drop down with: " + prop.getProperty("statusDrop"));

		userName.sendKeys(UtilFunctions.generateRandomString());
		test.log(Status.INFO, "Entered user name with: " + UtilFunctions.generateRandomString());

		password.sendKeys("password@123");
		test.log(Status.INFO, "Entered password as: password@123");

		confirmPassword.sendKeys("password@123");
		test.log(Status.INFO, "Entered confirm password as: password@123");

		saveBtn.click();
		test.log(Status.INFO, "Clicked save button successfully");
	}
}
