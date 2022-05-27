package com.vtiger.practice.Test;

import org.testng.annotations.Test;

public class PriorityPracticeTest {
@Test(enabled=false)
public void priorityPracticeTest1()
{
	System.out.println("1");
	
}
@Test(priority=1)
public void priorityPracticeTest2()
{
	System.out.println("2");

}
@Test(dependsOnMethods="priorityPracticeTest1")
public void priorityPracticeTest()
{
	System.out.println("3");

}
}
