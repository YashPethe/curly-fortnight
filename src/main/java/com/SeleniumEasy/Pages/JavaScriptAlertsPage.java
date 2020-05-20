package com.SeleniumEasy.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptAlertsPage {

	WebDriver driver;

	public JavaScriptAlertsPage(WebDriver driver) {

		this.driver = driver;

	}

	By First_ClickMeBtn = By.xpath("//button[@class='btn btn-default']");

	public WebElement getElementFirst_ClickMeBtn() {

		return driver.findElement(First_ClickMeBtn);

	}

	By Second_ClickMeBtn = By.xpath("//button[@class='btn btn-default btn-lg' and text()='Click me!']");

	public WebElement getElementSecond_ClickMeBtn() {

		return driver.findElement(Second_ClickMeBtn);

	}

	By ConfirmationMessage = By.id("confirm-demo");

	public WebElement getElementConfirmationMessage() {

		return driver.findElement(ConfirmationMessage);

	}
	
	By ClickForPromptBoxBtn = By.xpath("//button[text()='Click for Prompt Box']");
	
	public WebElement getElementClickForPromptBoxBtn() {
		
		return driver.findElement(ClickForPromptBoxBtn);
		
		
	}
	
	By PromptMessageField = By.id("prompt-demo");
	
	public WebElement getElementPromptMessageField() {
		
		return driver.findElement(PromptMessageField);
		
	}
	

}
