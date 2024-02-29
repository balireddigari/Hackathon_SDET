package Utilities;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverSetup {

	public static WebDriver driver;
	public static Properties p;
	public static FileReader reader;

	public static void setUpDriver() throws IOException {
		FileReader reader = new FileReader(
				"C:\\Users\\2308938\\eclipse-workspace\\ProjectHackathon\\src\\test\\resources\\config.properties");
		p = new Properties();
		p.load(reader);
		if (p.getProperty("browser").equalsIgnoreCase("chrome")) {
			// Setting up chrome driver
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (p.getProperty("browser").equalsIgnoreCase("edge")) {
			// Setting up edge driver
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("wrong browser selection");
		}
	}

	public static void getUrl() {
		// implicit wait of 20 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// opening the website
		driver.get(p.getProperty("url"));

		// Maximizing the Browser Window
		driver.manage().window().maximize();
	}

	public static void closeBrowser() {
		driver.close();
	}

}
