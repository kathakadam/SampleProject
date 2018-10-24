package pageFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import commonFunctions.HandleDriver;
import commonFunctions.ExtentTestManager;
import commonFunctions.ExternalWaitLoadPage;

public class AmazonHomePage {
	private WebDriver driver;

	public AmazonHomePage(String browser) {
		driver = HandleDriver.getDriver(browser);
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "nav-link-shopall")
	WebElement shopdeptlink;

	@FindBy(css = ".nav-logo-link")
	WebElement amazonicon;

	// Method to verify if Shop By Department Link is present and to click it if displayed
	public synchronized ShopByDeptPage clickShopByDept(String browser) throws Exception {
		// call method to wait till page is loaded
		ExternalWaitLoadPage.isPageLoaded(browser, amazonicon, "Amazon Home");
		Assert.assertEquals(shopdeptlink.isDisplayed(), true);
		shopdeptlink.click();
		ExtentTestManager.getTest(browser).log(LogStatus.PASS, "Shop by Department link found and clicked");
		return new ShopByDeptPage(browser);
	}
}
