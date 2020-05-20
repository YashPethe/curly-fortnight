package applicationTests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.SeleniumEasy.Pages.ImageDarknerPopUp;
import com.SeleniumEasy.Pages.LandingPage;
import com.SeleniumEasy.Pages.SimpleFormDemoPage;
import com.SeleniumEasy.common.AccessPropertyFileUtility;
import com.SeleniumEasy.common.SeleniumEasyBaseClass;
import com.SeleniumEasy.common.WaitForPageLoad;

public class SimpleFormDemoTest extends SeleniumEasyBaseClass {

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
	public void singleInputVerify() {
		LandingPage landingpage = new LandingPage(driver);
		landingpage.getSimpleFormDemo().click();

		SimpleFormDemoPage simpleformdemopage = new SimpleFormDemoPage(driver);
		simpleformdemopage.getElementEnterMessage().sendKeys("users message");
		simpleformdemopage.getElementShowMessage().click();
		driver.findElement(By.xpath("//a[text()='No, thanks!']")).sendKeys(Keys.ESCAPE);
		Assert.assertEquals(simpleformdemopage.getElementYourMessage().getText(), "users message");

	}

	@Test
	public void twoInputFieldsVerify() {
		LandingPage landingpage = new LandingPage(driver);
		landingpage.getSimpleFormDemo().click();

		SimpleFormDemoPage simpleformdemopage = new SimpleFormDemoPage(driver);
		simpleformdemopage.getElementEnterA().sendKeys("14");
		simpleformdemopage.getElementEnterB().sendKeys("15");
		simpleformdemopage.getElementGetTotal().click();
		driver.findElement(By.xpath("//a[text()='No, thanks!']")).sendKeys(Keys.ESCAPE);
		Assert.assertEquals(simpleformdemopage.getElementTotal().getText(), "29");
		System.out.println("after assert");

	}

	@AfterMethod
	public void closeTabs() {

		System.out.println("driver quit");
		driver.quit();
	}

}
