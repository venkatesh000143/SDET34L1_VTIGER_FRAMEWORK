 package com.rmgyantra.project.Test;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.SDET34L1.GenericLibrary.DatasetUtility;
import com.SDET34L1.GenericLibrary.DocumentUtility;
import com.SDET34L1.GenericLibrary.IconstanPathWay;
import com.SDET34L1.GenericLibrary.JavaUse;
import com.SDET34L1.GenericLibrary.WebDriverUse;
import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class ValidateProjectNameinDatabaseEWrtGuiTest {
public static void main(String[] args) throws SQLException, IOException  {
	JavaUse ju=new JavaUse();
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("http://localhost:8084/");
	driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
	driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999",Keys.ENTER);
	driver.findElement(By.xpath("//a[text()='Projects']")).click();
	driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
	String projectname="TESTYANTRA"+ju.getRandomnumber(1000);
	driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(projectname,Keys.TAB,"venky");
	WebElement dropdown=driver.findElement(By.xpath("(//select[@name='status'])[2]"));
	Select s=new Select(dropdown);
	s.selectByVisibleText("On Goging");
	driver.findElement(By.cssSelector("[value='Add Project']")).click();
	
	DocumentUtility.openPropertyFile(IconstanPathWay.RMGYANTRA_PROPERTYFILE_PATH);
	DatasetUtility.openDBConnection(IconstanPathWay.DATABASEURL+DocumentUtility.getDataFromPropertiesFile("dbName"), DocumentUtility.getDataFromPropertiesFile("dBUserName"),DocumentUtility.getDataFromPropertiesFile("dBPassWord"));
	boolean status=DatasetUtility.validateDataInDataBase("select project_name from project;", "project_name", projectname);
	if(status==true)
	{
		System.out.println("TC PASS");
	}
	else
	{
		System.out.println("TC FAIL");

	}
	DatasetUtility.closeDBConnection();
	WebDriverUse.quitBrowser(driver);
//	Connection connection=null;
//	Driver driver1;
//	try {
//		driver1 = new Driver();
//		DriverManager.registerDriver(driver1);
//		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
//		Statement statement=connection.createStatement();
//		ResultSet result=statement.executeQuery("select * from project");
//		while(result.next())
//		{
//			if(result.getString("project_name").equals(projectname))
//			{
//			System.out.println("project name is present in database");
//			System.out.println("TC PASSEDD");
//			}	
//		}
//	} catch (SQLException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	
//	finally {
//		connection.close();
//	}
//	driver.quit();

}	

}



