package com.SDET34L1.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * This class contains only property file specific common methods
 * @author 7Hills
 *
 */
public class DocumentUtility {
	
	static Properties property;
	/**
	 * This method is used to open the properties file
	 * @param filepath
	 * @throws IOException
	 */
public static void openPropertyFile(String filepath) throws IOException {
	FileInputStream fis = new FileInputStream(filepath);
	property=new Properties();
	property.load(fis);
}
/**
 * This method is used to fetch the data from properties file
 * @param key
 * @return
 */
public static String getDataFromPropertiesFile(String key) {
	String value = property.getProperty(key);
	return value;

}
}
