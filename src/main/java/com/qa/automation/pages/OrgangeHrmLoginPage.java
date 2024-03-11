package com.qa.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.qa.automation.base.TestBase;
import com.qa.automation.util.UtilFunctions;

public class OrgangeHrmLoginPage extends TestBase {

	@FindBy(xpath = "//div[@class='orangehrm-login-slot-wrapper']//div[1]/div//input[@name='username']")
	WebElement orangeHRMUserName;

	@FindBy(xpath = "//div//input[@name='password']")
	WebElement orangeHRMPassword;

	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement loginBtn;

	// Constructor
	public OrgangeHrmLoginPage() {
		super();
		PageFactory.initElements(driver, this);
	}

	// Actions
	public void loginFunctionality() throws Exception {
		UtilFunctions.wait(1);
		orangeHRMUserName.sendKeys(prop.getProperty("userName"));
		test.log(Status.INFO, "Entered user name is: " + prop.getProperty("userName"));

		UtilFunctions.wait(1);
		orangeHRMPassword.sendKeys(prop.getProperty("password"));
		test.log(Status.INFO, "Entered password is: " + prop.getProperty("password"));

		UtilFunctions.wait(1);
		loginBtn.click();
		test.log(Status.INFO, "Clicked Login Button successfully");
	}

	public void verifyLoginPageTitle() throws Exception {
		UtilFunctions.wait(5);
		String ExpectedTitle = "OrangeHRM";
		test.log(Status.INFO, "Expected page title is: " + ExpectedTitle);

		String ActualTitle = driver.getTitle();
		test.log(Status.INFO, "Actual page title is: " + ActualTitle);

		Assert.assertEquals(ExpectedTitle, ActualTitle);
	}
}
