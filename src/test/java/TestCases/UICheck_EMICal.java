package TestCases;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseTests.BaseTest1;
import PageObjects.EMICal;
import PageObjects.LoanTenure;
import Utilities.DriverSetup;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UICheck_EMICal extends BaseTest1  {
	EMICal ec = new EMICal();

	@Test(priority = 1)
	public void setupApp() {

		DriverSetup.getUrl();
	}

	@Test(priority = 2, dependsOnMethods = { "setupApp" })
	public void Menubutton() throws IOException, InterruptedException {
		ec.menu();
	}

	@Test(priority = 3, dependsOnMethods = { "setupApp" })
	public void LoanAmount() throws InterruptedException {
		ec.Loan_Amount();

	}

	@Test(priority = 4, dependsOnMethods = { "setupApp" })
	public void Interest_Rate() throws InterruptedException {
		ec.InterestRate();
	}

	@Test(priority = 5, dependsOnMethods = { "setupApp" })
	public void Loan_Tenure() throws InterruptedException {
		ec.LoanTenure();
	}

	@Test(priority = 6, dependsOnMethods = { "setupApp" })
	public void feescharges() throws InterruptedException {
		ec.fees_charges();
	}

}