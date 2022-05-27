package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentsPage {
	@FindBy(xpath="//img[@title='Create Document...']")
	public WebElement createDocumentsLookUpImg;
	
	public DocumentsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickDocumentsLookUpImg()
	{
		createDocumentsLookUpImg.click();
	}
}
//driver.findElement(By.xpath("//img[@title='Create Document...']")).click();
