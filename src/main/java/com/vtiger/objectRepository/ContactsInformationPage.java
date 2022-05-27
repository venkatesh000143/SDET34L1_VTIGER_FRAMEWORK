package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsInformationPage {
	@FindBy(id="dtlview_Last Name")
	private WebElement getContactNameText;
	
	@FindBy(xpath="//td[@id='mouseArea_Organization Name']/a")
	private WebElement getOrganizationNameText;
	
	public ContactsInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String checkContactsInformation()
	{
		return getContactNameText.getText();
	}
	public String checkOrganizationInformation()
	{
		return getOrganizationNameText.getText();
	}
}
//String expectedcontactlastname = driver.findElement(By.id("dtlview_Last Name")).getText();
