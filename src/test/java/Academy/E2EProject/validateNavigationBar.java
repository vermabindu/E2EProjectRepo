package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LandingPage;

public class validateNavigationBar extends base {
	public WebDriver driver;
	public Logger log = LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException 
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void basePageNavigation() throws IOException, InterruptedException {
		
		LandingPage lp = new LandingPage(driver);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertTrue(lp.getNavigation().isDisplayed());
		log.info("NviagationBar displyed!");
		//Assert.assertFalse(lp.getNavigation().isDisplayed());
		//Thread.sleep(4000);


	}
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}
