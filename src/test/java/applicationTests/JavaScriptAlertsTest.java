package applicationTests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SeleniumEasy.Pages.ImageDarknerPopUp;
import com.SeleniumEasy.Pages.JavaScriptAlertsPage;
import com.SeleniumEasy.Pages.LandingPage;
import com.SeleniumEasy.common.AccessPropertyFileUtility;
import com.SeleniumEasy.common.SeleniumEasyBaseClass;
import com.SeleniumEasy.common.WaitForPageLoad;

public class JavaScriptAlertsTest extends SeleniumEasyBaseClass {
	
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
	public void JavaScriptAlertBoxVerify() {
		
		
		LandingPage landingpage = new LandingPage(driver);
		landingpage.getElementJavaScriptAlerts().click();
		
		WaitForPageLoad waitforpageload = new WaitForPageLoad(driver);
		waitforpageload.isPageLoaded();
		
		JavaScriptAlertsPage javascriptalertspage = new JavaScriptAlertsPage(driver);
		
		javascriptalertspage.getElementFirst_ClickMeBtn().click();
		
		driver.switchTo().alert().accept();
		
		javascriptalertspage.getElementSecond_ClickMeBtn().click();
		driver.switchTo().alert().accept();
		Assert.assertTrue(javascriptalertspage.getElementConfirmationMessage().getText().contains("OK"));
		
		
		javascriptalertspage.getElementClickForPromptBoxBtn().click();
		driver.switchTo().alert().sendKeys("Yash");
		driver.switchTo().alert().accept();
		Assert.assertTrue(javascriptalertspage.getElementPromptMessageField().getText().contains("Yash"));
		
	}
	
	@AfterMethod
	public void closeTabs() {

		System.out.println("driver quit");
		driver.quit();
	}
	
	

}
