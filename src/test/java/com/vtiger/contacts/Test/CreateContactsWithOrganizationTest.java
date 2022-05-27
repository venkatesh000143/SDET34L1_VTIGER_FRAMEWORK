package com.vtiger.contacts.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.SDET34L1.GenericLibrary.BaseClass;
import com.SDET34L1.GenericLibrary.DocumentUtility;
import com.SDET34L1.GenericLibrary.IconstanPathWay;
import com.SDET34L1.GenericLibrary.JavaUse;
import com.SDET34L1.GenericLibrary.MSExcelUse;
import com.SDET34L1.GenericLibrary.WebDriverUse;
import com.vtiger.objectRepository.ContactsInformationPage;
import com.vtiger.objectRepository.ContactsPage;
import com.vtiger.objectRepository.CreateNewContactsPage;
import com.vtiger.objectRepository.CreateNewOrganizationPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;
import com.vtiger.objectRepository.OrganizationInformationPage;
import com.vtiger.objectRepository.OrganizationsPage;
import com.vtiger.objectRepository.SearchOrganizationsPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContactsWithOrganizationTest extends BaseClass {
	@Test(groups="sanity")
	public void createContactsWithOrganizationTest()  {
		String contactLastName = MSExcelUse.getDataFromExcel("contacts", 5, 2)+randomnumber;
	    String organizationName = MSExcelUse.getDataFromExcel("Organizations", 2, 1)+randomnumber;

	    ContactsPage contactsPage=new ContactsPage(driver);
	    OrganizationsPage organizationsPage=new OrganizationsPage(driver);
	    CreateNewOrganizationPage createNewOrganizationPage=new CreateNewOrganizationPage(driver);
	    CreateNewContactsPage createNewContactsPage=new CreateNewContactsPage(driver);
	    SearchOrganizationsPage searchOrganizationsPage=new SearchOrganizationsPage(driver);
	    ContactsInformationPage contactsInformationPage=new ContactsInformationPage(driver);
	    OrganizationInformationPage organizationInformationPage=new OrganizationInformationPage(driver);
		WebDriverUse.explicitlyWait(driver, longtimeout);
		
		homePage.clickOrganizations();
		organizationsPage.clickOrganizationsLookUpImg(); 
		createNewOrganizationPage.enterOrganizationNameAndEnter(organizationName);
		WebDriverUse.waitUntilElementToBeClickable(organizationInformationPage.checkOrganizationInfo());
		 
		homePage.clickContacts();
		contactsPage.clickContactsLookUpImg();
		createNewContactsPage.enterContactsName(contactLastName); 
		createNewContactsPage.clickOrganizationLookUpImg();
		searchOrganizationsPage.selectOrganization(driver, organizationName);
		createNewContactsPage.saveContacts();
		javaUse.assertionThroughIfCondition(contactsInformationPage.checkOrganizationInformation(), organizationName, "Organizations");
		javaUse.assertionThroughIfCondition(contactsInformationPage.checkContactsInformation(), contactLastName, "contacts");	
	}
}