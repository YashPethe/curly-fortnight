package com.SeleniumEasy.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SelectDropdownListPage {

	WebDriver driver;

	public SelectDropdownListPage(WebDriver driver) {

		this.driver = driver;

	}

	By SelectDay = By.xpath("//select[@id='select-demo']");

	public WebElement getElementSelectDay() {

		return driver.findElement(SelectDay);

	}

	By DaySelectedField = By.cssSelector("[class='selected-value']");

	public WebElement getElementDaySelectedField() {

		return driver.findElement(DaySelectedField);

	}

	By MultiSelectList = By.xpath("//select[@id='multi-select']");

	public WebElement getElementMultiSelectList() {

		return driver.findElement(MultiSelectList);

	}

	By FirstSelectedBtn = By.xpath("//button[@value='Print First']");

	public WebElement getElementFirstSelectedBtn() {

		return driver.findElement(FirstSelectedBtn);

	}

	By GetAllSelectedBtn = By.xpath("//button[@value='Print All']");

	public WebElement getElementGetAllSelectedBtn() {

		return driver.findElement(GetAllSelectedBtn);

	}
	
	By ResultFieldForSelection = By.cssSelector("[class='getall-selected']");
	
	public WebElement getElementResultFieldForSelection() {
		
		return driver.findElement(ResultFieldForSelection);
		
	}
	
	By SelectOhio = By.cssSelector("[value='Ohio']");
	
	public By getElementSelectOhio() {
		
		return SelectOhio;
		
		
	}

}
