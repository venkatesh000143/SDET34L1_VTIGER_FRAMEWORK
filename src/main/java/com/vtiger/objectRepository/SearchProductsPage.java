package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET34L1.GenericLibrary.WebDriverUse;

public class SearchProductsPage {

	@FindBy(xpath="//input[@id='search_txt']")
	public WebElement searchTxt;
	
	@FindBy(name="search")
	public WebElement searchBtnt;
	
	
	public SearchProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void selectProduct(WebDriver driver, String productName)
	{
		WebDriverUse.switchToWindowBasedOnTitle(driver,"Products");
		searchTxt.sendKeys(productName);
		searchBtnt.click();
		driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
		WebDriverUse.switchToWindowBasedOnTitle(driver,"Campaign ");
		
	}
}
//String mainid = driver.getWindowHandle();
//driver.switchTo().window(mainid);
//
//WebDriverUse.switchToWindowBasedOnTitle(driver,"Products");
//
//driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(productname);
//driver.findElement(By.name("search")).click();	
//
////Thread.sleep(2000);
//WebDriverUse.explicitlyWait(driver,10);
//WebDriverUse.waitUntilElementToBeClickable(driver.findElement(By.xpath("//a[text()='"+productname+"']")));
//driver.findElement(By.xpath("//a[@id='1']")).click();
	
	
	