package com.vtiger.organization.Test;

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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
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

public class CreateOrganizationWithIndustryAndTypeTest extends BaseClass {
	@Test(groups="regression")
	public void createOrganizationWithIndustryAndTypeTest()
	{
		String organizationName = MSExcelUse.getDataFromExcel("Organizations",2, 1)+randomnumber;

		OrganizationsPage organizationsPage=new OrganizationsPage(driver);
		CreateNewOrganizationPage createNewOrganizationPage=new CreateNewOrganizationPage(driver);
		OrganizationInformationPage organizationInformationPage=new OrganizationInformationPage(driver);

		homePage.clickOrganizations();
		organizationsPage.clickOrganizationsLookUpImg();
		createNewOrganizationPage.enterOrganizationName(organizationName);
		createNewOrganizationPage.selectOrganizationIndustryName();
		createNewOrganizationPage.selectOrganizationTypeName();
		createNewOrganizationPage.enterOrganizationEnter();
		javaUse.assertionThroughIfCondition(organizationInformationPage.checkOrganizationInformation(), organizationName, "Organizations");
}}			