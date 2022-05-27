package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	@FindBy(xpath="//img[@title='Create Organization...']")
	public WebElement createOrganizationsLookUpImg;
	
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickOrganizationsLookUpImg()
	{
		createOrganizationsLookUpImg.click();
	}
}
//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
