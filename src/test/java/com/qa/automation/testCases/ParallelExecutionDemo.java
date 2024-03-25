package com.qa.automation.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class ParallelExecutionDemo {
	
	public WebDriver driver;
	
	@Test
	public void ParalleTest1() throws InterruptedException {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demoqa.com/");
	driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
	driver.manage().deleteAllCookies();	
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, 300)", "");
	
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//*[contains(text(),'Forms')]")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//div[text()='Please select an item from left to start practice.']")).isDisplayed();
	
	}
	
	@Test
	public void ParalleTest3() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
		driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();	
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 300)", "");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(),'Widgets')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[text()='Please select an item from left to start practice.']")).isDisplayed();
	
	driver.close();
	}
}
