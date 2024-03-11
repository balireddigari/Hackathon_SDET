package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import Utilities.DriverSetup;

public class LoanAmount extends DriverSetup {
	By menuButton = By.xpath("//a[@id='menu-item-dropdown-2696']");
	By LoanCal = By.xpath("//a[@title='Loan Calculator']");
	By LoanAmt_Cal = By.xpath("//*[@id=\"loan-amount-calc\"]");
	By la_Textbox = By.xpath("//input[@id='loanemi']");
	By la_slider = By.xpath("//div[@id='loanemislider']//span");
	By interest_textbox = By.xpath("//input[@id='loaninterest']");
	By interest_slider = By.xpath("//div[@id='loaninterestslider']//span");
	By tenure_textbox = By.xpath("//input[@id='loanterm']");
	By tenure_slider = By.xpath("//div[@id='loantermslider']//span");
	By fees_textbox = By.xpath("//input[@id='loanfees']");
	By fees_slider = By.xpath("//div[@id='loanfeesslider']//span");

	public void menu() throws IOException, InterruptedException {
		// Clicking on Menu Button
		WebElement MenuButton = driver.findElement(menuButton);
		MenuButton.click();
		Thread.sleep(1500);
		// Clicking on Loan Calculator
		WebElement LC = driver.findElement(LoanCal);
		LC.click();
		// Clicking on Loan Tenure Calculator
		WebElement LoanTenure = driver.findElement(LoanAmt_Cal);
		LoanTenure.click();
		Thread.sleep(4000);
	}

	// Method to check the textboxes and sliders
	public void loan_Amount() throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		Thread.sleep(4000);
		// Creating an actions object to perform mouse actions
		Actions action = new Actions(driver);
		// Locating the loan amount text and slider web elements
		WebElement Loan_Amount_textbox = driver.findElement(la_Textbox);
		WebElement Loan_Amount_slider = driver.findElement(la_slider);
		// Checking if both the loan amount text and sliders are displayed
		Boolean loan_box_result = Loan_Amount_textbox.isDisplayed() && Loan_Amount_slider.isDisplayed();
		// Asserting that both elements are displayed as expected
		sa.assertTrue(true == loan_box_result, "loanamount searchbox is not working as expected");
		String initial_Value = Loan_Amount_textbox.getAttribute("value");
		// Dragging and dropping the loan amount slider by 200 pixels horizontally
		action.dragAndDropBy(Loan_Amount_slider, 200, 0).perform();
		Thread.sleep(2000);
		// Getting the actual value from the loan amount textbox
		String actual_value = Loan_Amount_textbox.getAttribute("value");
		// Asserting that the initial value not matches the actuals value
		sa.assertNotEquals(actual_value, initial_Value, "Slider and textboxes are not working as expected");
		// To ensure all assertions are executed
		sa.assertAll();
	}

	// Method to check the interest rate textboxes and sliders
	public void interest_Rate() throws InterruptedException {
		// Creating a softassert object
		SoftAssert sa = new SoftAssert();
		Thread.sleep(4000);
		Actions action = new Actions(driver);
		WebElement Loan_Interest_textbox = driver.findElement(interest_textbox);
		WebElement Loan_Interest_slider = driver.findElement(interest_slider);
		Boolean loan_box_result = Loan_Interest_textbox.isDisplayed() && Loan_Interest_slider.isDisplayed();
		sa.assertTrue(true == loan_box_result, "loanInterest searchbox is not working as expected");
		String initial_Value = Loan_Interest_textbox.getAttribute("value");
		action.dragAndDropBy(Loan_Interest_slider, 50, 0).perform();
		Thread.sleep(2000);
		String actual_value = Loan_Interest_textbox.getAttribute("value");
		sa.assertNotEquals(actual_value, initial_Value, "Slider and textboxes are not working as expected");
		sa.assertAll();
	}

	// Method to check the Loan Tenure textboxes and sliders
	public void Loan_Tenure() throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		Thread.sleep(4000);
		Actions action = new Actions(driver);
		WebElement Loan_Tenure_textbox = driver.findElement(tenure_textbox);
		WebElement Loan_Tenure_slider = driver.findElement(tenure_slider);
		Boolean loan_box_result = Loan_Tenure_textbox.isDisplayed() && Loan_Tenure_slider.isDisplayed();
		sa.assertTrue(true == loan_box_result, "loanInterest searchbox is not working as expected");
		String initial_Value = Loan_Tenure_textbox.getAttribute("value");;
		action.dragAndDropBy(Loan_Tenure_slider, 90, 0).perform();
		Thread.sleep(2000);
		String actual_value = Loan_Tenure_textbox.getAttribute("value");
		sa.assertNotEquals(actual_value, initial_Value, "Slider and textboxes are not working as expected");
		sa.assertAll();
	}

	// Method to check the Fees and Charges textboxes and sliders
	public void fees_charges() throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		Thread.sleep(4000);
		Actions action = new Actions(driver);
		WebElement Loan_fees_textbox = driver.findElement(fees_textbox);
		WebElement Loan_fees_slider = driver.findElement(fees_slider);
		Boolean loan_box_result = Loan_fees_textbox.isDisplayed() && Loan_fees_slider.isDisplayed();
		sa.assertTrue(true == loan_box_result, "loanInterest searchbox is not working as expected");
		String initial_Value = Loan_fees_textbox.getAttribute("value");
		action.dragAndDropBy(Loan_fees_slider, 30, 0).perform();
		Thread.sleep(2000);
		String actual_value = Loan_fees_textbox.getAttribute("value");
		sa.assertNotEquals(actual_value, initial_Value, "Slider and textboxes are not working as expected");
		sa.assertAll();
	}
}