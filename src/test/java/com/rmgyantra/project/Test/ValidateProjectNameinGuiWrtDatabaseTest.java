    
package com.rmgyantra.project.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SDET34L1.GenericLibrary.DatasetUtility;
import com.SDET34L1.GenericLibrary.DocumentUtility;
import com.SDET34L1.GenericLibrary.IconstanPathWay;
import com.SDET34L1.GenericLibrary.JavaUse;
import com.SDET34L1.GenericLibrary.MSExcelUse;
import com.SDET34L1.GenericLibrary.WebDriverUse;
import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateProjectNameinGuiWrtDatabaseTest {

	public static void main(String[] args) throws SQLException, IOException {
		JavaUse ju=new JavaUse();
		DocumentUtility.openPropertyFile(IconstanPathWay.RMGYANTRA_PROPERTYFILE_PATH);
		MSExcelUse.openExcelFile(IconstanPathWay.RMGYANTRA_EXCELFILE_PATH);
		int randomnumber=ju.getRandomnumber(1000);
		String projectname=MSExcelUse.getDataFromExcel("projects", 1, 1);
		String projectid="TY_PROJ_205"+randomnumber;
		System.out.println(projectname);
		DatasetUtility.openDBConnection(IconstanPathWay.DATABASEURL+DocumentUtility.getDataFromPropertiesFile("dbName"),DocumentUtility.getDataFromPropertiesFile("dBUserName"),DocumentUtility.getDataFromPropertiesFile("dBPassWord"));
		DatasetUtility.setDataInDataBase("insert into project values('"+projectid+"','venky123','28/04/2022','+projectname+','Going',0)");
		DatasetUtility.closeDBConnection();
		
//		
//		Driver driver=new Driver();
//		DriverManager.registerDriver(driver);
//		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
//		Statement statement = connection.createStatement();
//		statement.executeUpdate("insert into project values(' TY_PROJ_205','venky123','28/04/2022','+projectname+','Going',0)");
//		connection.close();
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver1=new ChromeDriver();
		WebDriverUse.browserSetting(10, driver1);
		WebDriverUse.navigateApp("http://localhost:8084/", driver1);
		driver1.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
		driver1.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999",Keys.ENTER);
		driver1.findElement(By.xpath("//a[text()='Projects']")).click();
		
		List<WebElement> listofprojectnames = driver1.findElements(By.xpath("//tbody/tr/td"));
		for( WebElement project:listofprojectnames)
		{
			if(project.getText().equals(projectname))
			{
				System.out.println("project name is visible in GUI");
				System.out.println("TC PASSED");
				break;
			}
		}
		WebDriverUse.quitBrowser(driver1);
	
	}
	
	
}
