package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	Workbook book;
	Sheet sheet;
	
	public Object[][] retrivedata(String sheetname)
	{
		try {
			FileInputStream lp=new FileInputStream("C:\\Users\\Arun Areath\\Desktop\\API Project\\HubspotAutomationTest\\src\\main\\java\\com\\qa\\database\\ExcelData.xlsx");
			Workbook book = WorkbookFactory.create(lp);
			sheet = book.getSheet(sheetname);
			
			Object data[][]=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for(int i = 0;i<sheet.getLastRowNum();i++)
			{
				for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
				{
					data[i][j]=sheet.getRow(i+1).getCell(j);
					
				}
			}
			return data;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


}
