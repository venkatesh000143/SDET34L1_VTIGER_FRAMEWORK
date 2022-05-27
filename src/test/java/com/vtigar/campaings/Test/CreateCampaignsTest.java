package com.vtigar.campaings.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

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
import com.vtiger.objectRepository.CampaignInformationPage;
import com.vtiger.objectRepository.CampaignsPage;
import com.vtiger.objectRepository.CreateNewCampaignPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignsTest extends BaseClass {
	@Test(groups="sanity")
	public  void createcampaignsPracticeTest() 
	{ 
		String campaignName = MSExcelUse.getDataFromExcel("campaigns",2,1)+randomnumber;
		CampaignsPage campaignsPage=new CampaignsPage(driver);
		CreateNewCampaignPage createNewCampaignPage=new CreateNewCampaignPage(driver);
		CampaignInformationPage campaignInformationPage=new CampaignInformationPage(driver);

		homePage.clickCampaign(driver, webDriverUse);
		campaignsPage.clickCreateCampaingnLookUpImg();
		createNewCampaignPage.enterCampaignNameAndEnter(campaignName);
		campaignInformationPage.checkCampaignInformation();
		javaUse.assertionThroughIfCondition(campaignInformationPage.checkCampaignInformation(),campaignName, "campaigns");
	}}		