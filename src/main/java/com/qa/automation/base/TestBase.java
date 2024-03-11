/**
 * @author RameshReddy.K
 * @gitHub https://github.com/UrsTrulyRamOfficial
 *
 **/

package com.qa.automation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentTest childTest;

	@SuppressWarnings("deprecation")
	public void driverInitialization() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		//driver = new ChromeDriver();
		driver = new ChromeDriver(options);
		driver.get(prop.getProperty("appUrl"));
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageLoadTime")), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

	public void readPropertyFile() {
		try {
			FileInputStream propFile = new FileInputStream(System.getProperty("user.dir") + "\\config\\config.properties");
			prop = new Properties();
			prop.load(propFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setExtentReport() {

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/extentReports/OrangeHRMExtentReport.html");
		htmlReporter.config().setDocumentTitle("Orange HRM Automation Report");
		htmlReporter.config().setReportName("Regression Testing");
		htmlReporter.config().setTheme(Theme.DARK); // STANDARD

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("Host Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("User", "Ramesh Reddy K");
	}
}
