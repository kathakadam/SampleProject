package commonFunctions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentTestManager {
	private static ExtentReports extent = ExtentReportsManager.getReporter();
	private static ExtentTest testreportchrome;
	private static ExtentTest testreportfirefox;
	private static ExtentTest testreport;

	// Method to initialize ExtentTest
	public static synchronized void initTestReports(String tcname, String tcdescription, String browser) throws Exception {
		//try-catch to handle incorrect browser name
		try {
			if (!browser.equalsIgnoreCase("chrome")) {
				if(!browser.equalsIgnoreCase("firefox")){
					testreport = extent.startTest(tcname, tcdescription);
					testreport.log(LogStatus.FAIL, "Browser value is not correct");
					throw new Exception("Browser value not correct");
				}
			}
		}catch(Exception e) {
			throw new Exception("Browser value not correct", e);
		}
		
		if (browser.equalsIgnoreCase("chrome")) {
			testreportchrome = extent.startTest(tcname, tcdescription);
		} else if (browser.equalsIgnoreCase("firefox")) {
			testreportfirefox = extent.startTest(tcname, tcdescription);
		}
	}

	public static synchronized void endTestReports() {
		extent.flush();

	}

	//method to return ExtentTest object depending on the browser passed
	public static synchronized ExtentTest getTest(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			testreport = testreportchrome;
		} else if (browser.equalsIgnoreCase("firefox")) {
			testreport = testreportfirefox;
		}
		return testreport;
	}
}
