package com.vtiger.practice.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
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

import com.SDET34L1.GenericLibrary.DocumentUtility;
import com.SDET34L1.GenericLibrary.IconstanPathWay;
import com.SDET34L1.GenericLibrary.JavaUse;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreatecontactsTestDataTest {


	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		JavaUse ju=new JavaUse();
		DocumentUtility.openPropertyFile(IconstanPathWay.PROPERTYFILEPATH);
		String url = DocumentUtility.getDataFromPropertiesFile("url");
		String username = DocumentUtility.getDataFromPropertiesFile("username");
		String password = DocumentUtility.getDataFromPropertiesFile("password");
		String timeouts = DocumentUtility.getDataFromPropertiesFile("timeouts");
		String browsername = DocumentUtility.getDataFromPropertiesFile("browsername");
		
	    long longtimeout = ju.stringtoLong(timeouts);
	    int randomnumber = ju.getRandomnumber(1000);
	    
		WebDriver driver=null;
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
			
			FileInputStream fis= new FileInputStream("./src/test/resources/vtigerdata.xlsx");
			Workbook wbook = WorkbookFactory.create(fis);
			Sheet sheet = wbook.getSheet("contacts");
			Row row = sheet.getRow(2);
			Cell cell1= row.getCell(1);
			String contactlastname= cell1.getStringCellValue()+randomnumber;
		
			driver.get(url);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(longtimeout, TimeUnit.SECONDS);
			//login to the app
			driver.findElement(By.name("user_name")).sendKeys(username,Keys.TAB,password,Keys.ENTER);
			if(driver.getCurrentUrl().contains("Home"))
			{
				wbook.getSheet("contacts").getRow(10).createCell(4).setCellValue("Homepage is displayed");
				wbook.getSheet("contacts").getRow(10).createCell(5).setCellValue("PASS");
			}
			//click on contacts
			driver.findElement(By.xpath("//a[text()='Contacts']")).click();
			if(driver.getCurrentUrl().contains("Contacts"))
			{
				wbook.getSheet("contacts").getRow(11).createCell(4).setCellValue("contact page is displayed");
				wbook.getSheet("contacts").getRow(11).createCell(5).setCellValue("PASS");

			}
			//click on create new contact
			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
			if(driver.getTitle().contains("Contacts"))
			{
				wbook.getSheet("contacts").getRow(12).createCell(4).setCellValue("contacting contact page is displayed");
				wbook.getSheet("contacts").getRow(12).createCell(5).setCellValue("PASS");
			}
			//Provide lastname and save
			driver.findElement(By.name("lastname")).sendKeys(contactlastname);
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			if(driver.getTitle().contains("Contacts"))
			{
				wbook.getSheet("contacts").getRow(13).createCell(4).setCellValue(" contact information page is displayed");
				wbook.getSheet("contacts").getRow(13).createCell(5).setCellValue("PASS");

			}
			//validation
			String actualcontactlastname = driver.findElement(By.id("dtlview_Last Name")).getText();
			if(contactlastname.equals(actualcontactlastname))
			{
				wbook.getSheet("contacts").getRow(14).createCell(4).setCellValue("contact validation done successfully");
				wbook.getSheet("contacts").getRow(14).createCell(5).setCellValue("PASS");
				System.out.println("TC PASS");
			}
			else {
				System.out.println(contactlastname+":"+actualcontactlastname);
			}
			
			//signout
			driver.findElement(By.xpath("(//img[contains(@style,'padding:')])[1]")).click();
			driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
			if(driver.getTitle().contains("vtiger"))
			{
				wbook.getSheet("contacts").getRow(15).createCell(4).setCellValue(" login page is displayed");
				wbook.getSheet("contacts").getRow(15).createCell(5).setCellValue("PASS");
			}
		FileOutputStream fos=new FileOutputStream("./src/test/resources/vtigerdata.xlsx");
		wbook.write(fos);
		wbook.close();
		driver.close();

		
	}
}
