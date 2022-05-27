package com.vtigar.campaings.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.SystemOutLogger;
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
import com.vtiger.objectRepository.CampaignInformationPage;
import com.vtiger.objectRepository.CampaignsPage;
import com.vtiger.objectRepository.CreateNewCampaignPage;
import com.vtiger.objectRepository.CreateNewProductsPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.ProductInformationPage;
import com.vtiger.objectRepository.ProductsPage;
import com.vtiger.objectRepository.SearchProductsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignsWithProductTest extends BaseClass {
	@Test(groups="sanity")
	public void createCampaignsWithProductTest() throws EncryptedDocumentException, IOException, InterruptedException {
		String campaignName = MSExcelUse.getDataFromExcel("campaigns",5, 1)+randomnumber;
	    String productName = MSExcelUse.getDataFromExcel("campaigns", 5, 2)+randomnumber;

	    ProductsPage productsPage=new ProductsPage(driver);
	    CreateNewProductsPage createNewProductsPage=new CreateNewProductsPage(driver);
	    CampaignsPage campaignsPage=new CampaignsPage(driver);
	    CreateNewCampaignPage createNewCampaignPage=new CreateNewCampaignPage(driver);
	    SearchProductsPage searchProductsPage=new SearchProductsPage(driver);
	    CampaignInformationPage campaignInformationPage=new CampaignInformationPage(driver);
	    ProductInformationPage productInformationPage=new ProductInformationPage(driver);
		
		homePage.clickProducts();
		productsPage.clickProductsLookUpImg();
		createNewProductsPage.enterProductsNameAndEnter(productName);
		
		homePage.clickCampaign(driver, webDriverUse);
		campaignsPage.clickCreateCampaingnLookUpImg();
		createNewCampaignPage.enterCampaignName(campaignName);
		createNewCampaignPage.clickProductsLookUpImg();
		searchProductsPage.selectProduct(driver,productName);
		createNewCampaignPage.saveCampaign();
		javaUse.assertionThroughIfCondition(campaignInformationPage.checkCampaignInformation(), campaignName, "campaigns");
		javaUse.assertionThroughIfCondition(campaignInformationPage.checkProductInformation(), productName, "products");
		
}}		