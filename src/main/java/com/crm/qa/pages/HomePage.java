package com.crm.qa.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase{
	
	private String today;

	@FindBy(xpath="//a[@title='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[@title='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[@title='Tasks']")
	WebElement tasksLink;	
	
	@FindBy(xpath="//a[contains(text(), 'Logout')]")
	WebElement logoutLink;		
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyUserName(String name) {
		String xpathUserName = "//td[contains(text(), 'User: " + name + "')]";
		System.out.println(xpathUserName);
		TestUtil.switchToFrame();
		WebElement userName = driver.findElement(By.xpath(xpathUserName));
		return userName.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		TestUtil.switchToFrame();
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		TestUtil.switchToFrame();
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		TestUtil.switchToFrame();
		tasksLink.click();
		return new TasksPage();
	}
	
	public ContactsPage clickOnNewContactLink() {

		try {
			Actions action = new Actions(driver);
			TestUtil.switchToFrame();
			action.moveToElement(contactsLink).build().perform();			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@title='New Contact']")).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ContactsPage();
	}
	
	public void clickOnCurrentDate(String eventTime) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		
		String date1 = dateFormat.format(date);
		String tempXpath;
		System.out.println(date1);
		
		today = getCurrentDay();
		System.out.println("today = " + today);		
		
		TestUtil.switchToFrame();
		WebElement calWidget = driver.findElement(By.xpath("//div[@id = 'homebox_CALENDAR']/div[@id='crmcalendar']"));
		
		List<WebElement> columns = calWidget.findElements(By.tagName("td"));
		
		for (WebElement cells : columns) {

			if (cells.getText().equals(today)) {
				cells.click();
				break;
			}
			
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tempXpath = "//a[@name='" + eventTime + "']/parent::td/following-sibling::td[1]";
		
		System.out.println("tempXpath = " + tempXpath);
		
		WebElement tblRow = driver.findElement(By.xpath(tempXpath));
		tblRow.click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
				
	}
	
	private String getCurrentDay() {
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println("Today int: " + todayInt + "\n");
		
		String todayStr = Integer.toString(todayInt);
		System.out.println("Today Str: " + todayStr + "\n");
		
		return todayStr;		
	}	
	
	public void logoutClick() {
		logoutLink.click();
	}	
	
}
