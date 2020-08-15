package com.signzy.genericutils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	public static ArrayList<String> dataFetch = new ArrayList<String>();
	
	
	public static void FetchSearchQuery(String file, String testsheet) throws IOException{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\excelsearchdata\\"+file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet =  wb.getSheet(testsheet);
		XSSFRow row;
		XSSFCell cell;
		
		
		int numberOfRows= sheet.getLastRowNum();
		for(int i=0;i<numberOfRows;i++){
			row= sheet.getRow(i);			
			for(int readCell= row.getFirstCellNum();readCell<row.getLastCellNum(); readCell++){
				cell=row.getCell(readCell);
				dataFetch.add(cell.getStringCellValue());
			}
		}
	}
}
