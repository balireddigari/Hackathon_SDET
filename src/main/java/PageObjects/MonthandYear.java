package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import Utilities.DriverSetup;

public class MonthandYear extends DriverSetup {

	By menuButton = By.xpath("//a[@id='menu-item-dropdown-2696']");
	By LoanCal = By.xpath("//a[@title='Loan Calculator']");
	By loan_tenure = By.xpath("//*[@id=\"loanterm\"]");
	By Emi_button = By.xpath("//*[@id=\"emi-calc\"]/a[1]");
	By Tenure = By.xpath("//*[@id=\"loanterm\"]");
	By Month_click = By.xpath("//*[@id=\"ltermwrapper\"]/div[1]/div/div/div/div/div/label[2]");

	public void button() throws IOException, InterruptedException {
		WebElement MenuButton = driver.findElement(menuButton);
		MenuButton.click();
		Thread.sleep(1500);
		WebElement LC = driver.findElement(LoanCal);
		LC.click();
		Thread.sleep(4000);
	}

	public void yearAndMonth() throws InterruptedException {
		WebElement Emic = driver.findElement(Emi_button);
		Emic.click();
		WebElement loanTerm = driver.findElement(Tenure);
		loanTerm.click();
		Thread.sleep(3000);
		WebElement month = driver.findElement(Month_click);
		month.click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)", "");
	}

}