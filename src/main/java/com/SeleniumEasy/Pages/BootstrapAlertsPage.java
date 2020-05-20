package com.SeleniumEasy.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BootstrapAlertsPage {
	
	WebDriver driver;
	
	public BootstrapAlertsPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	By AutocloseableSuccessMessageBtn = By.id("autoclosable-btn-success");
	
	public WebElement getElementAutocloseableSuccessMessageBtn() {
		
		return driver.findElement(AutocloseableSuccessMessageBtn);
	}
	
	By NormalSuccessMessageBtn = By.id("normal-btn-success");
	
	public WebElement getElementNormalSuccessMessageBtn() {
		
		return driver.findElement(NormalSuccessMessageBtn);
	}
	
	By CloseNormalSuccessMessage = By.xpath("//div[@class='alert alert-success alert-normal-success']//button[text()='×']");
	
	public WebElement getElementCloseNormalSuccessMessage() {
		
		return driver.findElement(CloseNormalSuccessMessage);
		
	}
	
	

}
