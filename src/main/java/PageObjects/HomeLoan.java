package PageObjects;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import Utilities.DriverSetup;

public class HomeLoan extends DriverSetup {
	By website = By.xpath("//a[normalize-space()='Home Loan']");
	By homeloanamt = By.id("loanamount");
	By interestrate = By.id("loaninterest");
	By tenure = By.id("loanterm");
	By monthid = By.id("startmonthyear");
	By emiamount = By.xpath("//div[@id='emiamount']/p");
	By totalinterest = By.xpath("//div[@id='emitotalinterest']/p");
	By totalamount = By.xpath("//div[@id='emitotalamount']/p");
	By expandplusbutton = By.xpath(
			"//div[@id='emipaymenttable']/table/tbody//tr[@class='row no-margin yearlypaymentdetails']/td[@class='col-2 col-lg-1 paymentyear toggle']");
	By lastyeartableloc = By.xpath(
			"//div[@id='emipaymenttable']//table//tbody//tr[@class='row no-margin yearlypaymentdetails'][last()]");
	By monthlydetailyeartable = By.xpath("//div[@class='monthlypaymentcontainer']/table/tbody");
	By header_payments_table = By.xpath("//div[@id='emipaymenttable']/table/tbody/tr[1]");

	public void homeLoan() throws IOException, InterruptedException {

		/*
		 * 2. pick Home Loan EMI Calculator, fill relevant details & extract all the
		 * data from year on year table & store in excel;
		 */

		// clicking on home loan
		WebElement home_loan = driver.findElement(website);
		home_loan.click();
		Thread.sleep(2000);
	}

	public void loan_amount() throws InterruptedException, IOException {

		// Loan amount element
		WebElement loan_amount = driver.findElement(homeloanamt);
		String val1 = loan_amount.getAttribute("value");
		if (val1 != null) {
			for (int i = 0; i < val1.length(); i++) {
				loan_amount.sendKeys(Keys.BACK_SPACE);
			}
		}
		loan_amount.sendKeys(p.getProperty("homeLoanAmount")); // loan_amount=2500000
		Thread.sleep(4000);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot/home1.png"));
	}

	public void interest_rate() throws InterruptedException, IOException {
		// interest rate element
		WebElement interest_rate = driver.findElement(interestrate);
		String val2 = interest_rate.getAttribute("value");
		if (val2 != null) {
			for (int i = 0; i < val2.length(); i++) {
				interest_rate.sendKeys(Keys.BACK_SPACE);
			}
		}
		interest_rate.sendKeys(p.getProperty("homeInterestRate")); // interest rate=15
		Thread.sleep(2000);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot/home2.png"));
	}

	public void Loan_tenure() throws InterruptedException, IOException {
		// tenure element
		WebElement loan_term = driver.findElement(tenure);
		String val3 = loan_term.getAttribute("value");
		if (val3 != null) {
			for (int i = 0; i < val3.length(); i++) {
				loan_term.sendKeys(Keys.BACK_SPACE);
			}
		}
		loan_term.sendKeys(p.getProperty("homeLoanTenure")); // Tenure=4years
		loan_term.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot/home3.png"));
	}

	public void printHL() throws InterruptedException, IOException {
		System.out.println("---------------Home Loan-----------------");

		String loanEmi = driver.findElement(emiamount).getText();
		System.out.println("Loan EMI per month : " + loanEmi);
		String totalInterest = driver.findElement(totalinterest).getText();
		System.out.println("Total Interest Payable : " + totalInterest);
		String totalAmount = driver.findElement(totalamount).getText();
		System.out.println("Total Payment (Principal + Interest) : " + totalAmount);
		Thread.sleep(3000);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot/home4.png"));
	}

	// Storing the data into excel
	// Storing all the WebElements of tables(year wise tables) into a single list

	public void storeDataInExcel() throws InterruptedException, IOException {
		List<WebElement> expandbutton = driver.findElements(expandplusbutton);

		for (int i = 0; i < expandbutton.size(); i++) {
			expandbutton.get(i).click();
			Thread.sleep(2000);
		}
		Thread.sleep(4000);
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshot/home5.png"));
		// scrolling to the last table year
		WebElement loc1 = driver.findElement(lastyeartableloc);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", loc1);

		WebElement header = driver.findElement(header_payments_table);
		List<WebElement> tables = driver.findElements(monthlydetailyeartable);
		// System.out.println("count of table elements : "+tables.size());

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Sheet1");
		int rowNum = 0;

		// Create a new row in excel sheet
		XSSFRow excelRow = sheet.createRow(rowNum++);
		List<WebElement> heading_cells = header.findElements(By.tagName("th"));

		int heading_cell_num = 0;
		for (WebElement head_cell : heading_cells) {
			String valueOfHeader = head_cell.getText();
			if (valueOfHeader != "") {
				excelRow.createCell(heading_cell_num++).setCellValue(valueOfHeader);
			}

		}

		// div[@id='emipaymenttable']/table/tbody

		for (int tableIndex = 0; tableIndex < tables.size(); tableIndex++) {
			WebElement tableElement = tables.get(tableIndex);
			List<WebElement> rows = tableElement.findElements(By.tagName("tr"));

			for (WebElement row : rows) {
				List<WebElement> cells = row.findElements(By.tagName("td"));
//				System.out.print(cells.size());
				excelRow = sheet.createRow(rowNum++);

				int cellNum = 0;
				for (WebElement cell : cells) {
					excelRow.createCell(cellNum++).setCellValue(cell.getText());
				}
			}

			// Adding a blank row for better readability
			sheet.createRow(rowNum++);
		}
		System.out.println("Home loan tables are stored in excel!");

		try {
			FileOutputStream file = new FileOutputStream(
					"C:\\Users\\2308938\\eclipse-workspace\\ProjectHackathon\\OutputStoredData\\HomeLoanData.xlsx");
			workbook.write(file);
			Thread.sleep(10000);
			workbook.close();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Scrolling to the top of the webpage
		js.executeScript("window.scrollTo(0,0);");
		Thread.sleep(2200);
	}
}