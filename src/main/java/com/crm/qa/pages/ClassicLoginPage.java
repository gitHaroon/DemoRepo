package com.crm.qa.pages;

import org.apache.poi.hssf.record.UserSViewBegin;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ClassicLoginPage extends TestBase{
	
	@FindBy(xpath="//img[@alt='CRM PRO']")
	WebElement imgCRMPRO;
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit' and @value='Login']")
	WebElement loginBtn;
	
	public ClassicLoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateClassicLoginPageTitle() {		
		return driver.getTitle();
	}
	
	public Boolean validateImageExists() throws InterruptedException {
		Thread.sleep(3000);
		return imgCRMPRO.isDisplayed();
	}
	
	public HomePage clickLoginBtn(String user, String pwd) {
		
		username.sendKeys(Keys.CLEAR);
		username.sendKeys(user);
		password.sendKeys(Keys.CLEAR);
		password.sendKeys(pwd);
		
		loginBtn.click();
		
		return new HomePage();
	}	

}
