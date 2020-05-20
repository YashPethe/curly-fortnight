package com.SeleniumEasy.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ImageDarknerPopUp {
	 WebDriver driver;

	public ImageDarknerPopUp(WebDriver driver) {

		this.driver = driver;

	}

	 By ImageDarkner = By.xpath("//a[text()='No, thanks!']");

	public  WebElement getImageDarkner() {

		return driver.findElement(ImageDarkner);
	}

}
