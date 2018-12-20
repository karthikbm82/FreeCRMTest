package com.crm.qa.testcases;

import org.apache.log4j.Logger;
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
	Logger log=Logger.getLogger(LoginPageTest.class);
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		log.info("Initialization is done ! ");
		loginPage=new LoginPage();
	}
	
	@Test()
	public void loginPageTitleTest()
	{
		String title=loginPage.validateLoginPageTitle();
		log.info("Login page title is : "+title);
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
	}
	
	@Test()
	public void crmLogoImageTest()
	{
		boolean flag=loginPage.validateCRMImage();
		log.info("Logo is present "+flag);
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
