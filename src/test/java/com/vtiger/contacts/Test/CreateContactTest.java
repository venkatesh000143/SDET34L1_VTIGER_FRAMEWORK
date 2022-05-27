package com.vtiger.contacts.Test;

import org.testng.annotations.Test;

import com.SDET34L1.GenericLibrary.BaseClass;
import com.SDET34L1.GenericLibrary.MSExcelUse;
import com.vtiger.objectRepository.ContactsInformationPage;
import com.vtiger.objectRepository.ContactsPage;
import com.vtiger.objectRepository.CreateNewContactsPage;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class CreateContactTest extends BaseClass{

	@Test(groups="sanity")
	@Description("Description:- createContactTest")
	@Epic("Epic:- createContactTest")
	@Story("Story:- createContactTest")
	@Step("Step:- createContactTest")
	@Severity(SeverityLevel.BLOCKER)
	public void createContactTest() {
		String contactLastName = MSExcelUse.getDataFromExcel("contacts", 5, 1)+randomnumber;

		ContactsPage contactsPage=new ContactsPage(driver);
		CreateNewContactsPage createNewContactsPage=new CreateNewContactsPage(driver);
		ContactsInformationPage contactsInformationPage=new ContactsInformationPage(driver);

		homePage.clickContacts();
		contactsPage.clickContactsLookUpImg();
		createNewContactsPage.enterContactsNameAndEnter(contactLastName);
		javaUse.assertionThroughIfCondition(contactsInformationPage.checkContactsInformation(), contactLastName, "contacts");
	}
}