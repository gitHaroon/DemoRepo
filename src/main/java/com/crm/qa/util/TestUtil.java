package com.crm.qa.util;

import java.util.ArrayList;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.Xls_Reader;

public class TestUtil extends TestBase{
	
	public static long pageLoadWaitTimeOut = 40;
	public static long implicitWaitTimeOut = 30;
	
	static Xls_Reader reader;
	
	public static void switchToFrame() {
		driver.switchTo().frame("mainpanel");
	}	
	
	public static ArrayList<Object[]> getDataFromExcel() {
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			reader = new Xls_Reader("C:\\Eclipse\\HRTEST2\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\ContactInfo.xlsx");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int rowNum = 2; rowNum <= reader.getRowCount("ContactInfo"); rowNum++) {
			
			String title = reader.getCellData("ContactInfo", "Title", rowNum);
			String firstName = reader.getCellData("ContactInfo", "FirstName", rowNum);
			String lastName = reader.getCellData("ContactInfo", "LastName", rowNum);
			String company = reader.getCellData("ContactInfo", "Company", rowNum);
			
			Object ob[] = {title, firstName, lastName, company};			
			myData.add(ob);			
		}		
		return myData;
	}

	public static void takeScreenshotAtEndOfTest() {
		// TODO Auto-generated method stub
		
	}	
}
