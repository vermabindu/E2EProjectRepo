package PageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageObjects.forgotPassword;

public class forgotPassword {
	public WebDriver driver;
	By emai_add = By.name("user[email]");
	By sendMeInst = By.cssSelector("[type='submit']");
	
	
	public forgotPassword(WebDriver driver)
	{
		this .driver = driver;
	}
	
	public WebElement getEmail()
	{
		return driver.findElement(emai_add);
	}
	
	public WebElement getsendMeInst()
	{
		return driver.findElement(sendMeInst);
	}
	
	
	

}
