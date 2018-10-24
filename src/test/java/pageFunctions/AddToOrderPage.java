package pageFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import commonFunctions.HandleDriver;
import commonFunctions.ExtentTestManager;
import commonFunctions.ExternalWaitLoadPage;

public class AddToOrderPage {
	private WebDriver driver;

	public AddToOrderPage(String browser) {
		driver = HandleDriver.getDriver(browser);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='a-popover-wrapper']/header/button[1]")
	WebElement closebutton;

	@FindBy(css = "#a-autoid-21>span>input")
	WebElement continuebutton;

	// method to click on close or continue on add to Order Page
	public synchronized ShoppingCartPage closeClick(String browser) throws Exception {
		// call method to wait till page is loaded
		ExternalWaitLoadPage.isPageLoaded(browser, closebutton, "Add to Order");
		// sometimes close button not recognized in chrome
		driver = HandleDriver.getDriver(browser);
		if (browser.equalsIgnoreCase("firefox")) {
			Assert.assertEquals(closebutton.isDisplayed(), true);
			Actions a = new Actions(driver);
			a.moveToElement(closebutton).click(closebutton).build().perform(); // Sometimes not working without
																				// moveToElement
		} else if (browser.equalsIgnoreCase("chrome")) {
			Assert.assertEquals(continuebutton.isDisplayed(), true);
			Actions a = new Actions(driver);
			a.moveToElement(continuebutton).click(continuebutton).build().perform();// Sometimes not working without
																					// moveToElement
		}
		ExtentTestManager.getTest(browser).log(LogStatus.PASS, "None Selected in Add to Order Screen");
		return new ShoppingCartPage(browser);
	}
}
