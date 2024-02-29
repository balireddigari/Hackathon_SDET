package PageObjects;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Utilities.DriverSetup;

public class CarLoan extends DriverSetup {
	By website = By.xpath("//a[normalize-space()='Car Loan']");
	By loanamount = By.id("loanamount");
	By interestrate = By.id("loaninterest");
	By loanterm = By.id("loanterm");
	By yeartable = By.xpath("//*[@id=\"emipaymenttable\"]/table/tbody/tr[1]");
	By tableExpandButton = By.xpath(
			"//div[@id='emipaymenttable']/table/tbody//tr[@class='row no-margin yearlypaymentdetails']/td[@class='col-2 col-lg-1 paymentyear toggle']");
	By principal_1st_month = By.xpath("//tr[@id='monthyear2024']//td//tr[1]//td[2]");
	By interest_1st_month = By.xpath("//*[@id=\"monthyear2024\"]/td/div/table/tbody/tr[1]/td[3]");
	By Total_Amount = By.xpath("//*[@id=\"monthyear2024\"]/td/div/table/tbody/tr[1]/td[4]");

	public void carLoan() throws InterruptedException, IOException {
		// Select Car Loan
		// to perform Scroll on application using Selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement carloan = driver.findElement(website);

		js.executeScript("arguments[0].scrollIntoView();", carloan);

		Thread.sleep(2000);
		carloan.click();

		// car loan amount attribute
		WebElement loan_amount = driver.findElement(loanamount);

		String val1 = loan_amount.getAttribute("value");
		if (val1 != null) {
			for (int i = 0; i < val1.length(); i++) {
				loan_amount.sendKeys(Keys.BACK_SPACE);
			}
		}
		loan_amount.sendKeys(p.getProperty("carLoanAmount")); // 1500000
		Thread.sleep(4000);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot/car1.png"));
	}

	public void carInterestRate() throws IOException, InterruptedException {
		// interest rate element
		WebElement interest_rate = driver.findElement(interestrate);
		String val2 = interest_rate.getAttribute("value");
		if (val2 != null) {
			for (int i = 0; i < val2.length(); i++) {
				interest_rate.sendKeys(Keys.BACK_SPACE);
			}
		}
		interest_rate.sendKeys(p.getProperty("carInterestRate")); // 9.5
		Thread.sleep(4000);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot/car2.png"));
	}

	@Test(priority = 3)
	public void carLoanTenure() throws IOException, InterruptedException {
		// loan tenure element
		WebElement loan_term = driver.findElement(loanterm);
		String val3 = loan_term.getAttribute("value");
		if (val3 != null) {
			for (int i = 0; i < val3.length(); i++) {
				loan_term.sendKeys(Keys.BACK_SPACE);
			}
		}
		loan_term.sendKeys(p.getProperty("carLoanTenure"), Keys.ENTER); // 1 year

		Thread.sleep(3000);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot/car3.png"));

	}

	// To display interest amount & principal amount for one month
	public void carIAPA() throws IOException, InterruptedException {

		// to perform Scroll on application using Selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");

		Thread.sleep(3000);

		// EMI IN ARREARS
		driver.findElement(By.xpath("//label[normalize-space()='EMI in Arrears']")).click();

		// Scrolling to the year details table by visibility of the element
		WebElement year_table = driver.findElement(yeartable); // done
		js.executeScript("arguments[0].scrollIntoView();", year_table);

		Thread.sleep(3000);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot/car4.png"));

		// Expanding all the year tables for month to month details
		List<WebElement> expandbutton = driver.findElements(tableExpandButton);

		for (int i = 0; i < expandbutton.size(); i++) {
			expandbutton.get(i).click();
			Thread.sleep(3000);
		}

		System.out.println("-----------------Car Loan----------------");

		// principal amount for the 1st month
		String principal = driver.findElement(principal_1st_month).getText();
		System.out.println("Principal[A] for the 1st month :" + principal);

		// interest for 1st month
		String interest = driver.findElement(interest_1st_month).getText();
		System.out.println("Interest[B] for the 1st month :" + interest);

		// Total Amount =Principle[A]+Interest[B]
		String total = driver.findElement(Total_Amount).getText();
		System.out.println("Total[A+B] for the 1st month :" + total);

		// Scrolling up the webpage
		js.executeScript("window.scrollTo(0,0);");
		Thread.sleep(1500);
	}
}