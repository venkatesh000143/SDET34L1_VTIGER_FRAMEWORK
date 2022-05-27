package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET34L1.GenericLibrary.WebDriverUse;

public class HomePage {
	
	@FindBy(xpath="//a[text()='More']")
	public WebElement moreDropDown;
	
	@FindBy(name="Campaigns")
	public WebElement campaingnsTab;
	
	@FindBy(xpath="//td[@class='small']//img[@src='themes/softed/images/user.PNG']")
	public WebElement administrationIcon;
	
	@FindBy(linkText="Sign Out")
	public WebElement signOutLink;
	
	@FindBy(xpath="//a[text()='Products']")
	public WebElement productsTab;
	
	@FindBy(xpath="//a[text()='Contacts']")
	public WebElement contactsTab;
	
	@FindBy(xpath="//a[text()='Organizations']")
	public WebElement organizationTab;
	
	@FindBy(xpath="//a[.='Documents']")
	public WebElement documentsTab;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void clickCampaign(WebDriver driver,WebDriverUse webDriverUse)
	{
		webDriverUse.mouseHoverOnTheElement(driver, moreDropDown);	
		campaingnsTab.click();
	}
	public void signOut(WebDriver driver,WebDriverUse webDriverUse)
	{
		webDriverUse.mouseHoverOnTheElement(driver, administrationIcon);
		signOutLink.click();
	}
	public void clickProducts()
	{
		productsTab.click();
	}
	public void clickContacts() 
	{
		contactsTab.click();
	}
	public void clickOrganizations() 
	{
		organizationTab.click();
	}
	public void clickDocuments() 
	{
		documentsTab.click();
	}

	
}
	
	
//	WebElement administrationicon = driver.findElement(By.xpath("//td[@class='small']//img[@src='themes/softed/images/user.PNG']"));
//	WebDriverUse.mouseHoverOnTheElement(driver, administrationicon);
//	driver.findElement(By.linkText("Sign Out")).click();
	
//	driver.findElement(By.xpath("//a[text()='Products']")).click();
//	driver.findElement(By.xpath("//a[text()='Contacts']")).click();
//driver.findElement(By.xpath("//a[text()='Organizations']")).click();
//driver.findElement(By.xpath("//a[text()='Contacts']")).click();
//driver.findElement(By.xpath("//a[.='Documents']")).click();

	

