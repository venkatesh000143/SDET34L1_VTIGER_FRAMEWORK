package com.SDET34L1.GenericLibrary;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * This class is used to maintain all webdriver common actions
 * @author 7Hills
 *
 */
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class used to maintain all webdriver common actions
 * @author 7Hills
 *
 */
public class WebDriverUse {
	static WebDriverWait wait;
	static WebDriver driver;
	static Select s;
	static JavascriptExecutor jse;
	static JavaUse juse=new JavaUse();
	public Actions act1;

	public WebDriverUse(WebDriver staticdriver) {
		// TODO Auto-generated constructor stub
	}
	/**
	 * This method is used to navigate to the application
	 * @param url
	 * @param driver
	 */
	public static void navigateApp(String url,WebDriver driver) {
		driver.get(url);	
	}
	/**
	 * This method is  used to maximize browser and implicitly wait
	 * @param longtimeout
	 * @param driver
	 */
	public static void browserSetting(long longtimeout, WebDriver driver) {
		maximizeBrowser(driver);
		waitTillPageLoad(longtimeout,driver);
	}
	/**
	 * This method is used to maximize the browser
	 * @param driver
	 */
	public static void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to implicitly wait till page load
	 * @param longtimeout
	 * @param driver
	 */
	public static void waitTillPageLoad(long longtimeout, WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(longtimeout, TimeUnit.SECONDS);
	}
	/**
	 * This method is used to initilize the actions class
	 * @param driver
	 */
	public void initilizeAction(WebDriver driver)
	{
		act1=new Actions(driver);
	}
	/**
	 * This method is used  to mouse hover on the element
	 * @param driver
	 * @param administrationicon
	 */
	public void mouseHoverOnTheElement(WebDriver driver,WebElement administrationicon)
	{
		act1.moveToElement(administrationicon).click().perform();
	}
	/**
	 * This method is used to double click action on the element
	 * @param element
	 */
	public void doubleClickOnElement(WebElement element) {
		act1.doubleClick(element).perform();
	}
	/**
	 * This method is used to double click action on the Webpage
	 */
	public void doubleClick() {
		act1.doubleClick().perform();
	}
	/**
	 * This method is used to right click action on the Webpage
	 */
	public void rightClick() {
		act1.contextClick().perform();
	}
	/**
	 * This method is used to right click action on the element
	 * @param element
	 */
	public void rightClickOnElement(WebElement element) {
		act1.contextClick(element).perform();
	}
	/**
	 * This method is used to quit from the browser
	 * @param driver
	 */
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
	/**
	 * This method is used to control till the particular element is clickable
	 * @param element
	 */
	public static void waitUntilElementToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method is used to control till the particular element is visible
	 * @param element
	 */
	
	public static void waitUntilElementVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method is used to initilize wait instance
	 * @param driver
	 * @param timeOut
	 */
	public static void explicitlyWait(WebDriver driver,long timeOut) {
		wait=new WebDriverWait(driver,timeOut);
	}
	
	/**
	 * This method is used to switch the window
	 * @param driver
	 * @param partialText
	 */
	public static void switchToWindowBasedOnTitle(WebDriver driver,String partialText) {
		Set<String> allids = driver.getWindowHandles();
		for(String id:allids)
		{
			driver.switchTo().window(id);
			if(driver.getTitle().contains(partialText))
			{
				break;
			}
		}
	}
	/**
	 * This method is used to switch the frame by index
	 * @param driver
	 * @param index
	 */
	public static void swithToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	/**
	 * This method is used to switch the frame by Name or id
	 * @param driver
	 * @param nameOrId
	 */
	public static void swithToFrame(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}
	/**
	 *  This method is used to switch the frame by Element
	 * @param driver
	 * @param element
	 */
	public static void swithToFrame(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}
	/**
	 * This method is used to switch homepage
	 * @param driver
	 */
	public static void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * This method is used to select dropdown by using value
	 * @param element
	 * @param value
	 */
	public static void selectDropDown(WebElement element,String value) {
		s = new Select(element);
		s.selectByValue(value);
	}
	/**
	 * This method is used to select dropdown by using index 
	 * @param element
	 * @param index
	 */
	public static void selectDropDown(WebElement element,int index) {
		s = new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method is used to select dropdown by using visibleText
	 * @param visibleText
	 * @param element
	 */
	public static void selectDropDown(String visibleText,WebElement element) {
		s = new Select(element);
		s.selectByVisibleText(visibleText);
	}
	/**
	 * This method is used to handle alert popup accept
	 * @param driver
	 */
	public static void alertAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method is used to handle alert popup dismiss
	 * @param driver
	 */
	public static void alertDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method is used to handle alert popup send data
	 * @param driver
	 * @param data
	 */
	public static void alertSendData(WebDriver driver,String data)
	{
		driver.switchTo().alert().sendKeys(data);
	}
	/**
	 * This method is used to handle alert popup getText
	 * @param driver
	 */
	public static void alertalertText(WebDriver driver)
	{
		driver.switchTo().alert().getText();
	}
	/**
	 * This method is used to initilize the javascriptexecutor
	 * @param driver
	 */
	public static void intilizeJs(WebDriver driver) {
		jse= (JavascriptExecutor)driver;
	}
	/**
	 * This method is used to open the application through javascriptexecutor
	 * @param url
	 */
	public static void navigateApplicationThroughJs(String url) {
		jse.executeScript("window.location=arguments[0]",url);
	}
	/**
	 * This method is used to enter the data through javascriptexecutor
	 * @param element
	 * @param data
	 */
	public static void enterDataThroughJs(WebElement element,String data) {
		jse.executeScript("arguments[0].value=arguments[1]",element,data);
	}
	/**
	 * This method is used to click the element through javascriptexecutor
	 * @param element
	 */
	public static void clickThroughJs(WebElement element) {
		jse.executeScript("arguments[0].click()",element);
	}
	/**
	 * This method is used to scroll specific height through javascriptexecutor
	 * @param height
	 */
	public static void scrollSpecificHeight(String height) {
	jse.executeScript("window.scrollBy(0,"+height+")");
	}
	/**
	 * This method is used to scroll to bottom through javascriptexecutor
	 * @param height
	 */
	public static void scrollToBottom(String height) {
	jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");//this method will scroll untill page end
	}
	/**
	 * This method is used to scroll upto particular element
	 * @param element
	 */
	public static void scrollTillElement(WebElement element) {
	jse.executeScript("arguments[0].scrollIntoView()",element);
	}
	/**
	 * This method is used to take the screenshot
	 * @param fileName
	 * @param driver2
	 * @return 
	 * @throws IOException
	 */
	public static  String takeScreenShot(String fileName,WebDriver driver) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File des=new File("./screenshot/"+fileName+"_"+juse.dateTimeInFormat()+".png");
	FileUtils.copyFile(src, des);
	return des.getAbsolutePath();
	}
}
