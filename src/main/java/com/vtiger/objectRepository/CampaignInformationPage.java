package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage {
	@FindBy(xpath="//span[@id='dtlview_Campaign Name']")
	private WebElement getCampaignNameText;
	
	@FindBy(xpath="//span[@id='dtlview_Product']")
	private WebElement getProductNameText;
	
	
	public CampaignInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String checkCampaignInformation()
	{
		return getCampaignNameText.getText();
	}
	
	public String checkProductInformation()
	{
		return getProductNameText.getText();
	}
	
//		String expectedcampaignname = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
//		expectedcampaignname = expectedcampaignname.trim();
}
