package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName="Sheet1";
	
	public ContactsPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		initialization();
		testUtil=new TestUtil();
		contactsPage=new ContactsPage();
		loginPage=new LoginPage();
		homePage=loginPage.login(prop.getProperty("un"), prop.getProperty("pwd"));
		testUtil.switchToFrame();
		contactsPage=homePage.clickOnContactsLink();
	}
	
	@Test()
	public void verifyContactsPageLabelTest()
	{
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	}
	
	@Test()
	public void selectSingleContactsTest()
	{
		contactsPage.selectContactsByName("b a");
	}
	
	@Test()
	public void selectMultipleContactsTest()
	{
		contactsPage.selectContactsByName("b a");
		contactsPage.selectContactsByName("b h");
	}
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(dataProvider="getCRMTestData")
	public void validateCreateNewContact(String title,String firstName,String lastName,String company)
	{
		homePage.clickonNewContactLink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "efi");
		contactsPage.createNewContact(title, firstName, lastName, company);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
