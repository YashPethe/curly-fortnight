package intermediateLevelTests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.SeleniumEasy.Pages.ImageDarknerPopUp;
import com.SeleniumEasy.Pages.LandingPage;
import com.SeleniumEasy.common.AccessPropertyFileUtility;
import com.SeleniumEasy.common.SeleniumEasyBaseClass;
import com.SeleniumEasy.common.WaitForPageLoad;

import intermediateLevelPages.ProgressBarModelPage;

public class ProgressBarModelTest extends SeleniumEasyBaseClass {

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
	public void ModelDialogProgressBar() {

		LandingPage landingpage = new LandingPage(driver);
		landingpage.getElementProgressBarModel().click();

		WaitForPageLoad waitforpageload = new WaitForPageLoad(driver);
		waitforpageload.isPageLoaded();

		ProgressBarModelPage progressbarmodelpage = new ProgressBarModelPage(driver);

		progressbarmodelpage.getElementShowDialog_simpleBtn().click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOf(progressbarmodelpage.getElementSimpleDialogBlock()));

		progressbarmodelpage.getElementShowDialog_customMessageBtn().click();
		wait.until(ExpectedConditions.invisibilityOf(progressbarmodelpage.getElementCustomMessageDialogBlock()));

		progressbarmodelpage.getElementShowDialog_customSettingBtn().click();
		wait.until(ExpectedConditions.invisibilityOf(progressbarmodelpage.getElementCustomSettingDialogBlock()));

	}

	@AfterMethod
	public void closeTabs() {

		System.out.println("driver quit");
		driver.quit();
	}

}
