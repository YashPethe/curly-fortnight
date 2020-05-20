package com.SeleniumEasy.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SimpleFormDemoPage {

	WebDriver driver;

	public SimpleFormDemoPage(WebDriver driver) {

		this.driver = driver;

	}

	By EnterMessage = By.xpath("//input[@id='user-message']");

	public WebElement getElementEnterMessage() {

		return driver.findElement(EnterMessage);

	}

	By ShowMessage = By.xpath("//button[text()='Show Message']");

	public WebElement getElementShowMessage() {

		return driver.findElement(ShowMessage);

	}

	By YourMessage = By.xpath("//div[@id='user-message']/span");

	public WebElement getElementYourMessage() {

		return driver.findElement(YourMessage);

	}
	
	By EnterA = By.cssSelector("[id='sum1']");
	
	public WebElement getElementEnterA() {
		
		return driver.findElement(EnterA);
	}
	
	By EnterB = By.cssSelector("[id='sum2']");
	
	public WebElement getElementEnterB() {
		
		return driver.findElement(EnterB);
		
	}
	
	By GetTotal = By.xpath("//button[text()='Get Total']");
	
	public WebElement getElementGetTotal() {
		
		return driver.findElement(GetTotal);
	}
	
	By Total = By.cssSelector("[id='displayvalue']");
	
	public WebElement getElementTotal() {
		
		return driver.findElement(Total);
	}
	
	
	
	
	
	
			
			
			
	
	
	
	
	
	
	

}
