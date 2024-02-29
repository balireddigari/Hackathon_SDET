package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import Utilities.DriverSetup;

public class LoanTenure extends DriverSetup {
	By menuButton = By.xpath("//a[@id='menu-item-dropdown-2696']");
	By LoanCal = By.xpath("//a[@title='Loan Calculator']");
	By Tenure_Cal = By.xpath("//*[@id=\"loan-tenure-calc\"]");
	By Lamount_TextBox = By.xpath("//*[@id='loanamount']");
	By LoanAmount_Slider = By.xpath("//*[@id=\"loanamountslider\"]/span");
	By Emi_TextBox = By.id("loanemi");
	By Emi_slider = By.xpath("//*[@id=\"loanemislider\"]/span");
	By interest_slider = By.xpath("//*[@id=\"loaninterestslider\"]/span");
	By interest_TextBox = By.id("loaninterest");
	By Fees_Slider = By.xpath("//*[@id=\"loanfeesslider\"]/span");
	By Fees_TextBox = By.id("loanfees");

	public void menu() throws IOException, InterruptedException {
		WebElement MenuButton = driver.findElement(menuButton);
		MenuButton.click();
		Thread.sleep(1500);
		WebElement LC = driver.findElement(LoanCal);
		LC.click();
		WebElement LoanTenure = driver.findElement(Tenure_Cal);
		LoanTenure.click();
		Thread.sleep(4000);
	}

	public void Loan_Amount() throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		WebElement LoanAmount_LT = driver.findElement(Lamount_TextBox);
		WebElement loanAmountSlider_LT = driver.findElement(LoanAmount_Slider);
		Boolean loan_box_result = LoanAmount_LT.isEnabled() && LoanAmount_LT.isDisplayed();
		sa.assertTrue(true == loan_box_result, "loanamount searchbox is not working as expected");
		String expected_value = "72,00,000";
		actions.dragAndDropBy(loanAmountSlider_LT, 200, 0).perform();
		Thread.sleep(2000);
		String actual_value = LoanAmount_LT.getAttribute("value");
		sa.assertEquals(actual_value, expected_value, "Slider and textboxes are not working as expected");
		sa.assertAll();
	}

	public void EMI() throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		Thread.sleep(3000);
		WebElement EMITextBox = driver.findElement(Emi_TextBox);
		WebElement EMI_Slider = driver.findElement(Emi_slider);
		Actions actions = new Actions(driver);
		Boolean search_box_result = EMITextBox.isEnabled() && EMITextBox.isDisplayed();
		sa.assertTrue(true == search_box_result, "interest rate textbox is not working as expected");
		String expected_value = "75,049.64";
		Thread.sleep(2000);
		actions.dragAndDropBy(EMI_Slider, 50, 0).perform();
		Thread.sleep(2000);
		String actual_value = EMITextBox.getAttribute("value");
		sa.assertEquals(actual_value, expected_value, "Slider and textboxes are not working as expected");
		sa.assertAll();
	}

	public void LoanInterest() throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		Thread.sleep(3000);
		WebElement loaninterest_slider = driver.findElement(interest_slider);
		WebElement loaninterest_TextBox = driver.findElement(interest_TextBox);
		Actions actions = new Actions(driver);
		Boolean search_box_result = loaninterest_TextBox.isEnabled() && loaninterest_TextBox.isDisplayed();
		sa.assertTrue(true == search_box_result, "lOAN textbox is not working as expected");
		String expected_value = "15.5";
		Thread.sleep(2000);
		actions.dragAndDropBy(loaninterest_slider, 150, 0).perform();
		Thread.sleep(2000);
		String actual_value = loaninterest_TextBox.getAttribute("value");
		sa.assertEquals(actual_value, expected_value, "Slider and textboxes are not working as expected");
		sa.assertAll();
	}

	public void fees_charges() throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		Thread.sleep(3000);
		WebElement FeesCharges_slider = driver.findElement(Fees_Slider);
		WebElement FeesCharges_textbox = driver.findElement(Fees_TextBox);
		Actions actions = new Actions(driver);
		Boolean search_box_result = FeesCharges_textbox.isEnabled() && FeesCharges_textbox.isDisplayed();
		sa.assertTrue(true == search_box_result, "Fees and charges textbox is not working as expected");
		String expected_value = "33,500";
		Thread.sleep(2000);
		actions.dragAndDropBy(FeesCharges_slider, 150, 0).perform();
		Thread.sleep(2000);
		String actual_value = FeesCharges_textbox.getAttribute("value");
		sa.assertEquals(actual_value, expected_value, "Slider and textboxes are not working as expected");
		sa.assertAll();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");

	}

}
