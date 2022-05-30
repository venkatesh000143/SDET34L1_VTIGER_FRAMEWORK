package com.SDET34L1.GenericLibrary;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;

/**
 * This class contains only java specific reusable methods
 * @author 7Hills
 * Java Use
 */
public class JavaUse {
	/**
	 * This method is used to convert String value to long datatype
	 * @param value
	 * @return
	 * it is by javause
	 */
public long stringtoLong(String value){
	return Long.parseLong(value);
}
/**
 * This method is used to get the random numbers
 * @param limit
 * @return
 */
public int getRandomnumber(int limit){
	Random r=new Random();
	return r.nextInt(limit);
	
}
/**
 * This method is used to print the message
 * @param message
 */
public void printStatement(String message) {
	System.out.println(message);
}
/**
 * This method is used to check weather TC is true or false
 * @param actualResult
 * @param expectedResult
 * @param testcaseName
 */
public void assertionThroughIfCondition(String actualResult,String expectedResult,String testcaseName) {
	if(actualResult.equals(expectedResult))
	{
	System.out.println(testcaseName+" created successfully");
	System.out.println("TC PASSED");
	}
}
/**
 * This method is used to customize the wait
 * @param element
 * @param polling
 * @param duration
 * @throws InterruptedException
 */
public void customWait(WebElement element,long polling,int duration) throws InterruptedException
{
	int count=0;
	while(count<=duration)
	{
		try {
			element.click();
		}
		catch(Exception e) {
			Thread.sleep(polling);
			count++;
		}
	}
}

/**
 * This method is used to get the date and time
 * @return
 */
public String dateTimeInFormat() {
	return new SimpleDateFormat("yyyy_MM_dd_hh_mm_ssss").format(new Date());

}
}
