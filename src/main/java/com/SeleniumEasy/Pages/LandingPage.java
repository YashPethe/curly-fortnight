package com.SeleniumEasy.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	WebDriver driver;

	public LandingPage(WebDriver driver) {

		this.driver = driver;
	}

	By SecondRoundTab = By.cssSelector("span[class='round-tabs two']");
	By SimpleFormDemo = By.xpath("//div[@class='list-group']//a[text()='Simple Form Demo']");
	

	public WebElement getSecondRoundTab() {

		return driver.findElement(SecondRoundTab);
	}
	
	By ThirdRoundTab = By.cssSelector("span[class='round-tabs three']");
	
	public WebElement getElementThirdRoundTab() {
		
		return driver.findElement(ThirdRoundTab);
		
	}

	public WebElement getSimpleFormDemo() {

		return driver.findElement(SimpleFormDemo);
	}
	
	By CheckBoxDemo = By.xpath("//a[text()='Check Box Demo']");
	
	public WebElement getElementCheckBoxDemo() {
		
		return driver.findElement(CheckBoxDemo);
	}
	
	By RadioButtonsDemo = By.xpath("//div[@class='list-group']//a[text()='Radio Buttons Demo']");
	
	public WebElement getElementRadioButtonsDemo() {
		
		return driver.findElement(RadioButtonsDemo);
		
	}
	
	By SelectDropdownList = By.xpath("//div[@class='list-group']//a[text()='Select Dropdown List']");
	
	public WebElement getElementSelectDropdownList() {
		
		return driver.findElement(SelectDropdownList);
		
	}
	
	By JavaScriptAlerts = By.xpath("//div[@class='list-group']//a[text()='Javascript Alerts']");
	
	public WebElement getElementJavaScriptAlerts() {
		
		return driver.findElement(JavaScriptAlerts);
		
		
	}
	
	By BootstrapAlerts = By.xpath("//div[@class='list-group']//a[text()='Bootstrap Alerts']");
	
	public WebElement getElementBootstrapAlerts() {
		
		return driver.findElement(BootstrapAlerts);
		
	}
	
	By ProgressBarModel = By.xpath("//div[@class='list-group']//a[text()='Progress Bar Modal']");
	
	public WebElement getElementProgressBarModel() {
		
		return driver.findElement(ProgressBarModel);
		
	}
	
	By JQuerySelectDropdown = By.xpath("//div[@class='list-group']//a[text()='JQuery Select dropdown']");
	
	public WebElement getElementJQuerySelectDropdown() {
		
		return driver.findElement(JQuerySelectDropdown);
		
	}
	
	
	
	
	
	
	
}
