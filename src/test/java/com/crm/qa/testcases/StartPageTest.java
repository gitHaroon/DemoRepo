package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.StartPage;

public class StartPageTest extends TestBase{
	
	StartPage startPage;
	LoginPage loginPage;
	
	public StartPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialisation();
		startPage = new StartPage();		
	}
	
	@Test
	public void clickLognBtn() {
		loginPage = startPage.clickLoginBtn();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
