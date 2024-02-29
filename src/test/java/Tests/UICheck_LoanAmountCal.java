package Tests;

import java.io.IOException;
import org.testng.annotations.Test;

import BaseTests.BaseTest1;
import PageObjects.LoanAmount;
import Utilities.DriverSetup;

public class UICheck_LoanAmountCal extends BaseTest1 {

	LoanAmount la = new LoanAmount();
	static DriverSetup ds = new DriverSetup();

	@Test(priority = 1)
	public void setupApp() {

		DriverSetup.getUrl();
	}

	@Test(priority = 2, dependsOnMethods = { "setupApp" })
	public void Menubutton() throws IOException, InterruptedException {
		la.menu();
	}

	@Test(priority = 3, dependsOnMethods = { "setupApp" })
	public void Loanamount() throws InterruptedException {
		la.loan_Amount();

	}

	@Test(priority = 4, dependsOnMethods = { "setupApp" })
	public void interestRate() throws InterruptedException {
		la.interest_Rate();
	}

	@Test(priority = 5, dependsOnMethods = { "setupApp" })
	public void LoanTenure() throws InterruptedException {
		la.Loan_Tenure();
	}

	@Test(priority = 6, dependsOnMethods = { "setupApp" })
	public void feesCharges() throws InterruptedException {
		la.fees_charges();
	}

}