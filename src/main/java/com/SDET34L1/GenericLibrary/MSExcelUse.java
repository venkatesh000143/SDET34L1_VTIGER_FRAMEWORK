package com.SDET34L1.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class contains only excel specific common methods
 * @author 7Hills
 *
 */
public class MSExcelUse {
	static Workbook wbook;
	/**
	 * This method is used to open the excel file
	 * @param filepath
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public static void openExcelFile(String filepath) throws EncryptedDocumentException, IOException {
		FileInputStream fis= new FileInputStream(filepath);
		wbook = WorkbookFactory.create(fis);
	}
	/**
	 * This method is used to get the data from excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public static String getDataFromExcel(String sheetName,int rowNum,int cellNum) {
		String data=wbook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return data;
	}
	/**
	 * This method is used to fetch multiple data from excel
	 * @param sheetName
	 * @return
	 */
	public static Object[][] getMultipleDataFromExcel(String sheetName)
	{
		Sheet sheet=wbook.getSheet(sheetName);
		Object[][] arr=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int j=0;j<sheet.getRow(i).getLastCellNum();j++)
			{
				arr[i][j]=sheet.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return arr;
		
	}
	/**
	 * This method is used to close the workbook or excel
	 * @throws IOException
	 */
	public static void closeExcel() throws IOException {
		wbook.close();
	}
	/**
	 * 	This method is used to provide the data in excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param createCellNum
	 * @param setCellData
	 */
	public static void provideDataInExcel(String sheetName,int rowNum,int createCellNum,String setCellData) {
	wbook.getSheet(sheetName).getRow(rowNum).createCell(createCellNum).setCellValue(setCellData);
	}
	
}
