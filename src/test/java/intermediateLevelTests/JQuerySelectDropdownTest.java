package intermediateLevelTests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SeleniumEasy.Pages.ImageDarknerPopUp;
import com.SeleniumEasy.Pages.LandingPage;
import com.SeleniumEasy.common.AccessPropertyFileUtility;
import com.SeleniumEasy.common.SeleniumEasyBaseClass;
import com.SeleniumEasy.common.WaitForPageLoad;

import intermediateLevelPages.JQuerySelectDropdownPage;

public class JQuerySelectDropdownTest extends SeleniumEasyBaseClass {

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
		landingpage.getElementThirdRoundTab().click();

	}

	@Test
	public void JQuerySelectDropdownVerify() {

		LandingPage landingpage = new LandingPage(driver);
		landingpage.getElementJQuerySelectDropdown().click();

		WaitForPageLoad waitforpageload = new WaitForPageLoad(driver);
		waitforpageload.isPageLoaded();

		JQuerySelectDropdownPage jqueryselectdropdownpage = new JQuerySelectDropdownPage(driver);

		Select selectcountry = new Select(jqueryselectdropdownpage.getElementSelectCountryDropdown());
		selectcountry.selectByVisibleText("India");
		Assert.assertTrue(selectcountry.getFirstSelectedOption().getText().equals("India"));

		Select selectstate = new Select(jqueryselectdropdownpage.getElementSelectStateMultiSelectDropdown());
		selectstate.selectByVisibleText("Florida");
		selectstate.selectByVisibleText("California");

		Select select_territories = new Select(jqueryselectdropdownpage.getElementSelectUS_OultlineTerritories());
		select_territories.selectByIndex(3);

		Select select_a_file = new Select(jqueryselectdropdownpage.getElementSelectA_FileDropdown());
		select_a_file.selectByVisibleText("Unknown Script");

	}

	@AfterMethod
	public void closeTabs() {

		System.out.println("driver quit");
		driver.quit();
	}

}
