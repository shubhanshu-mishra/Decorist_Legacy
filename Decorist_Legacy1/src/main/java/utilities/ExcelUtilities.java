package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BusinessRules.Constants;

public class ExcelUtilities {

	public static FileInputStream file;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFCell cell;
	public static Row row;
	public static Cell c;
	public static FileOutputStream file1;
	
	public static void setExcel() {
		try {
			file=new FileInputStream(Constants.excelFilePath);
			wb=new XSSFWorkbook(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getCellData(String sheetName,int rowNum,int colNum) {
		ws=wb.getSheet(sheetName);
		cell=ws.getRow(rowNum).getCell(colNum);
		if (cell.getCellType()==CellType.NUMERIC) {
			DataFormatter format=new DataFormatter();
			String cellData=format.formatCellValue(cell);
			return cellData;
		}else {
			String cellData=cell.getStringCellValue();
			return cellData;
		}
		
	}
	
	public static void writeCellData(String sheetName,int rowNum,int colNum,String data) {
		ws=wb.getSheet(sheetName);
		if (ws.getRow(rowNum)==null) {
			row=ws.createRow(rowNum);
		}
		else {
			row=ws.getRow(rowNum);
			if (row.getCell(colNum) == null) {
				c=row.createCell(colNum);
				c.setCellValue(data);
			}else {
				c=row.getCell(colNum);
				c.setCellValue(data);
			}
			
			
			try {
				file1=new FileOutputStream(Constants.excelFilePath);
				wb.write(file1);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			
			}
			
		}
		
		
		
	}
	
	
}
