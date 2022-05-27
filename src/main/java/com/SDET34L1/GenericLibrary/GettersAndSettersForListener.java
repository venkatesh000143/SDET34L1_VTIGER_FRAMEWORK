package com.SDET34L1.GenericLibrary;

import org.openqa.selenium.WebDriver;

import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

public class GettersAndSettersForListener {
	
private static 	GettersAndSettersForListener instance;
	public WebDriver driver;
	public LoginPage loginPage; 
	public String username;
	public String password;
	public HomePage homePage;
	public int randomnumber;
	public JavaUse javaUse;
	public long longtimeout;
	public WebDriverUse webDriverUse;
private GettersAndSettersForListener() {}
public static GettersAndSettersForListener getInstance() {
	if(instance==null)
	{
		instance=new GettersAndSettersForListener();
	}
	return instance;
	
}
public WebDriver getDriver() {
	return driver;
}
public void setDriver(WebDriver driver) {
	this.driver = driver;
}
public LoginPage getLoginPage() {
	return loginPage;
}
public void setLoginPage(LoginPage loginPage) {
	this.loginPage = loginPage;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public HomePage getHomePage() {
	return homePage;
}
public void setHomePage(HomePage homePage) {
	this.homePage = homePage;
}
public int getRandomnumber() {
	return randomnumber;
}
public void setRandomnumber(int randomnumber) {
	this.randomnumber = randomnumber;
}
public JavaUse getJavaUse() {
	return javaUse;
}
public void setJavaUse(JavaUse javaUse) {
	this.javaUse = javaUse;
}
public long getLongtimeout() {
	return longtimeout;
}
public void setLongtimeout(long longtimeout) {
	this.longtimeout = longtimeout;
}
public WebDriverUse getWebDriverUse() {
	return webDriverUse;
}
public void setWebDriverUse(WebDriverUse webDriverUse) {
	this.webDriverUse = webDriverUse;
}

}
