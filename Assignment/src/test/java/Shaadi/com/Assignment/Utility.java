package Shaadi.com.Assignment;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;  


public class Utility {
	
	public static XSSFSheet ExcelWSheet;
	public static XSSFWorkbook ExcelWBook;
	//private static org.apache.poi.ss.usermodel.Cell Cell;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	// private static XSSFRow Row;
	
	
	
	@SuppressWarnings("unused")
	public static ArrayList<Object[]> dataread() throws Throwable {
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		FileInputStream ExcelFile = new FileInputStream("Assignment.xlsx");
		ExcelWBook = new XSSFWorkbook(ExcelFile);
		
		
		for (int rwnum = 1; rwnum <getRowCount("Assignment"); rwnum++) {
		String domain = getCellData(rwnum, 0, "Assignment");
		String community = getCellData(rwnum, 1, "Assignment");
		
		Object ob[] = {domain,community};
		myData.add(ob);
		
		}
		
		return myData;
	}
	
	
	public static String getCellData(int RowNum, int ColNum, String SheetName) throws Exception{
		try {
			
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			Row = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		return "";
		
	}
	
	
	public static int getRowCount(String SheetName) {
		int iNumber = 0;
		try {
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
			iNumber = ExcelWSheet.getLastRowNum() + 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return iNumber;
	}

}
	

