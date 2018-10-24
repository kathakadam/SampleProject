package pageFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import commonFunctions.HandleDriver;
import commonFunctions.ExtentTestManager;
import commonFunctions.ExternalWaitLoadPage;

public class PaperwhiteAddCartPage {
	private WebDriver driver;
	Actions a;

	public PaperwhiteAddCartPage(String browser) {
		driver = HandleDriver.getDriver(browser);
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "quantity")
	WebElement selquantity;

	@FindBy(css = "#add-to-cart-button")
	WebElement addtocartbutton;
	
	//Method to verify if Quantity DropDown is present; select quantity as 2; verify Add to Cart button is present and to click it if displayed
	public synchronized AddToOrderPage addToCart(String browser) throws Exception {
		//call method to wait till page is loaded
		ExternalWaitLoadPage.isPageLoaded(browser,selquantity,"Paperwhite Add to Cart");
		Assert.assertEquals(selquantity.isDisplayed(), true);
		Select s = new Select(selquantity);
		s.selectByValue("2");
		ExtentTestManager.getTest(browser).log(LogStatus.PASS, "Quantity Selected as 2");
		Assert.assertEquals(addtocartbutton.isDisplayed(), true);
		addtocartbutton.click();
		ExtentTestManager.getTest(browser).log(LogStatus.PASS, "Add to Cart Link Clicked");
		return new AddToOrderPage(browser);
	}
}
