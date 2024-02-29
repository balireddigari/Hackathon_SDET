package Tests;

import java.io.IOException;

import org.testng.annotations.Test;
import BaseTests.BaseTest1;
import PageObjects.MonthandYear;
import Utilities.DriverSetup;

public class MonthandYear_Test extends BaseTest1 {
	MonthandYear m = new MonthandYear();
	static DriverSetup ds = new DriverSetup();

	@Test(priority = 1)
	public void openApp() {
		DriverSetup.getUrl();
	}

	@Test(priority = 2, dependsOnMethods = { "openApp" })
	public void button() throws IOException, InterruptedException {
		m.button();
	}

	@Test(priority = 3, dependsOnMethods = { "openApp" })
	public void yearAndMonth_Emi() throws InterruptedException {
		m.yearAndMonth();

	}

}