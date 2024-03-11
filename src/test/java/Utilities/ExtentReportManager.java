package Utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseTests.BaseTest1;

public class ExtentReportManager extends BaseTest1 implements ITestListener {
	public ExtentSparkReporter sparkReporter; // UI of the report
	public ExtentReports extent; // populate common info on the report
	public ExtentTest test; // creating test case entries in the report and update status of the test
							// methods

	public void onStart(ITestContext context) {
		// specify the location of the report
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/Myreports.html");
		
																											
		sparkReporter.config().setDocumentTitle("Find Interest Of The Current Year"); // Title of report
		sparkReporter.config().setReportName(" EMI Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.DARK);
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);

		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "Bhargavi");
		extent.setSystemInfo("os", "Windows11");
		extent.setSystemInfo("Browser name", "Chrome,Edge");

	}

	public void onTestSuccess(ITestResult result) {

		test = extent.createTest(result.getName()); // create a new entry in the report
		test.log(Status.PASS, "Test case PASSED is:" + result.getName()); // update status p/f/s

	}

	public void onTestFailure(ITestResult result) {

		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
		test.log(Status.FAIL, "Test Case FAILED cause is: " + result.getThrowable());

	}

	public void onTestSkipped(ITestResult result) {

		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());

	}

	public void onFinish(ITestContext context) {

		extent.flush();
	}

}
