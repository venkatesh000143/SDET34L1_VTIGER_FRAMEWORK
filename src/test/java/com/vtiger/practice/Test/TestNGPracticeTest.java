package com.vtiger.practice.Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SDET34L1.GenericLibrary.IconstanPathWay;
import com.SDET34L1.GenericLibrary.MSExcelUse;
 
public class TestNGPracticeTest {
	@Test(dataProvider ="loginData")
	public void practiceTest(String username,String password)
	{
		Reporter.log(username+"------->"+password,true);
	}
	
	
	@DataProvider
public Object[][] loginData() throws EncryptedDocumentException, IOException 
{
	    MSExcelUse.openExcelFile(IconstanPathWay.EXCELFILEPATH);
	   return MSExcelUse.getMultipleDataFromExcel("credentials");

}
}
