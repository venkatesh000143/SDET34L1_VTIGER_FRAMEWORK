package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET34L1.GenericLibrary.WebDriverUse;

public class SearchOrganizationsPage {
	@FindBy(xpath="//input[@id='search_txt']")
	public WebElement searchTxt;
	
	@FindBy(name="search")
	public WebElement searchBtnt;
	
	
	public SearchOrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void selectOrganization(WebDriver driver, String organizationName)
	{
		WebDriverUse.switchToWindowBasedOnTitle(driver,"Accounts");
		searchTxt.sendKeys(organizationName);
		searchBtnt.click();
		driver.findElement(By.xpath("//td/a[text()='"+organizationName+"']")).click();
		WebDriverUse.switchToWindowBasedOnTitle(driver,"Contacts");
}
}
	
//	WebDriverUse.switchToWindowBasedOnTitle(driver, "Accounts");
//	
//	driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(organizationdata);
//	driver.findElement(By.name("search")).click();	
//
//	WebDriverUse.explicitlyWait(driver,10);
//	WebDriverUse.waitUntilElementToBeClickable(driver.findElement(By.xpath("//td/a[text()='"+organizationdata+"']")));
//
//	driver.findElement(By.xpath("//a[contains(@onclick,'set_return_contact_address')]")).click();
//	
//	WebDriverUse.switchToWindowBasedOnTitle(driver, "Contacts");