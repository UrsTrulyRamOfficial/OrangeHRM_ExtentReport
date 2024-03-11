package com.qa.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.qa.automation.base.TestBase;
import com.qa.automation.util.UtilFunctions;

public class OrangeHrmPIMPage extends TestBase {

	@FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][.='PIM']")
	WebElement pimTab;

	@FindBy(xpath = "//div[@class='orangehrm-header-container']/button[@type='button']")
	WebElement addBtn;

	@FindBy(xpath = "//input[@type='file']")
	WebElement uploadFile;

	@FindBy(xpath = "//input[@name='firstName']")
	WebElement empFirstName;

	@FindBy(xpath = "//input[@name='middleName']")
	WebElement empMiddleName;

	@FindBy(xpath = "//input[@name='lastName']")
	WebElement empLastName;

	@FindBy(xpath = "//label[text()='Employee Id']/../../div[2]/input")
	WebElement employeeId;

	@FindBy(xpath = "//div[@class='oxd-switch-wrapper']//span")
	WebElement enableCreateLoginDetails;

	@FindBy(xpath = "//label[text()='Username']/../../div[2]/input")
	WebElement userName;

	@FindBy(xpath = "//label[text()='Password']/../../div[2]/input[@type='password']")
	WebElement password;

	@FindBy(xpath = "//label[text()='Confirm Password']/../../div[2]/input[@type='password']")
	WebElement confirmPassword;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement saveBtn;
	
	@FindBy(xpath = "//div[@class='orangehrm-edit-employee-imagesection']/div/h6")
	WebElement employeeImageSection;

	// Constructor
	public OrangeHrmPIMPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void PIMFunctionality() throws Exception {
		UtilFunctions.wait(10);
		pimTab.click();
		test.log(Status.INFO, "Clicked PIM Tab Successfully");

		addBtn.click();
		test.log(Status.INFO, "Clicked +Add button Successfully");

		String filePath = System.getProperty("user.dir") + "/resources/sampleProfile.avif";
		UtilFunctions.wait(2);
		uploadFile.sendKeys(filePath);
		test.log(Status.INFO, "Employee Profile photo uploaded Successfully");

		empFirstName.sendKeys(prop.getProperty(""));
		test.log(Status.INFO, "Employee First name entered as: " + prop.getProperty(""));

		empMiddleName.sendKeys(prop.getProperty(""));
		test.log(Status.INFO, "Employee First name entered as: " + prop.getProperty(""));

		empLastName.sendKeys(prop.getProperty(""));
		test.log(Status.INFO, "Employee First name entered as: " + prop.getProperty(""));

		employeeId.sendKeys("0005");
		test.log(Status.INFO, "Employee Id entered as: " + prop.getProperty(""));

		enableCreateLoginDetails.click();
		test.log(Status.INFO, "Create login details button enabled Successfully");

		userName.sendKeys(UtilFunctions.generateRandomString());
		test.log(Status.INFO, "Employee User name entered as: " + UtilFunctions.generateRandomString());

		password.sendKeys(prop.getProperty(""));
		test.log(Status.INFO, "Employee password entered as: " + prop.getProperty(""));

		confirmPassword.sendKeys(prop.getProperty(""));
		test.log(Status.INFO, "Employee confirmed password entered as: " + prop.getProperty(""));

		saveBtn.click();
		test.log(Status.INFO, "Clicked save button successfully");
	}
}
