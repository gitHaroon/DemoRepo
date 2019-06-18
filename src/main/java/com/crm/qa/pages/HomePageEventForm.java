package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class HomePageEventForm extends TestBase{	
	
	@FindBy(xpath="//input[@id='title']/parent::td/parent::tr/preceding-sibling::tr/td/input[@type='submit']")
	WebElement btnSave;
	
	@FindBy(xpath="//input[@id='title']")
	WebElement frmTitle;
	
	@FindBy(xpath="//select[@name='category']")
	WebElement selCategory;
	
	@FindBy(xpath="//select[@name='assigned_to_user_id_src']")
	WebElement selUserFrom;
	
	@FindBy(xpath="//input[@value='==ADD==>']")
	WebElement addUserBtn;
	
	@FindBy(xpath="//input[@type='radio' and @value='Y']")
	WebElement radioConfirmedTrue;
	
	@FindBy(xpath="//input[@type='radio' and @value='N']")
	WebElement radioConfirmedFalse;
	
	@FindBy(xpath="//input[@type='checkbox' and @name='email_alert']")
	WebElement chkboxEmail;
	
	@FindBy(xpath="//input[@name='contact_lookup']")
	WebElement frmContact;
	
	@FindBy(xpath="//input[@name='client_lookup']")
	WebElement frmCompany;
	
	@FindBy(xpath="//input[@name='prospect_lookup']")
	WebElement frmDeal;
	
	@FindBy(xpath="//input[@name='task_lookup']")
	WebElement frmTask;
	
	@FindBy(xpath="//input[@name='case_lookup']")
	WebElement frmCase;
	
	@FindBy(xpath="//input[@id='tags']")
	WebElement frmTags;
	
	@FindBy(xpath="//textarea[@name='location']")
	WebElement frmLocation;
	
	public HomePageEventForm() {
		PageFactory.initElements(driver, this);
	}

	public void populateForm() {
		
		System.out.println("In populateForm");
		
		frmTitle.sendKeys("Doctor");
		
		Select drpCategory = new Select(selCategory);
		drpCategory.selectByVisibleText("Optional");
		
		selUserFrom.click();
		
		addUserBtn.click();
				
		radioConfirmedTrue.click();
		
		//Untoggle the email checkbox
		if (chkboxEmail.isSelected()) {
			chkboxEmail.click();
		}
		
		frmContact.sendKeys("HR contact");
		frmCompany.sendKeys("HR company");
		frmDeal.sendKeys("HR Deal");
		frmTask.sendKeys("HR Task");
		frmCase.sendKeys("HR Case");
		frmTags.sendKeys("HR Tags");
		frmLocation.sendKeys("HR Location");
		
		btnSave.click();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}	
}
