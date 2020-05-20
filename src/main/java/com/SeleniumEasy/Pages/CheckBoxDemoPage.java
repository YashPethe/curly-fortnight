package com.SeleniumEasy.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxDemoPage {
	WebDriver driver;
	
	public CheckBoxDemoPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	By SingleCheckBox = By.xpath("//label[text()='Click on this check box']");
	
	public WebElement getElementSingleCheckBox() {
		
		return driver.findElement(SingleCheckBox);
	}
	
	By TxtAgeMessage = By.cssSelector("[id='txtAge']");
	
	public WebElement getElementTxtAgeMessage() {
		
		return driver.findElement(TxtAgeMessage);
	}
	
	By CheckAllBtn = By.id("check1");
	
	public WebElement getElementCheckAllBtn() {
		
		return driver.findElement(CheckAllBtn);
		
	}
	
	By Option1ChkBox = By.xpath("//label[text()='Option 1']/input");
	
	public WebElement getElementOption1ChkBox() {
		
		return driver.findElement(Option1ChkBox);
		
		
		
	}

}
