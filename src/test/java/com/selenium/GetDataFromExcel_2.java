package com.selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetDataFromExcel_2 {
	
	public ArrayList<String> getTestData(String sheetName, String testCases, String testCaseName) throws IOException {
		
		ArrayList<String> array = new ArrayList<String>();
		
		FileInputStream input = new FileInputStream("C:\\SITS\\workspace_Oxygen.3_EE\\Core_Selenium\\src\\DataDrivenFramework\\TestData.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(input);
		
		int sheets = book.getNumberOfSheets();
		for(int i=0; i<sheets; i++) {
			if(book.getSheetName(i).equalsIgnoreCase(sheetName)) {
				XSSFSheet sheet = book.getSheetAt(i);
				
				Iterator<Row> row = sheet.iterator();
				Row firstRow = row.next();
				Iterator<Cell> ce = firstRow.cellIterator();
				
			int j = 0;
			int colIndex = 0;
			while(ce.hasNext()) {
				Cell value = ce.next();
				if(value.getStringCellValue().equalsIgnoreCase(testCases)) {
					//desired column
					colIndex=j;
				}
				j++;
			}
			
			while(row.hasNext()) {
				Row r = row.next();
				if(r.getCell(colIndex).getStringCellValue().equalsIgnoreCase(testCaseName)) {
					Iterator<Cell> cValue = r.cellIterator();
					while(cValue.hasNext()) {
						array.add(cValue.next().toString());
						
					}
				}
			}	
			}
		}
		return array;
	}
		
	

	public static void main(String[] args) throws IOException {
		
		GetDataFromExcel_2 obj = new GetDataFromExcel_2();
		ArrayList<String> data = obj.getTestData("login", "testCases", "Purchase");
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		
		
		
	}
}
