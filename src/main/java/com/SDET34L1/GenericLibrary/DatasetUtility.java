package com.SDET34L1.GenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;

/**
 * This class contains all common action related to database 
 * @author 7Hills
 *
 */
public class DatasetUtility {
	static Driver driver1;
	static Connection connection;
	static Statement statement;
	/**
	 * This method is used to open the database connection and intilize the connection and statement
	 * @throws SQLException
	 */
	public static void openDBConnection(String dBUrl,String dBUserName,String dBPassWord) throws SQLException
	{
		driver1 = new Driver();
		DriverManager.registerDriver(driver1);
		connection = DriverManager.getConnection(dBUrl,dBUserName,dBPassWord);
		 statement=connection.createStatement();
	}
	/**
	 * This method is used to fetch the data from database/to do the DQL actions on database
	 * @param query
	 * @param columnname
	 * @throws SQLException
	 */
	public static ArrayList<String> getDataFromDataBase(String query,String columnName) throws SQLException
	{
		ArrayList<String> list=new ArrayList<>();
		ResultSet result=statement.executeQuery(query);
		while(result.next())
		{
			list.add(result.getString(columnName));
		}
		return list;
	}
	/**
	 * This method is used to validate the data whether it is present in database or not
	 * @param query
	 * @param columnName
	 * @param expectedData
	 * @return
	 * @throws SQLException
	 */
	public static boolean validateDataInDataBase(String query,String columnName,String expectedData) throws SQLException
	{
		ArrayList<String> list= getDataFromDataBase(query, columnName);
		boolean flag=false;
		for(String actualData:list)
		{
			if(actualData.equalsIgnoreCase(expectedData))
			{
				flag=true;
				break;
			}
			
		}
		return flag;
	}
	/**
	 * This method is used to store/modify/insert/delete the datain database/to do the DML and DDL actions on database
	 * @param query
	 * @throws SQLException
	 */
	public static void setDataInDataBase(String query) throws SQLException
	{
		int result=statement.executeUpdate(query);
		if(result>=1)
		{
			System.out.println("Data entered/modified successfully");
		}
	}
	
	/**
	 * This method is used to close the DataBase Connection
	 * @throws SQLException
	 */
	public static void closeDBConnection() throws SQLException 
	{
		
			connection.close();
	}
}
