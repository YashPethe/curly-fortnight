package applicationTests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SeleniumEasy.Pages.ImageDarknerPopUp;
import com.SeleniumEasy.Pages.LandingPage;
import com.SeleniumEasy.Pages.SelectDropdownListPage;
import com.SeleniumEasy.common.AccessPropertyFileUtility;
import com.SeleniumEasy.common.SeleniumEasyBaseClass;
import com.SeleniumEasy.common.WaitForPageLoad;

public class SelectDropdownListTest extends SeleniumEasyBaseClass {

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
	public void SelectListDemoVerify() {

		LandingPage landingpage = new LandingPage(driver);
		landingpage.getElementSelectDropdownList().click();

		WaitForPageLoad waitforpageload = new WaitForPageLoad(driver);
		waitforpageload.isPageLoaded();

		SelectDropdownListPage selectdropdownlistpage = new SelectDropdownListPage(driver);

		// selectdropdownlistpage.getElementSelectDay();

		Select select = new Select(selectdropdownlistpage.getElementSelectDay());
		select.selectByVisibleText("Monday");

		Assert.assertEquals(selectdropdownlistpage.getElementDaySelectedField().getText(), "Day selected :- Monday");

	}

	@Test
	public void MultipleSelectListDemo() throws InterruptedException {

		LandingPage landingpage = new LandingPage(driver);
		landingpage.getElementSelectDropdownList().click();

		WaitForPageLoad waitforpageload = new WaitForPageLoad(driver);
		waitforpageload.isPageLoaded();

		SelectDropdownListPage selectdropdownlistpage = new SelectDropdownListPage(driver);

		Select select = new Select(selectdropdownlistpage.getElementMultiSelectList());

		System.out.println(select.isMultiple());

		select.selectByIndex(0);

		selectdropdownlistpage.getElementFirstSelectedBtn().click();

		Assert.assertEquals(selectdropdownlistpage.getElementResultFieldForSelection().getText(),
				"First selected option is : California");

//		selectdropdownlistpage.getElementGetAllSelectedBtn().click();
//		
//		Assert.assertEquals(selectdropdownlistpage.getElementResultFieldForSelection().getText(), "Options selected are : California,New York,Washington");
//		
	}

	@AfterMethod
	public void closeTabs() {

		System.out.println("driver quit");
		driver.quit();
	}

}
