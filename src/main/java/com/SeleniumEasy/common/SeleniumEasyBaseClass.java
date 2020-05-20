package com.SeleniumEasy.common;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumEasyBaseClass {

	public WebDriver driver;
	public Properties prop;

	public WebDriver driverInitializing() throws IOException {

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");

		prop = AccessPropertyFileUtility.getPropertyObject();

		if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();
		}

		else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();

		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public String takeScreenshot(String failedMethod, WebDriver driver) throws IOException {
		
		File Screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println("screenshot");
		String DestinationForScreenshot = System.getProperty("user.dir")+"//res//"+failedMethod+".png";
		FileUtils.copyFile(Screenshot, new File(DestinationForScreenshot));
		System.out.println("copied");
		return DestinationForScreenshot;
		
		
	}

}
