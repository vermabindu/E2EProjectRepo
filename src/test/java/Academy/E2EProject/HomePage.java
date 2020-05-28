package Academy.E2EProject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.forgotPassword;

public class HomePage extends base {
	public WebDriver driver;
	public Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String Usrename, String Password, String text)
			throws IOException, InterruptedException {
		//beacuse we are repating the methods that's why we need to being the url in ide the dataProvider()
		//not the @beforeTest Annotaion.
		driver.get(prop.getProperty("url"));
		log.info("Enter in website!!");
		LandingPage lp = new LandingPage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		LoginPage lg=lp.getLogin();
		
		lg.getEmail().sendKeys(Usrename);
		log.info("Username enterd!!");
		lg.getpass().sendKeys(Password);
		log.info("Password enterd!!");
		// lg.getText()
		System.out.println(text);
		log.info("this is printed in log4j test. "+ text);
		lg.getlogIn().click();
		
		log.info("login button got clicked!");
		
		forgotPassword fp = lg.getforgotPassword();
		fp.getEmail().sendKeys("shjhjjhl");
		fp.getsendMeInst().click();
	}

	@AfterTest
	public void teardown() {
		driver.close();
	}

	@DataProvider
	public Object[][] getData() {
		// 0th row
		// Dataprovider array objects accept the size or the whole length of the rows or
		// columns,
		// and doesn't cocunt by index number 0,1,3. It has three size.
		Object[][] data = new Object[2][3];
		data[0][0] = "nonrestictedUser@qa.com";
		data[0][1] = "12234";
		data[0][2] = "Nonrestricted Usres!";
		// 1st row
		data[1][0] = "restictedUser@qa.com";
		data[1][1] = "567899";
		data[1][2] = "resticted Usres!";
		return data;

	}

}
