package Academy.E2EProject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageObjects.forgotPassword;

public class LoginPage {
	public WebDriver driver;
	By emai_add = By.name("user[email]");
	By pass = By.name("user[password]");
	By logIn = By.xpath("//input[@class='btn btn-primary btn-md login-button']");
	By forgotPassword = By.cssSelector("[href*='password/new']");
	
	
	public LoginPage(WebDriver driver)
	{
		this .driver = driver;
	}
	
	public WebElement getEmail()
	{
		return driver.findElement(emai_add);
	}
	public WebElement getpass()
	{
		return driver.findElement(pass);
	}
	public WebElement getlogIn()
	{
		return driver.findElement(logIn);
	}
	public PageObjects.forgotPassword getforgotPassword()
	{
		driver.findElement(forgotPassword).click();
		forgotPassword fp = new forgotPassword(driver);
		return fp;
	}
	
	
	

}
