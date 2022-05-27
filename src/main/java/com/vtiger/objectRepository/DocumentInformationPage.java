package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentInformationPage {
	@FindBy(xpath="//span[@id='dtlview_Title']")
	private WebElement getDocumentNameText;
	
	@FindBy(className="dvHeaderText")
	private WebElement documentNameTextInfo;
	
	@FindBy(xpath="//input[@title='Edit [Alt+E]']")
	private WebElement editBtn;
	
	public DocumentInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String checkDocumentInformation()
	{
		return getDocumentNameText.getText();
	}
	public WebElement checkDocumentTextInfo()
	{
		return documentNameTextInfo;
	}
	public WebElement clickEditBtn()
	{
		return editBtn;
	}
}



//String expectedtitle = driver.findElement(By.xpath("//span[@id='dtlview_Title']")).getText();
////span[@class='dvHeaderText']
//input[@title='Edit [Alt+E]']