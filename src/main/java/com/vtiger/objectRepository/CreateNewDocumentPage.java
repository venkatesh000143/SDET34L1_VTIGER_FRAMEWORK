package com.vtiger.objectRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SDET34L1.GenericLibrary.WebDriverUse;

public class CreateNewDocumentPage {

	@FindBy(name="notes_title")
	private WebElement documentNameTxt;
	
	@FindBy(className="cke_show_borders")
	private WebElement iframeTxt;
	
	@FindBy(className="cke_button_bold")
	private WebElement boldStyleBtn;
	
	@FindBy(className="cke_button_italic")
	private WebElement italicStyleBtn;
	
	@FindBy(id="filename_I__")
	private WebElement chooseFileBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateNewDocumentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterDocumentName(String title)
	{
		 documentNameTxt.sendKeys(title);
	}
	public void enterDescriptionInIframe(String description,WebDriver driver)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,4000);");
		WebDriverUse.swithToFrame(driver, 0);
		iframeTxt.sendKeys(description,Keys.CONTROL+"a");
		WebDriverUse.switchToDefaultContent(driver);
		boldStyleBtn.click();
		italicStyleBtn.click();
	}
	public void provideFileInChooseFileBtn(String documentpath)
	{
		chooseFileBtn.sendKeys(documentpath);
	}
	
	public void saveDocument()
	{
		saveBtn.click();
	}
}


//driver.findElement(By.name("notes_title")).sendKeys(title);

//JavascriptExecutor jse = (JavascriptExecutor)driver;
//jse.executeScript("window.scrollBy(0,4000);");
//
//WebDriverUse.swithToFrame(driver, 0);
//
//driver.findElement(By.className("cke_show_borders")).sendKeys(description,Keys.CONTROL+"a");
//
//WebDriverUse.switchToDefaultContent(driver);
//driver.findElement(By.className("cke_button_bold")).click();
//driver.findElement(By.className("cke_button_italic")).click();

//driver.findElement(By.id("filename_I__")).sendKeys(documentpath);
//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
