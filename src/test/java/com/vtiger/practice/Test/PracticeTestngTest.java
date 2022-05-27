package com.vtiger.practice.Test;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class PracticeTestngTest extends TestNgBasicConfigTest {
	@Test
	public void practice1Test() {
	Reporter.log("Test1",true);
	Reporter.log("Test2",true);
	SoftAssert as=new SoftAssert();
	as.fail();
	Reporter.log("Test3",true);
	as.assertAll();
	Reporter.log("Test4",true);

	}
	@Test
	public void practice2Test() {
	Reporter.log("Test5",true);
	Reporter.log("Test6",true);
	Reporter.log("Test7",true);
	Reporter.log("Test8",true);

	}
	@Test
	public void practice3Test() {
	Reporter.log("Test9",true);
	}
}
