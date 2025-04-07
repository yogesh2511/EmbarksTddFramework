package base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import utilities.ExcelReader;
import utilities.PathManager;


public class TestBase {

	public static WebDriver driver;
	public static Properties Config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fConfig;
	public static Properties ORr;
	public static FileInputStream file;
	public static ExcelReader excel = new ExcelReader(PathManager.getResourcePath("\\src\\main\\resources\\excel\\EmbarkData.xlsx"));	
	
	public static Logger log = Logger.getLogger("devpinoyLogger");
	static {
			try {
				fConfig = new FileInputStream(
						PathManager.getResourcePath("/src/main/resources/properties/Config.properties"));
				Config.load(fConfig);
				file = new FileInputStream(
						PathManager.getResourcePath("/src/main/resources/properties/OR.properties"));
				OR.load(file);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	@BeforeSuite(alwaysRun = true)
	public void setUp() {
		
		String browserName= Config.getProperty("browser");
		if (driver == null) {
			if (browserName.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else if (browserName.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}
			log.info("Launching " + browserName + " browser");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(Config.getProperty("testsiteurl"));
			log.info("Navigating to " + Config.getProperty("testsiteurl"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(Config.getProperty("implicitwait"))));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(Config.getProperty("pageloadtimeout"))));
			
		}
	}

	// Cleanup method to close the WebDriver
	@AfterTest(alwaysRun = true)
	public static void close() {
		try {
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// close the browser
			if (driver != null) {
				driver.close();
				driver.quit();
			}
		}

	}
	

}
