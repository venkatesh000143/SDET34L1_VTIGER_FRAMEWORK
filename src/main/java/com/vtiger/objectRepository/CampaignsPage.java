package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage {
	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement createCampaingnLookUpImg;
	
	public CampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickCreateCampaingnLookUpImg()
	{
		createCampaingnLookUpImg.click();
	}
	
	
//		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();

}
