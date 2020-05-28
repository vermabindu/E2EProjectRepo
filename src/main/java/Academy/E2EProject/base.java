package Academy.E2EProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	public Properties prop;
	public WebDriver driver;

	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream  fits = new FileInputStream("/home/sanjna/Desktop/E2EProject/src/main/resources/data.properties");
		prop.load(fits);
		String browserName= prop.getProperty("browser");
		System.out.println(browserName);
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/home/sanjna/git/seleniumRepo/src/main/resources/linux/googlechrome/64bit/chromedriver");
			/*
			 * ChromeOptions options = new ChromeOptions();
			 * options.addArguments("--no-sandbox"); // Bypass OS security model
			 * options.addArguments("--disable-dev-shm-usage"); // overcome limited resource
			 * problems options.addArguments("--headless");
			 * options.setExperimentalOption("useAutomationExtension", false);
			 * options.addArguments("start-maximized"); // open Browser in maximized mode
			 * options.addArguments("disable-infobars"); // disabling infobars
			 * options.addArguments("--disable-extensions"); // disabling extensions
			 * options.addArguments("--disable-gpu"); // applicable to windows os only
			 */
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","/home/sanjna/git/seleniumRepo/src/main/resources/linux/marionette/64bit/geckodriver");
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equals("IE"))
		{
			System.setProperty("webdriver.gecko.driver","");
			driver = new FirefoxDriver();
		}
		
		else if(browserName.equals("opera"))
			{
			System.setProperty("webdriver.opera.driver","/home/sanjna/git/seleniumRepo/src/main/resources/linux/operachromium/64bit/");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException 
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String times = Long.toString(System.currentTimeMillis());
		String destinationFile = System.getProperty("user.dir")+"/reports/"+testCaseName+times+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}
}
