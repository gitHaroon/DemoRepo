package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ClassicLoginPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.StartPage;
import com.crm.qa.util.TestUtil;

public class ClassicLoginPageTest extends TestBase{
	
	StartPage startPage;
	LoginPage loginPage;
	ClassicLoginPage classicLoginPage;
	HomePage homePage;
	
	public ClassicLoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialisation();
		startPage = new StartPage();
		loginPage = startPage.clickLoginBtn();
		classicLoginPage = loginPage.classicLoginPageClick();
	}
	
	@Test(priority=1)
	public void validateTitle() {
		String title = classicLoginPage.validateClassicLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO Log In Screen");
	}
	
	@Test(priority=2)
	public void validateImagedisplayed() throws InterruptedException {
		Boolean lDisplayed = classicLoginPage.validateImageExists();
		Assert.assertTrue(lDisplayed);		
	}
	
	@Test(priority=3)
	public void clickLogin() throws InterruptedException {
		homePage = classicLoginPage.clickLoginBtn(prop.getProperty("username"), prop.getProperty("password"));		
		Thread.sleep(5000);				
		Assert.assertNotNull(homePage);
		TestUtil.switchToFrame();
		homePage.logoutClick();				
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
