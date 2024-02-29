package BaseTests;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import Utilities.DriverSetup;

public class BaseTest1 {

	@BeforeSuite
	public void setupDriver() throws InterruptedException, IOException {
		DriverSetup.setUpDriver();
	}

	@AfterSuite
	public void exit() {
		DriverSetup.closeBrowser();
	}
}
