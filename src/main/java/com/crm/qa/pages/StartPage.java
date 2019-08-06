package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class StartPage extends TestBase{
	
	
	
	@FindBy(xpath="//span[contains(text(),'Log In')]")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(), 'Classic CRM')]")
	WebElement classicCRMLink;
	
	public StartPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickLoginBtn() {
						
		loginBtn.click();
		return new LoginPage();
	}
	
}
