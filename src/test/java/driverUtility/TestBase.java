package driverUtility;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class TestBase {
	private static final Logger logger = LogManager.getLogger(TestBase.class);
	private WebDriver driver;
	public Properties prop;
	public WebDriver getDriver() throws Throwable
	{
		logger.info("Initialize Properties");
		prop = new Properties();
		logger.info("Read Config File -->"+Constants.config);
		FileInputStream reader  = new FileInputStream(new File(Constants.config));
		prop.load(reader);
		String browser = prop.getProperty("browser");
		logger.info("Browser Initialization-->"+browser);
		if(browser.equalsIgnoreCase("chrome"))
		{
			ChromeOptions opt = new ChromeOptions();
			driver = new ChromeDriver(opt);
		}else if(browser.equalsIgnoreCase("edge"))
		{
			EdgeOptions opt = new EdgeOptions();
			driver = new EdgeDriver(opt);
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			FirefoxOptions opt = new FirefoxOptions();
			driver = new FirefoxDriver(opt);
		}
		else
		{
			logger.info("Browser Info not added in config file");
			throw new Throwable().initCause(null);	
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		logger.info("Test Url Openned->"+prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		Constants.driverConst = driver;
		return driver;
	}
	
	public void quitBrowser()
	{
		logger.info("Quit Browser");
		driver.quit();
	}
}
