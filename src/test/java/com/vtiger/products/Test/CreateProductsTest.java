package com.vtiger.products.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.SDET34L1.GenericLibrary.BaseClass;
import com.SDET34L1.GenericLibrary.DocumentUtility;
import com.SDET34L1.GenericLibrary.IconstanPathWay;
import com.SDET34L1.GenericLibrary.JavaUse;
import com.SDET34L1.GenericLibrary.MSExcelUse;
import com.SDET34L1.GenericLibrary.WebDriverUse;
import com.vtiger.objectRepository.CreateNewProductsPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.ProductInformationPage;
import com.vtiger.objectRepository.ProductsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProductsTest extends BaseClass {
	@Test(groups="regression")
	public void createProductsTest() 
	{
		
		String productName = MSExcelUse.getDataFromExcel("products",2, 1)+randomnumber;

		LoginPage loginPage=new LoginPage(driver);
		HomePage homePage=new HomePage(driver);
		ProductsPage productsPage=new ProductsPage(driver);
		CreateNewProductsPage createNewProductsPage=new CreateNewProductsPage(driver);
		ProductInformationPage productInformationPage=new ProductInformationPage(driver);
		
		homePage.clickProducts();
		productsPage.clickProductsLookUpImg();
		createNewProductsPage.enterProductsNameAndEnter(productName);
		javaUse.assertionThroughIfCondition(productInformationPage.checkProductInformation(), productName, "products");
	}}