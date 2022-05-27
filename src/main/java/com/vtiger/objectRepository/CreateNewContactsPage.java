package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactsPage {
	@FindBy(name="lastname")
	public WebElement contactsTxt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	public WebElement saveBtn;
	
	@FindBy(xpath="(//img[@align='absmiddle'])[3]")
	public WebElement createOrganizationLookUpImg;
	
	public CreateNewContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterContactsNameAndEnter(String contactLastName)
	{
		contactsTxt.sendKeys(contactLastName);
		saveBtn.click();
	}
	
	public void enterContactsName(String contactLastName)
	{
		contactsTxt.sendKeys(contactLastName);
	}
	
	public void clickOrganizationLookUpImg()
	{
		createOrganizationLookUpImg.click();
	}
	
	public void saveContacts()
	{
		saveBtn.click();
	}
	
	
}
//driver.findElement(By.name("lastname")).sendKeys(contactlastname);
//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//driver.findElement(By.xpath("(//img[@align='absmiddle'])[3]")).click();
//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();