package com.vtiger.practice.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.SDET34L1.GenericLibrary.DocumentUtility;
import com.SDET34L1.GenericLibrary.IconstanPathWay;
import com.SDET34L1.GenericLibrary.JavaUse;
import com.SDET34L1.GenericLibrary.MSExcelUse;
import com.SDET34L1.GenericLibrary.WebDriverUse;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProvideDataInExcelSheetTest {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		JavaUse ju=new JavaUse();
		WebDriver driver=null;
		DocumentUtility.openPropertyFile(IconstanPathWay.PROPERTYFILEPATH);
	    MSExcelUse.openExcelFile(IconstanPathWay.EXCELFILEPATH);

		String url = DocumentUtility.getDataFromPropertiesFile("url");
		String username = DocumentUtility.getDataFromPropertiesFile("username");
		String password = DocumentUtility.getDataFromPropertiesFile("password");
		String timeouts = DocumentUtility.getDataFromPropertiesFile("timeouts");
		String browsername = DocumentUtility.getDataFromPropertiesFile("browsername");
		
	    long longtimeout = ju.stringtoLong(timeouts);
	    int randomnumber = ju.getRandomnumber(1000);

	    String organizationname = MSExcelUse.getDataFromExcel("Organizations",2, 1)+randomnumber;
			
			switch(browsername)
			{
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				break;
			case "Edge":
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
				break;
			}
				
				WebDriverUse.navigateApp(url, driver);
				WebDriverUse.browserSetting(longtimeout, driver);
				//login to the app
				driver.findElement(By.name("user_name")).sendKeys(username,Keys.TAB,password,Keys.ENTER);
				Workbook wbook = null;
				if(driver.getTitle().contains("Home"))
				{
					wbook.getSheet("Organizations").getRow(10).createCell(4).setCellValue("Homepage is displayed");
					wbook.getSheet("Organizations").getRow(10).createCell(5).setCellValue("PASS");
				}	
				driver.findElement(By.xpath("//a[text()='Organizations']")).click();
				if(driver.getTitle().contains("Organizations"))
				{
					wbook.getSheet("Organizations").getRow(11).createCell(4).setCellValue("organization page is displayed");
					wbook.getSheet("Organizations").getRow(11).createCell(5).setCellValue("PASS");
				}	
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				if(driver.getTitle().contains("Organizations"))
				{
					wbook.getSheet("Organizations").getRow(12).createCell(4).setCellValue("create organization page is displayed");
					wbook.getSheet("Organizations").getRow(12).createCell(5).setCellValue("PASS");
				}	
				driver.findElement(By.name("accountname")).sendKeys(organizationname);
				driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();
				if(driver.getTitle().contains("Organizations"))
				{
					wbook.getSheet("Organizations").getRow(13).createCell(4).setCellValue("create organization page is displayed");
					wbook.getSheet("Organizations").getRow(13).createCell(5).setCellValue("PASS");
				}	
				String actualorganizationname=driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
			
				if(organizationname.equals(actualorganizationname))
				{
					wbook.getSheet("Organizations").getRow(14).createCell(4).setCellValue("create organization validation done");
					wbook.getSheet("Organizations").getRow(14).createCell(5).setCellValue("PASS");
				}
				else
				{
					System.out.println("TC FAIL");
				}
			WebDriverWait wait=new WebDriverWait(driver,15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='crmbutton small delete'])[1]")));
			driver.findElement(By.xpath("(//td[@class='small']/img)[1]")).click();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			if(driver.getTitle().contains("vtiger"))
			{
				wbook.getSheet("Organizations").getRow(15).createCell(4).setCellValue("login page displayed");
				wbook.getSheet("Organizations").getRow(15).createCell(5).setCellValue("PASS");
			}
			FileOutputStream fos=new FileOutputStream("./src/test/resources/vtigerdata.xlsx");
			wbook.write(fos);
			wbook.close();
			driver.close();
	}
}
