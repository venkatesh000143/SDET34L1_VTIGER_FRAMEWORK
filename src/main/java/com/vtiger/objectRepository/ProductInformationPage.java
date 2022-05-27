package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {
	@FindBy(xpath="//span[@id='dtlview_Product Name']")
	private WebElement getNameText;
	
	
	
	public ProductInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String checkProductInformation()
	{
		return getNameText.getText();
	}
}
//(By.id("dtlview_Product")