package com.SDET34L1.GenericLibrary;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.vtiger.objectRepository.CampaignInformationPage;
import com.vtiger.objectRepository.CampaignsPage;
import com.vtiger.objectRepository.CreateNewCampaignPage;
import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 	This class used to get the common methods
 * @author 7Hills
 * baseclass changes by lucky
 */
public class BaseClass {
	public WebDriver driver;
	public LoginPage loginPage; 
	public String username;
	public String password;
	public HomePage homePage;
	public int randomnumber;
	public JavaUse javaUse;
	public long longtimeout;
	public WebDriverUse webDriverUse;
	public static WebDriver staticdriver;
	/**
	 * This method is used open properties file and excel file
	 * @throws IOException
	 */
	@BeforeSuite(groups="baseclass")
	public void beforeSuiteTest() throws IOException
	{
		DocumentUtility.openPropertyFile(IconstanPathWay.PROPERTYFILEPATH);
	    MSExcelUse.openExcelFile(IconstanPathWay.EXCELFILEPATH);
	} 
	/**
	 * This method is used to get common data from property file ,
	 * create instance for all generic utilities,
	 * launch browser,do the browser setting
	 * create the instance for common repository
	 */
	//@Parameters("browser")
	@BeforeClass(groups="baseclass")
	public void beforeClassTest(/*String browser*/)
	{	
		javaUse=new JavaUse();
		//String url = DocumentUtility.getDataFromPropertiesFile("url");
		//username = DocumentUtility.getDataFromPropertiesFile("username");
		//password = DocumentUtility.getDataFromPropertiesFile("password");
		String timeouts = DocumentUtility.getDataFromPropertiesFile("timeouts");
		//String browser = DocumentUtility.getDataFromPropertiesFile("browsername");
		longtimeout = javaUse.stringtoLong(timeouts);
	    randomnumber = javaUse.getRandomnumber(1000);
	   String url = System.getProperty("URL");
	    username=System.getProperty("USERNAME");
	   password= System.getProperty("PASSWORD");
	   String browser = System.getProperty("BROWSER");
	    switch(browser)
		{
		case "chrome":
			WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;	
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;	
		}
		staticdriver=driver;
	     loginPage=new LoginPage(driver);
		 homePage=new HomePage(driver);
		 webDriverUse=new WebDriverUse(driver);

		webDriverUse.browserSetting(longtimeout, driver);
		webDriverUse.navigateApp(url, driver);
		webDriverUse.initilizeAction(driver);
	}
	/**
	 * In this annotation we do login action
	 */
	@BeforeMethod(groups="baseclass")
	public void beforeMethodTest()
	{
		loginPage.LoginActions(username,password);	
	}
	/**
	 * In this annotation we do signout action
	 */
	@AfterMethod(groups="baseclass")
	public void afterMethodTest()
	{
		homePage.signOut(driver,webDriverUse);
	}
	/**
	 * In this annotation we will do close the browser instance
	 */
	@AfterClass(groups="baseclass")
	public void afterClassTest()
	{
		WebDriverUse.quitBrowser(driver);
	}
	/**
	 * In this annotation close the database and close the excel
	 * @throws IOException
	 */
	@AfterSuite(groups="baseclass")
	public void afterSuiteTest() throws IOException 
	{
		MSExcelUse.closeExcel();
	}
	
}
