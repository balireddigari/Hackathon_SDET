package TestCases;

import java.io.IOException;

import org.testng.annotations.Test;

import BaseTests.BaseTest1;
import PageObjects.CarLoan;
import Utilities.DriverSetup;

public class Car_Loan_Test extends BaseTest1 {
	
	static CarLoan cl = new CarLoan();
	
	//Test method to open the Application
	@Test(priority = 1)
	public void openApp() {
		DriverSetup.getUrl();
	}
	
	// Test Method  for car loan Functionality
	@Test(priority = 2, dependsOnMethods = { "openApp" })
	public void carLoan() throws InterruptedException, IOException {
		cl.carLoan();
	}
	
	// Test Method  for car interest rate Functionality
	@Test(priority = 3, dependsOnMethods = { "openApp", "carLoan" })
	public void carInterestRate() throws IOException, InterruptedException {
		cl.carInterestRate();
	}
	
	//Test Method  for car Tenure Functionality
	@Test(priority = 4, dependsOnMethods = { "openApp", "carLoan" })
	public void carLoanTenure() throws IOException, InterruptedException {
		cl.carLoanTenure();

	}
	
	// To display interest amount & principal amount for one month
	@Test(priority = 5, dependsOnMethods = { "openApp", "carLoan", "carInterestRate", "carLoanTenure" })
	public void carIAPA() throws IOException, InterruptedException {

		cl.carIAPA();
	}
}