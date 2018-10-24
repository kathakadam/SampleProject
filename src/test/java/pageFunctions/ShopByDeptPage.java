package pageFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import commonFunctions.ExtentTestManager;
import commonFunctions.ExternalWaitLoadPage;
import commonFunctions.HandleDriver;

public class ShopByDeptPage {
	private WebDriver driver;

	public ShopByDeptPage(String browser) {
		driver = HandleDriver.getDriver(browser);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='shopAllLinks']/tbody/tr/td[2]/div[1]/ul[1]/li[2]") // complex xpath selected for browser compatibility																				
	WebElement paperwhitelink;

	// Method to verify if Paperwhite Link is displayed and to click it if displayed
	public PaperwhiteAddCartPage clickKindlePaperwhite(String browser) throws Exception {
		//call method to wait till page is loaded
		ExternalWaitLoadPage.isPageLoaded(browser,paperwhitelink,"Shop By Department");
		Assert.assertEquals(paperwhitelink.isDisplayed(), true);
		paperwhitelink.click();
		ExtentTestManager.getTest(browser).log(LogStatus.PASS, "Kindle Paperwhite link found and clicked");
		return new PaperwhiteAddCartPage(browser);
	}
}
