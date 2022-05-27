package com.vtiger.practice.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginWithMultipleCredentialsTest {
public static void main(String[] args) throws IOException {
	
	FileInputStream fis1 = new FileInputStream("./src/test/resources/commondata.properties");
	Properties property=new Properties();
	property.load(fis1);
	String url = property.getProperty("url");
	String timeouts = property.getProperty("timeouts");
	long longtimeout = Long.parseLong(timeouts);
	
	FileInputStream fis=new FileInputStream("./src/test/resources/vtigerdata.xlsx");
	Workbook wbook = WorkbookFactory.create(fis);
	Sheet sheet = wbook.getSheet("credentials");
	
	Object[][] arr=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for(int i=1;i<sheet.getLastRowNum();i++)
	{
		for(int j=0;j<sheet.getRow(i).getLastCellNum();j++)
		{
			arr[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
		}
	String username =(String) arr[i][0];
	String password =(String) arr[i][1];
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(longtimeout, TimeUnit.SECONDS);
	driver.findElement(By.name("user_name")).sendKeys(username,Keys.TAB,password,Keys.ENTER);
	if(driver.getTitle().contains("Home"))
	{
		WebElement administrationicon = driver.findElement(By.xpath("//td[@class='small']//img[@src='themes/softed/images/user.PNG']"));
		Actions act1=new Actions(driver);
		act1.moveToElement(administrationicon).perform();
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		System.out.println("Login page opened");
		break;
	}
	driver.quit();
	}
}
}
