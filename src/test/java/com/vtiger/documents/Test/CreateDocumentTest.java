package com.vtiger.documents.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SDET34L1.GenericLibrary.BaseClass;
import com.SDET34L1.GenericLibrary.DocumentUtility;
import com.SDET34L1.GenericLibrary.IconstanPathWay;
import com.SDET34L1.GenericLibrary.JavaUse;
import com.SDET34L1.GenericLibrary.MSExcelUse;
import com.SDET34L1.GenericLibrary.WebDriverUse;
import com.vtiger.objectRepository.CreateNewDocumentPage;
import com.vtiger.objectRepository.DocumentInformationPage;
import com.vtiger.objectRepository.DocumentsPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDocumentTest extends BaseClass {
	@Test(groups="sanity")
	public void createDocumentTest() throws InterruptedException 
	{
		String title = MSExcelUse.getDataFromExcel("documents",2,1)+randomnumber;
		String description = MSExcelUse.getDataFromExcel("documents",2,2);
		String documentpath = MSExcelUse.getDataFromExcel("documents",2,3);

		DocumentsPage documentsPage=new DocumentsPage(driver);
		CreateNewDocumentPage createNewDocumentPage=new CreateNewDocumentPage(driver);
		DocumentInformationPage documentInformationPage=new DocumentInformationPage(driver);

		homePage.clickDocuments();
		documentsPage.clickDocumentsLookUpImg();
		createNewDocumentPage.enterDocumentName(title);
		createNewDocumentPage.enterDescriptionInIframe(description, driver);
		createNewDocumentPage.provideFileInChooseFileBtn(documentpath);
		createNewDocumentPage.saveDocument();
		javaUse.assertionThroughIfCondition(documentInformationPage.checkDocumentInformation(), title, "documents");
	}}