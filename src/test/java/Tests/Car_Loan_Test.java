package Tests;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseTests.BaseTest1;
import PageObjects.CarLoan;
import Utilities.DriverSetup;

public class Car_Loan_Test extends BaseTest1 {
	static CarLoan cl = new CarLoan();
	static DriverSetup ds = new DriverSetup();

	@Test(priority = 1)
	public void openApp() {
		DriverSetup.getUrl();
	}

	@Test(priority = 2, dependsOnMethods = { "openApp" })
	public void carLoan() throws InterruptedException, IOException {
		cl.carLoan();
	}

	@Test(priority = 3, dependsOnMethods = { "openApp", "carLoan" })
	public void carInterestRate() throws IOException, InterruptedException {
		cl.carInterestRate();
	}

	@Test(priority = 4, dependsOnMethods = { "openApp", "carLoan" })
	public void carLoanTenure() throws IOException, InterruptedException {
		cl.carLoanTenure();

	}

	@Test(priority = 5, dependsOnMethods = { "openApp", "carLoan", "carInterestRate", "carLoanTenure" })
	// To display interest amount & principal amount for one month
	public void carIAPA() throws IOException, InterruptedException {

		cl.carIAPA();
	}
}