package com.vtiger.practice.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.SDET34L1.GenericLibrary.WebDriverUse;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorTest {
public static void main(String[] args) throws IOException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	WebDriverUse.intilizeJs(driver);
	WebDriverUse.navigateApplicationThroughJs("http://localhost:8888");
	driver.manage().window().maximize();
	WebDriverUse.enterDataThroughJs(driver.findElement(By.name("user_name")),"admin");
	WebDriverUse.enterDataThroughJs(driver.findElement(By.name("user_password")),"root");
	WebDriverUse.clickThroughJs( driver.findElement(By.id("submitButton")));
	WebDriverUse.scrollTillElement(driver.findElement(By.xpath("//b[contains(.,'Upcoming Activities')]")));
	
	String fileName=new JavaScriptExecutorTest().getClass().getName();
	WebDriverUse.takeScreenShot(fileName, driver);
}
}
