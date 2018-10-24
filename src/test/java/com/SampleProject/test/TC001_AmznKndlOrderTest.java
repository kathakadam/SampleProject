package com.SampleProject.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commonFunctions.HandleDriver;
import commonFunctions.ExtentTestManager;
import pageFunctions.AmazonHomePage;

public class TC001_AmznKndlOrderTest {
	@Parameters({ "url", "browser" })
	@Test
	public synchronized void baseTC001(String url, String browser) throws Exception {

		ExtentTestManager.initTestReports("TC001-" + browser, // initializing ExtentTest for adding logs and screenshot
				"Verify that amazon asks for email address or phone number", browser);
		HandleDriver.initDriver(url, browser);
		AmazonHomePage ahp = new AmazonHomePage(browser);
		ahp.clickShopByDept(browser).clickKindlePaperwhite(browser).addToCart(browser).closeClick(browser)
				.checkCart(browser).proceedToCheckout(browser).signInVerification(browser);

	}
}
