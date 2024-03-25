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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentTest childTest;

	@SuppressWarnings("deprecation")
	public void driverInitialization() {
		String browser = prop.getProperty("browserName");
		
		switch (browser) {
		case "chrome":
			if (prop.getProperty("browserMode").equalsIgnoreCase("normal")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--no-sandbox");
				options.addArguments("--incognito");
				driver = new ChromeDriver(options);
			}

			if (prop.getProperty("browserMode").equalsIgnoreCase("headless")) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				driver = new ChromeDriver(options);
			}
			break;
		
		case "Firefox":
		    System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "//externalLibraries//firefoxDriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
		case "IE":
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "//externalLibraries//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			break;
			
		case "Safari":
			driver = new SafariDriver();
			break;
			
		case "Edge":
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "//externalLibraries//msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		}
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("appUrl"));
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageLoadTime")),TimeUnit.SECONDS);
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
