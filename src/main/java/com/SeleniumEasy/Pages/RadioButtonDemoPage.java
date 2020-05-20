package com.SeleniumEasy.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonDemoPage {
	
	WebDriver driver;
	
	public RadioButtonDemoPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	By MaleRadioBtn = By.xpath("//div//div[text()='Radio Button Demo']/parent::div//label[text()='Male']");
	
	public WebElement getElementMaleRadioBtn() {
		
		return driver.findElement(MaleRadioBtn);
		
	}
	
	By GetCheckedValueBtn = By.cssSelector("[id='buttoncheck']");
	
	public WebElement getElementGetCheckedValueBtn() {
		
		return driver.findElement(GetCheckedValueBtn);
		
	}
	
	By MessageText = By.cssSelector("[class='radiobutton']");
	
	public WebElement getElementMessageText() {
		
		return driver.findElement(MessageText);
		
	}
	
	By MaleGroupRadioBtn = By.xpath("//div//div[text()='Group Radio Buttons Demo']/parent::div//label[text()='Male']//input");
	
	public WebElement getElementMaleGroupRadioBtn() {
		
		return driver.findElement(MaleGroupRadioBtn);
		
		
	}
	
	By _15to50RadioBtn = By.xpath("//div//div[text()='Group Radio Buttons Demo']/parent::div//label[text()='15 to 50']//input");
	
	public WebElement getElement_15to50RadioBtn() {
		
		
		return driver.findElement(_15to50RadioBtn);
	}
	
	By GetValuesBtn = By.xpath("//button[text()='Get values']");
	
	public WebElement getGetValuesBtn() {
		
		
		return driver.findElement(GetValuesBtn);
	}
	
	By ValuesOfGroupRadioBtn = By.cssSelector("[class='groupradiobutton']");
	
	public WebElement getValuesOfGroupRadioBtn() {
		
		return driver.findElement(ValuesOfGroupRadioBtn);
		
	}

}
