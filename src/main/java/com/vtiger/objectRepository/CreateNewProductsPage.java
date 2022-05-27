package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewProductsPage {

	@FindBy(name="productname")
	public WebElement productNameTxt;
	
	@FindBy(name="button")
	public WebElement saveBtn;
	
	public CreateNewProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterProductsNameAndEnter(String productName)
	{
		productNameTxt.sendKeys(productName);
		saveBtn.click();
	}
}
//	driver.findElement(By.name("productname")).sendKeys(productname);
//driver.findElement(By.name("button")).click();