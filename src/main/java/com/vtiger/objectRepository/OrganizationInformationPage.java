package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	
	@FindBy(xpath="//span[@id='dtlview_Organization Name']")
	private WebElement getOrganizationNameText;
	
	@FindBy(className="dvHeaderText")
	private WebElement organizationNameText;
	
	public OrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String checkOrganizationInformation()
	{
		return getOrganizationNameText.getText();
	}
	
	public WebElement checkOrganizationInfo()
	{
		return organizationNameText;
	}
}


//String expectedorgname=driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
