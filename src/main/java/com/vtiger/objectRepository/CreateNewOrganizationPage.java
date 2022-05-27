package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET34L1.GenericLibrary.WebDriverUse;

public class CreateNewOrganizationPage {
	@FindBy(xpath="//input[@name='accountname']")
	public WebElement OrganizationTxt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	public WebElement saveBtn;
	
	@FindBy(name="industry")
	public WebElement OrganizationIndustryName;
	
	@FindBy(name="accounttype")
	public WebElement OrganizationTypeName;
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterOrganizationNameAndEnter(String oganizationName)
	{
		OrganizationTxt.sendKeys(oganizationName);
		saveBtn.click();
	}
	
	public void enterOrganizationName(String oganizationName)
	{
		OrganizationTxt.sendKeys(oganizationName);
		
	}
	public void enterOrganizationEnter()
	{
		saveBtn.click();
	}
	
	public void selectOrganizationIndustryName()
	{
		
		WebDriverUse.selectDropDown(OrganizationIndustryName, "Education");
	}
	public void clickOrganizationIndustryDropDown()
	{
		OrganizationIndustryName.click();
		
	}
	
	public void selectOrganizationTypeName()
	{
		
		WebDriverUse.selectDropDown(OrganizationTypeName, "Press");
	}
	public void clickOrganizationTypeDropDown()
	{
		OrganizationTypeName.click();
		
	}
}





//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
////input[@name='accountname']
//WebElement industryname = driver.findElement(By.name("industry"));
//
//WebDriverUse.selectDropDown(industryname, "Education");
//
//WebElement typename = driver.findElement(By.name("accounttype"));
//
//WebDriverUse.selectDropDown(typename, "Press");
//
//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
