package com.vtiger.organizations.Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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
import com.vtiger.objectRepository.CreateNewOrganizationPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.OrganizationInformationPage;
import com.vtiger.objectRepository.OrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckNewOrganizationWithIndustryDropDownTest extends BaseClass {
	@Test
	public void checkNewOrganizationWithIndustryDropDownTest() 
	{
		String organizationName = MSExcelUse.getDataFromExcel("Organizations",2, 1)+randomnumber;

		OrganizationsPage organizationsPage=new OrganizationsPage(driver);
		CreateNewOrganizationPage createNewOrganizationPage=new CreateNewOrganizationPage(driver);

		homePage.clickOrganizations();
		organizationsPage.clickOrganizationsLookUpImg();
		createNewOrganizationPage.enterOrganizationName(organizationName);
		createNewOrganizationPage.clickOrganizationIndustryDropDown();
	}}