//package com.vtiger.practice.Test;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
//import org.apache.poi.EncryptedDocumentException;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import com.SDET34L1.GenericLibrary.DocumentUtility;
//import com.SDET34L1.GenericLibrary.IconstanPathWay;
//import com.SDET34L1.GenericLibrary.JavaUse;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class CreateOrganizationWithTestData {
//	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
//		JavaUse ju=new JavaUse();
//		DocumentUtility.openPropertyfile(IconstanPathWay.PROPERTYFILEPATH);
//		String url = DocumentUtility.getDataFromPropertiesFile("url");
//		String username = DocumentUtility.getDataFromPropertiesFile("username");
//		String password = DocumentUtility.getDataFromPropertiesFile("password");
//		String timeouts = DocumentUtility.getDataFromPropertiesFile("timeouts");
//		String browsername = DocumentUtility.getDataFromPropertiesFile("browsername");
//	    long longtimeout = ju.stringtoLong(timeouts);
//	   
//		Random r=new Random();
//		int num=r.nextInt(1000);
//		
//		FileInputStream fis= new FileInputStream("./src/test/resources/vtigerdata.xlsx");
//		Workbook wbook = WorkbookFactory.create(fis);
//		Sheet sheet = wbook.getSheet("Organizations");
//		Row row = sheet.getRow(2);
//		Cell cell= row.getCell(1);
//		String orgname= cell.getStringCellValue()+num;
//		
//	    WebDriver driver=null;
//		switch(browsername)
//		{
//		case "chrome":
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver();
//			break;
//		case "Edge":
//			WebDriverManager.edgedriver().setup();
//			driver=new EdgeDriver();
//			break;
//		}
//		driver.get(url);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.findElement(By.name("user_name")).sendKeys(username,Keys.TAB,password,Keys.ENTER);
//		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
//		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
//		driver.findElement(By.name("accountname")).sendKeys(orgname);
//		driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();
//		String actualorgname=driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
//		
//		if(orgname.equals(actualorgname))
//		{
//			System.out.println("Organization created successfully");
//			System.out.println("TC PASSED");
//		}
//		else
//		{
//			System.out.println("TC FAILED");
//		}
//		WebDriverWait wait=new WebDriverWait(driver,15);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@class='crmbutton small delete'])[1]")));
//		driver.findElement(By.xpath("(//td[@class='small']/img)[1]")).click();
//		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
//		driver.quit();
//}
//
//}
