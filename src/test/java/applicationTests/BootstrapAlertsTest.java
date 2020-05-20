package applicationTests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SeleniumEasy.Pages.BootstrapAlertsPage;
import com.SeleniumEasy.Pages.ImageDarknerPopUp;
import com.SeleniumEasy.Pages.LandingPage;
import com.SeleniumEasy.common.AccessPropertyFileUtility;
import com.SeleniumEasy.common.SeleniumEasyBaseClass;
import com.SeleniumEasy.common.WaitForPageLoad;

public class BootstrapAlertsTest extends SeleniumEasyBaseClass {
	
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
	public void AutoclosableSuccessMessage() throws InterruptedException {
		
		LandingPage landingpage = new LandingPage(driver);
		landingpage.getElementBootstrapAlerts().click();
		
		WaitForPageLoad waitforpageload = new WaitForPageLoad(driver);
		waitforpageload.isPageLoaded();
		
		BootstrapAlertsPage bootstrapalertspage = new BootstrapAlertsPage(driver);
		
		
		
		bootstrapalertspage.getElementAutocloseableSuccessMessageBtn().click();
		bootstrapalertspage.getElementNormalSuccessMessageBtn().click();
		
		bootstrapalertspage.getElementCloseNormalSuccessMessage().click();
		
	}
	
	@AfterMethod
	public void closeTabs() {

		System.out.println("driver quit");
		driver.quit();
	}
	
	
	

}
