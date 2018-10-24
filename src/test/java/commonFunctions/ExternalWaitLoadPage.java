package commonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.LogStatus;

public class ExternalWaitLoadPage {
	// external wait method to check page load
	public static synchronized void isPageLoaded(String browser, WebElement we, String pagename) throws Exception {
		WebDriver driver = HandleDriver.getDriver(browser);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(we));
		} catch (Exception e) {
			ExtentTestManager.getTest(browser).log(LogStatus.FAIL, pagename + " page is not loaded successfully");
			throw new Exception(pagename + " page is not loaded successfully", e);
		}
		ExtentTestManager.getTest(browser).log(LogStatus.PASS, pagename + " page is loaded successfully");
	}
}
