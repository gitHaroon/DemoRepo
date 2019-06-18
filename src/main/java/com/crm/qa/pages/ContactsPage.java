package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[@class='datacardtitle' and contains(text(), 'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(name="title")
	WebElement title;	
	
	@FindBy(id="first_name")
	WebElement first_name;
	
	@FindBy(id="surname")
	WebElement surname;	
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement companyName;
	
	@FindBy(xpath="//input[@value='Load From Company']//following-sibling::input[@value='Save']")
	WebElement saveBtn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContacts(String name) {
		String xpathName = "//a[@_name='" + name + "']//parent::td//preceding-sibling::td//input[@type='checkbox']";
		WebElement contactChkBox = driver.findElement(By.xpath(xpathName));
		contactChkBox.click();
	}
	
	public void deleteContact(String name) {
		String xpathName = "//a[@_name='" + name + "']//parent::td/following-sibling::td[last()]/a[last()]/i[@title='Delete']";
		WebElement deleteIcon = driver.findElement(By.xpath(xpathName));
		deleteIcon.click();
	}
	
	public void createNewContact(String sTitle, String firstName, String lastName, String compName) {
		
		Select drpTitle = new Select(title);
		drpTitle.selectByVisibleText(sTitle);
		
		first_name.sendKeys(firstName);
		surname.sendKeys(lastName);
		companyName.sendKeys(compName);		
		saveBtn.click();
	}

}
