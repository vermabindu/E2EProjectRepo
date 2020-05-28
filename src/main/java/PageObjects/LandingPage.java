package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Academy.E2EProject.LoginPage;


public class LandingPage {
	public WebDriver driver; 
	By signIn = By.xpath("//span[text()='Login']");
	By title = By.xpath("//h2[text()='Featured Courses']");
	//By navigation = By.className("nav navbar-nav navbar-right");
	By navigation = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		
	}

	public LoginPage getLogin()
	{
		driver.findElement(signIn).click();
		LoginPage lg = new LoginPage(driver);
		return lg;
	}
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	public WebElement getNavigation()
	{
		return driver.findElement(navigation);
	}

}
