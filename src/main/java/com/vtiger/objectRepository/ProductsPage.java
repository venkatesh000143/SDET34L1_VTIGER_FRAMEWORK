package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

	@FindBy(xpath="//img[@title='Create Product...']")
	public WebElement createProductsLookUpImg;
	
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickProductsLookUpImg()
	{
		createProductsLookUpImg.click();
	
	}
}
////		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
