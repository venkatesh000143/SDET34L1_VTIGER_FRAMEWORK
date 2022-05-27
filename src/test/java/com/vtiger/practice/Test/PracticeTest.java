package com.vtiger.practice.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeTest {
public static void main(String[] args) throws IOException {
	FileInputStream fis = new FileInputStream("./src/test/resources/atappcommondata.properties");
	Properties pobj=new Properties();
	pobj.load(fis);
	String url= pobj.getProperty("url");
	
	FileInputStream fis1 = new FileInputStream("./src/test/resources/vtigerdata.xlsx");
	Workbook wbook = WorkbookFactory.create(fis1);
	Sheet sheet = wbook.getSheet("Automationtestingapp");
	Row row = sheet.getRow(2);
	Cell cell = row.getCell(1);
	DataFormatter format = new DataFormatter();
	String description = format.formatCellValue(cell);


	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get(url);
	driver.findElement(By.xpath("//button[@id='btn2']")).click();
	driver.findElement(By.xpath("//a[text()='SwitchTo']")).click();
	driver.findElement(By.xpath("//a[text()='Frames']")).click();
	driver.findElement(By.xpath("//a[text()='Single Iframe ']")).click();
	driver.findElement(By.xpath("//a[text()='Iframe with in an Iframe']")).click();


	
}
}
