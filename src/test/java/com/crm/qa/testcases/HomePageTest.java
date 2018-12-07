package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("un"), prop.getProperty("pwd"));
	}
	
	@Test()
	public void verifyHomePageTitleTest()
	{
		String homePageTitle=homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home page title did not match");
	}
	
	@Test()
	public void verifyUserNameTest()
	{
		testUtil.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test()
	public void verifyContactsLinkTest()
	{
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
