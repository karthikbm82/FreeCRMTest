package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage=new LoginPage();
	}
	
	@Test()
	public void loginPageTitleTest()
	{
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "#12 Free CRM software in the cloud for sales and service");
	}
	
	@Test()
	public void crmLogoImageTest()
	{
		boolean flag=loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	@Test()
	public void loginTest() throws InterruptedException
	{
		homePage=loginPage.login(prop.getProperty("un"), prop.getProperty("pwd"));
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
