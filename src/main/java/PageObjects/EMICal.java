package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import Utilities.DriverSetup;

public class EMICal extends DriverSetup {
	By menuButton = By.xpath("//a[@id='menu-item-dropdown-2696']");
	By LoanCal = By.xpath("//a[@title='Loan Calculator']");
	By Emi_Cal = By.xpath("//*[@id=\'emi-calc\']");
	By LA_TextBox = By.id("loanamount");
	By LA_Slider = By.xpath("//*[@id=\"loanamountslider\"]/span");
	By interest_Textbox = By.id("loaninterest");
	By interest_slider = By.xpath("//*[@id=\"loaninterestslider\"]/span");
	By tenure_textbox = By.id("loanterm");
	By tenure_slider = By.xpath("//div[@id='loantermslider']//span");
	By Fees_textbox = By.xpath("//input[@id='loanfees']");
	By Fees_slider = By
			.xpath("//div[@id='loanfeesslider']//span[@class='ui-slider-handle ui-corner-all ui-state-default']");

	public void menu() throws IOException, InterruptedException {
		WebElement MenuButton = driver.findElement(menuButton);
		MenuButton.click();
		Thread.sleep(1500);
		WebElement LC = driver.findElement(LoanCal);
		LC.click();
		WebElement emi = driver.findElement(Emi_Cal);
		emi.click();
		Thread.sleep(4000);
	}

	public void Loan_Amount() throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		WebElement LoanAmount_SearchBox = driver.findElement(LA_TextBox);
		WebElement loanAmountSlider = driver.findElement(LA_Slider);
		Boolean loan_box_result = LoanAmount_SearchBox.isEnabled() && LoanAmount_SearchBox.isDisplayed();
		sa.assertTrue(true == loan_box_result, "loanamount searchbox is not working as expected");
		String expected_value = "72,00,000";
		actions.dragAndDropBy(loanAmountSlider, 200, 0).perform();
		Thread.sleep(2000);
		String actual_value = LoanAmount_SearchBox.getAttribute("value");
		sa.assertEquals(actual_value, expected_value, "Slider and textboxes are not working as expected");
		sa.assertAll();
	}

	public void InterestRate() throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		Thread.sleep(3000);
		WebElement searchinterestTextBox = driver.findElement(interest_Textbox);
		WebElement interestRate_Slider = driver.findElement(interest_slider);
		Actions actions = new Actions(driver);
		Boolean search_box_result = searchinterestTextBox.isEnabled() && searchinterestTextBox.isDisplayed();
		sa.assertTrue(true == search_box_result, "interest rate textbox is not working as expected");
		String expected_value = "12.25";
		Thread.sleep(2000);
		actions.dragAndDropBy(interestRate_Slider, 50, 0).perform();
		Thread.sleep(2000);
		String actual_value = searchinterestTextBox.getAttribute("value");
		sa.assertEquals(actual_value, expected_value, "Slider and textboxes are not working as expected");
		sa.assertAll();
	}

	public void LoanTenure() throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		Thread.sleep(3000);
		WebElement searchtenureTextBox = driver.findElement(tenure_textbox);
		WebElement loanterm_slider = driver.findElement(tenure_slider);
		Actions actions = new Actions(driver);
		Boolean search_box_result = searchtenureTextBox.isEnabled() && searchtenureTextBox.isDisplayed();
		sa.assertTrue(true == search_box_result, "lOAN textbox is not working as expected");
		String expected_value = "12";
		Thread.sleep(2000);
		actions.dragAndDropBy(loanterm_slider, 150, 0).perform();
		Thread.sleep(2000);
		String actual_value = searchtenureTextBox.getAttribute("value");
		sa.assertEquals(actual_value, expected_value, "Slider and textboxes are not working as expected");
		sa.assertAll();
	}

	public void fees_charges() throws InterruptedException {
		SoftAssert sa = new SoftAssert();
		Thread.sleep(3000);
		WebElement FeesCharges_textbox = driver.findElement(Fees_textbox);
		WebElement FeesCharges_slider = driver.findElement(Fees_slider);
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
	}
}