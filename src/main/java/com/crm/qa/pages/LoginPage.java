package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase
{
	
	//Page Factory or OR
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[@href='https://www.freecrm.com/register/']")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement crmLogo;
	
	//Initializing the Page Objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMImage()
	{
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un,String pwd) throws InterruptedException
	{
		Thread.sleep(20000);
		username.sendKeys(un);
		//Thread.sleep(5000);
		password.sendKeys(pwd);
		//Thread.sleep(5000);
		loginBtn.click();
		
		return new HomePage();
	}
}
