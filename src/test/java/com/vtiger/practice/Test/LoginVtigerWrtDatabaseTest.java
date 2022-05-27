package com.vtiger.practice.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginVtigerWrtDatabaseTest {
	public static void main(String[] args) throws SQLException {
		String url=null,username=null,password=null,timeouts=null,browsername=null;
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger","root","root");
		Statement statement = connection.createStatement();	
		ResultSet values = statement.executeQuery("select * from vtigerdata;");
		
		while(values.next()) {
			 url = values.getString("url");
			 username = values.getString("username");
			 password = values.getString("password");
			 timeouts = values.getString("timeouts");
			 browsername = values.getString("browsername");
		}
		long longtimeout = Long.parseLong(timeouts);
		WebDriver d=null;
		
		if(browsername.equalsIgnoreCase("edge"))
		{
		WebDriverManager.edgedriver().setup();
		d=new EdgeDriver();
		}
		else if(browsername.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			d=new ChromeDriver();
		}
		
		d.get(url);
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(longtimeout, TimeUnit.SECONDS);
		d.findElement(By.name("user_name")).sendKeys(username,Keys.TAB,password,Keys.ENTER);
		d.findElement(By.xpath("//a[text()='Contacts']")).click();
		d.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		String firstname="Venky";
		String lastname="mama";
		d.findElement(By.name("firstname")).sendKeys(firstname);
		d.findElement(By.name("lastname")).sendKeys(lastname);
		d.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		WebElement actualfirstname=d.findElement(By.id("dtlview_First Name"));
		WebElement actuallastname=d.findElement(By.id("dtlview_Last Name"));
		if(actualfirstname.getText().equalsIgnoreCase(firstname) && actuallastname.getText().equalsIgnoreCase(lastname))	
		{
			System.out.println("contact created successfully");
			System.out.println("TC PASS");
		}
		
		d.findElement(By.xpath("(//td[@class='small']/img)[1]")).click();
		d.findElement(By.xpath("//a[text()='Sign Out']")).click();	
		d.quit();
	}
}
