//package com.vtiger.practice.Test;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//
//import com.SDET34L1.GenericLibrary.DocumentUtility;
//import com.SDET34L1.GenericLibrary.IconstanPathWay;
//import com.SDET34L1.GenericLibrary.JavaUse;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class CreateProductsWrtCommonDataByPropertiesFileTest {
//	public static void main(String[] args) throws IOException {
//		FileInputStream fis= new FileInputStream("./src/test/resources/vtigerdata.xlsx");
//		Workbook wbook = WorkbookFactory.create(fis);
//		Sheet sheet = wbook.getSheet("products");
//		Row row = sheet.getRow(2);
//		Cell cell= row.getCell(1);
//		String productname= cell.getStringCellValue();
//		
//		JavaUse ju=new JavaUse();
//		DocumentUtility.openPropertyfile(IconstanPathWay.PROPERTYFILEPATH);
//		String url = DocumentUtility.getDataFromPropertiesFile("url");
//		String username = DocumentUtility.getDataFromPropertiesFile("username");
//		String password = DocumentUtility.getDataFromPropertiesFile("password");
//		String timeouts = DocumentUtility.getDataFromPropertiesFile("timeouts");
//		String browsername = DocumentUtility.getDataFromPropertiesFile("browsername");
//		
//	    long longtimeout = ju.stringtoLong(timeouts);
//	    int randomnumber = ju.getRandomnumber(1000);
//		WebDriver driver=null;
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
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.get(url);
//		driver.findElement(By.name("user_name")).sendKeys(username);
//		driver.findElement(By.name("user_password")).sendKeys(password);
//		driver.findElement(By.id("submitButton")).click();
//		driver.findElement(By.xpath("//a[text()='Products']")).click();
//		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
//		driver.findElement(By.name("productname")).sendKeys(productname);
//		driver.findElement(By.name("button")).click();
//		WebElement actualproductname = driver.findElement(By.id("dtlview_Product Name"));
//		if(actualproductname.getText().equals(productname))
//		{
//			System.out.println("product created successfully");
//		}
//		driver.findElement(By.xpath("(//img[contains(@style,'padding:')])[1]")).click();
//		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
//		driver.quit();
//	}	
//
//
//}
