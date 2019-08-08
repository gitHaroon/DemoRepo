package com.crm.qa.testcases;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ClassicLoginPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.HomePageEventForm;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.StartPage;

public class HomePageTest extends TestBase{
	
	StartPage startPage;
	LoginPage loginPage;
	ClassicLoginPage classicLoginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	HomePageEventForm homePageEventForm;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialisation();
		startPage = new StartPage();
		loginPage = startPage.clickLoginBtn();
		classicLoginPage = loginPage.classicLoginPageClick();
		homePage = classicLoginPage.clickLoginBtn(prop.getProperty("username"), prop.getProperty("password"));
	}
	
//	@Test(priority=1)
//	public void verifyTitle() {
//		String title = homePage.verifyHomePageTitle();
//		Assert.assertEquals(title, "CRMPRO");		
//	}
//	
//	@Test(priority=2)
//	public void verifyUserNameIsDisplayed() {
//		boolean b = homePage.verifyUserName("h h");
//		Assert.assertTrue(b);
//	}	
//	
//	@Test(priority=3)
//	public void verifyContactLink() {
//		contactsPage = homePage.clickOnContactsLink();
//		Assert.assertNotNull(contactsPage);
//	}	
//	
//	@Test(priority=4)
//	public void clickOnNewContactLinkTest() throws InterruptedException {
//		contactsPage = homePage.clickOnNewContactLink();
//		Assert.assertNotNull(contactsPage);		
//	}	
	
	@Test(priority = 5)
	public void testClickOnCurrentDate() {
		homePage.clickOnCurrentDate("02:00PM");
		homePageEventForm = new HomePageEventForm();
		
		homePageEventForm.populateForm();
		
		homePageEventForm.deleteEvent();
		
	}		
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
