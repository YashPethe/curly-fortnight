package intermediateLevelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JQuerySelectDropdownPage {
	
	WebDriver driver;
	
	public JQuerySelectDropdownPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	By SelectCountryDropdown = By.id("country");
	
	public WebElement getElementSelectCountryDropdown() {
		
		return driver.findElement(SelectCountryDropdown);
		
	}
	
	By SelectStateMultiSelectDropdown = By.cssSelector("[class='js-example-basic-multiple select2-hidden-accessible']");
	
	public WebElement getElementSelectStateMultiSelectDropdown() {
		
		return driver.findElement(SelectStateMultiSelectDropdown);
		
	}
	
	By SelectUS_OultlineTerritories = By.cssSelector("[class='js-example-disabled-results select2-hidden-accessible']");
	
	public WebElement getElementSelectUS_OultlineTerritories() {
		
		return driver.findElement(SelectUS_OultlineTerritories);
		
	}
	
	By SelectA_FileDropdown = By.cssSelector("[class='form-control']");
	
	public WebElement getElementSelectA_FileDropdown() {
		
		return driver.findElement(SelectA_FileDropdown);
		
	}

}
