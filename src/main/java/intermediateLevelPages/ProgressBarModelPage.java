package intermediateLevelPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProgressBarModelPage {

	WebDriver driver;

	public ProgressBarModelPage(WebDriver driver) {

		this.driver = driver;

	}

	By ShowDialog_simpleBtn = By.cssSelector("[class='btn btn-primary']");

	public WebElement getElementShowDialog_simpleBtn() {

		return driver.findElement(ShowDialog_simpleBtn);

	}

	By SimpleDialogBlock = By.cssSelector("[class='modal fade']");

	public WebElement getElementSimpleDialogBlock() {

		return driver.findElement(SimpleDialogBlock);

	}

	By ShowDialog_customMessageBtn = By.cssSelector("[class='btn btn-success']");

	public WebElement getElementShowDialog_customMessageBtn() {

		return driver.findElement(ShowDialog_customMessageBtn);

	}

	By CustomMessageDialogBlock = By.cssSelector("[class='modal-header']");

	public WebElement getElementCustomMessageDialogBlock() {

		return driver.findElement(CustomMessageDialogBlock);

	}

	By ShowDialog_customSettingBtn = By.cssSelector("[class='btn btn-warning']");

	public WebElement getElementShowDialog_customSettingBtn() {

		return driver.findElement(ShowDialog_customSettingBtn);

	}

	By CustomSettingDialogBlock = By.cssSelector("[class='modal-body']");

	public WebElement getElementCustomSettingDialogBlock() {

		return driver.findElement(CustomSettingDialogBlock);

	}

}
