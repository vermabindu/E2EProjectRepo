package Academy.E2EProject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LandingPage;

//import PageObjects.LandingPage;

public class validateTitle extends base {
	public WebDriver driver;
	public Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {

		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("navigate to home page!");
	}

	@Test
	public void basePageNavigation() throws IOException, InterruptedException {
		LandingPage lp = new LandingPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES");
		log.info("Successfully validated text message!");
		Assert.assertTrue(true, lp.getTitle().getText());
		Assert.assertFalse(false, lp.getTitle().getText());
		// Thread.sleep(4000);

	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

}
