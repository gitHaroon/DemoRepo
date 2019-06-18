package com.crm.qa.testcases;

import java.util.ArrayList;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.StartPage;
import com.crm.qa.pages.ClassicLoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	StartPage startPage;	
	LoginPage loginPage;
	ClassicLoginPage classicLoginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialisation();
		startPage = new StartPage();
		Thread.sleep(2000);
		loginPage = startPage.clickLoginBtn();
		Thread.sleep(2000);
		classicLoginPage = loginPage.classicLoginPageClick();
		Thread.sleep(2000);
		homePage = classicLoginPage.clickLoginBtn(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
	}	
	
	@Test(priority=1)
	public void verifyContactsLabelTest() {
		contactsPage = homePage.clickOnContactsLink();
		Assert.assertTrue(contactsPage.verifyContactsLabel());
	}
	
	@Test(priority=2)
	public void clickOnContactCheckBoxTest() throws InterruptedException {
		contactsPage = homePage.clickOnContactsLink();
		contactsPage.selectContacts("H R");
		contactsPage.selectContacts("H S");
	}
	
	@Test(priority=3, dataProvider="getTestData")
	public void createNewContactsTest(String contactTitle, String contactFirstName, String contactLastName, String contactCompany) {
		contactsPage = homePage.clickOnNewContactLink();
		contactsPage.createNewContact(contactTitle, contactFirstName, contactLastName, contactCompany);
	}
	
	@Test(priority=4)
	public void deleteContact() throws InterruptedException {
		contactsPage = homePage.clickOnContactsLink();
		
		contactsPage.deleteContact("John Jones");
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		
		contactsPage.deleteContact("John Foreman");
		Thread.sleep(4000);
		driver.switchTo().alert().accept();	
		
		Thread.sleep(4000);
	}	
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
