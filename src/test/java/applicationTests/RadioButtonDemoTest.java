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

import com.SeleniumEasy.Pages.ImageDarknerPopUp;
import com.SeleniumEasy.Pages.LandingPage;
import com.SeleniumEasy.Pages.RadioButtonDemoPage;
import com.SeleniumEasy.common.AccessPropertyFileUtility;
import com.SeleniumEasy.common.SeleniumEasyBaseClass;
import com.SeleniumEasy.common.WaitForPageLoad;

public class RadioButtonDemoTest extends SeleniumEasyBaseClass {

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
	public void RadioButtonVerify() {

		LandingPage landingpage = new LandingPage(driver);
		landingpage.getElementRadioButtonsDemo().click();

		RadioButtonDemoPage radiobuttondemopage = new RadioButtonDemoPage(driver);

		WaitForPageLoad waitforpageload = new WaitForPageLoad(driver);
		waitforpageload.isPageLoaded();

		radiobuttondemopage.getElementMaleRadioBtn().click();
		radiobuttondemopage.getElementGetCheckedValueBtn().click();
		Assert.assertEquals(radiobuttondemopage.getElementMessageText().getText(), "Radio button 'Male' is checked");

	}

	@Test
	public void GroupRadioButtonVerify() {

		LandingPage landingpage = new LandingPage(driver);
		landingpage.getElementRadioButtonsDemo().click();

		RadioButtonDemoPage radiobuttondemopage = new RadioButtonDemoPage(driver);

		WaitForPageLoad waitforpageload = new WaitForPageLoad(driver);
		waitforpageload.isPageLoaded();

		radiobuttondemopage.getElementMaleGroupRadioBtn().click();
		radiobuttondemopage.getElement_15to50RadioBtn().click();
		radiobuttondemopage.getGetValuesBtn().click();
		String[] SexValue = radiobuttondemopage.getValuesOfGroupRadioBtn().getText().split("\n");
		Assert.assertEquals(SexValue[0].split(":")[1].trim(), "Male");

	}

	@AfterMethod
	public void closeTabs() {

		System.out.println("driver quit");
		driver.quit();
	}

}
