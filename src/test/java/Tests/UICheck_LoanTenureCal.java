
package Tests;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseTests.BaseTest1;
import PageObjects.LoanTenure;
import Utilities.DriverSetup;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UICheck_LoanTenureCal extends BaseTest1 {

	LoanTenure lt = new LoanTenure();
	static DriverSetup ds = new DriverSetup();

	@Test(priority = 1)
	public void setupApp() {

		DriverSetup.getUrl();
	}

	@Test(priority = 2, dependsOnMethods = { "setupApp" })
	public void Menubutton() throws IOException, InterruptedException {
		lt.menu();
	}

	@Test(priority = 3, dependsOnMethods = { "setupApp" })
	public void LoanAmount() throws InterruptedException {
		lt.Loan_Amount();
	}

	@Test(priority = 4, dependsOnMethods = { "setupApp" })
	public void EMI_check() throws InterruptedException {

		lt.EMI();
	}

	@Test(priority = 5, dependsOnMethods = { "setupApp" })
	public void Loan_Interest() throws InterruptedException {
		lt.LoanInterest();
	}

	@Test(priority = 6, dependsOnMethods = { "setupApp" })
	public void feescharges() throws InterruptedException {

		lt.fees_charges();
	}

}
