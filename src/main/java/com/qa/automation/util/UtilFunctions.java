/**
 * @author RameshReddy.K
 * @gitHub https://github.com/UrsTrulyRamOfficial
 *
 **/

package com.qa.automation.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.automation.base.TestBase;


public class UtilFunctions extends TestBase {
	
	public static String getScreenshot(String imageName) {
		  
		String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir") + "/Screenshots/" + imageName + currentDate + ".png";
		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (IOException e) {
			System.out.println("Failed to capture the screen "+ e.getMessage());
		}
		
		return destination;
	}
	
	public static void wait(int timeout) throws Exception {
		long milliSeconds = timeout * 1000;
		Thread.sleep(milliSeconds);
	}
	
	public static String generateRandomString() {
		String randomName = RandomStringUtils.randomAlphabetic(15).toString();
		return randomName;
	}
}
