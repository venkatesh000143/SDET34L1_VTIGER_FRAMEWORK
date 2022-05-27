package com.vtiger.practice.Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
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

public class CreatecampaignsTest extends BaseClass {
	String campaignName;
	CreateNewCampaignPage createNewCampaignPage;
	CampaignInformationPage campaignInformationPage;
	CampaignsPage campaignsPage;
	@Test
	public  void createcampaignsTest() throws IOException { 
		    campaignName = MSExcelUse.getDataFromExcel("campaigns",2,1)+randomnumber;
		    campaignsPage=new CampaignsPage(driver);
		    createNewCampaignPage=new CreateNewCampaignPage(driver);
		    campaignInformationPage=new CampaignInformationPage(driver);
			
			homePage.clickCampaign(driver, webDriverUse);
			campaignsPage.clickCreateCampaingnLookUpImg();
			createNewCampaignPage.enterCampaignNameAndEnter(campaignName);
			campaignInformationPage.checkCampaignInformation();
			javaUse.assertionThroughIfCondition(campaignInformationPage.checkCampaignInformation(),campaignName, "campaigns");
	}		
}


