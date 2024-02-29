package Tests;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import BaseTests.BaseTest1;
import PageObjects.HomeLoan;
import Utilities.DriverSetup;

public class Home_Loan_Test extends BaseTest1 {

	static HomeLoan hl = new HomeLoan();
	
	static DriverSetup ds = new DriverSetup();

	@Test(priority = 1)
	public void openApp() {
		DriverSetup.getUrl();
	}

	@Test(priority = 2, dependsOnMethods = { "openApp" })
	public void homeLoan() throws InterruptedException, IOException {
		hl.homeLoan();
	}

	@Test(priority = 3, dependsOnMethods = { "openApp" })
	public void loan_amount() throws IOException, InterruptedException {
		hl.loan_amount();
	}

	@Test(priority = 4, dependsOnMethods = { "openApp" })
	public void interest_rate() throws IOException, InterruptedException {
		hl.interest_rate();

	}

	@Test(priority = 5)
	// To display interest amount & principal amount for one month
	public void Loan_tenure() throws IOException, InterruptedException {

		hl.Loan_tenure();
	}

	@Test(priority = 6)
	public void printHL() throws InterruptedException, IOException {
		hl.printHL();
	}

	@Test(priority = 7)
	public void storeDataInexcel() throws InterruptedException, IOException {
		hl.storeDataInExcel();
	}
}