package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET34L1.GenericLibrary.WebDriverUse;

public class CreateNewCampaignPage {

	@FindBy(xpath="//input[@name='campaignname']")
	public WebElement campaignNameTxt;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])")
	public WebElement saveBtn;
	
	@FindBy(xpath="//img[@style='cursor:hand;cursor:pointer']")
	public WebElement createProductsLookUpImg;
	
	public CreateNewCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterCampaignNameAndEnter(String campaignName)
	{
		campaignNameTxt.sendKeys(campaignName);
		saveBtn.click();
	}
	public void enterCampaignName(String campaignName)
	{
		campaignNameTxt.sendKeys(campaignName);
		
	}
	public void saveCampaign()
	{
		saveBtn.click();
	}
	
	public void clickProductsLookUpImg()
	{
		createProductsLookUpImg.click();
	}
	
//	//input[@name='campaignname']
//	driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
//	driver.findElement(By.name("campaignname")).sendKeys(campaignname);
//	driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
//	driver.findElement(By.xpath("//img[@style='cursor:hand;cursor:pointer']")).click();

}
