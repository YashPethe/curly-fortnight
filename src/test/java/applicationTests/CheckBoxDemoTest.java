package applicationTests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SeleniumEasy.Pages.CheckBoxDemoPage;
import com.SeleniumEasy.Pages.ImageDarknerPopUp;
import com.SeleniumEasy.Pages.LandingPage;
import com.SeleniumEasy.common.AccessPropertyFileUtility;
import com.SeleniumEasy.common.SeleniumEasyBaseClass;
import com.SeleniumEasy.common.WaitForPageLoad;

public class CheckBoxDemoTest extends SeleniumEasyBaseClass {

	WebDriver driver;
	Properties prop;

	@BeforeMethod
	public void underSecondTab() throws IOException, InterruptedException {

		prop = AccessPropertyFileUtility.getPropertyObject();

		driver = driverInitializing();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();

		// Thread.sleep(10000);
		WaitForPageLoad waitforpageload = new WaitForPageLoad(driver);
		waitforpageload.isPageLoaded();

		ImageDarknerPopUp popup = new ImageDarknerPopUp(driver);

		if (popup.getImageDarkner().isDisplayed() && popup.getImageDarkner().isEnabled()) {

			popup.getImageDarkner().sendKeys(Keys.ESCAPE);
		}
		LandingPage landingpage = new LandingPage(driver);
		landingpage.getSecondRoundTab().click();

	}

	@Test
	public void singleCheckBoxVerify() throws InterruptedException {

		LandingPage landingpage = new LandingPage(driver);
		landingpage.getElementCheckBoxDemo().click();

		CheckBoxDemoPage checkboxdemopage = new CheckBoxDemoPage(driver);

		Assert.assertEquals(checkboxdemopage.getElementTxtAgeMessage().getText(), "");

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(checkboxdemopage.getElementSingleCheckBox())).click();

		System.out.println("After first assert");

		Assert.assertEquals(checkboxdemopage.getElementTxtAgeMessage().getText(), "Success - Check box is checked");

		System.out.println("after second assert");

	}

	@Test
	public void multipleCheckBoxVerify() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		LandingPage landingpage = new LandingPage(driver);
		landingpage.getElementCheckBoxDemo().click();

		CheckBoxDemoPage checkboxdemopage = new CheckBoxDemoPage(driver);

		wait.until(ExpectedConditions.visibilityOf(checkboxdemopage.getElementOption1ChkBox()));

		Assert.assertEquals(checkboxdemopage.getElementCheckAllBtn().getAttribute("value"), "Check All");

		wait.until(ExpectedConditions.visibilityOf(checkboxdemopage.getElementCheckAllBtn()));
		wait.until(ExpectedConditions.elementToBeClickable(checkboxdemopage.getElementCheckAllBtn()));
		wait.until(ExpectedConditions.elementToBeClickable(checkboxdemopage.getElementCheckAllBtn())).click();

		System.out.println(checkboxdemopage.getElementOption1ChkBox().isSelected());

		Assert.assertEquals(checkboxdemopage.getElementCheckAllBtn().getAttribute("value"), "Uncheck All");

	}

	@AfterMethod
	public void closeTabs() {

		System.out.println("driver quit");
		driver.quit();
	}

}
