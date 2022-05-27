package com.vtiger.practice.Test;

import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

public class practice1Test {
	
	@Test
	@Description("Description:- createContactTest")
	@Epic("Epic:- createContactTest")
	@Story("Story:- createContactTest")
	@Step("Step:- createContactTest")
	@Severity(SeverityLevel.BLOCKER)
	public void practice1() {
		System.out.println("1");
	}

}
