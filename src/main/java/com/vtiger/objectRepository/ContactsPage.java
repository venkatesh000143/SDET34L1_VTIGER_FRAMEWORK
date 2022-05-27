package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	@FindBy(xpath="//img[@title='Create Contact...']")
	public WebElement createContactsLookUpImg;
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickContactsLookUpImg()
	{
		createContactsLookUpImg.click();
	}
}
//		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
