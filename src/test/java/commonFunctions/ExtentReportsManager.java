package commonFunctions;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentReportsManager {
	private static ExtentReports extent;

	// method to return ExtentReports object
	public synchronized static ExtentReports getReporter() {
		return extent;
	}

	// method to initialize ExtentReports
	public synchronized static void initReporter() {
		extent = new ExtentReports("./Report/report.html", true);

	}
}
