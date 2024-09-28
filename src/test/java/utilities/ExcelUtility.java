package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet worksheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	String path;
	
	public ExcelUtility(String path) {
	   this.path=path;
		
	}
	
	public int getRowCount(String sheetName) throws IOException {
		
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		worksheet=workbook.getSheet(sheetName);
		int rowCount=worksheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowCount;
	}
	
	public int getCellCount(String sheetName, int rownum) throws IOException {
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		worksheet=workbook.getSheet(sheetName);
		row=worksheet.getRow(rownum);
		int cellCount=row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellCount;
	}

	public String getCellData(String sheetName,int rownum, int colnum) throws IOException {
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		worksheet=workbook.getSheet(sheetName);
		worksheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		DataFormatter format=new DataFormatter();
		String data;
		try {
			data=format.formatCellValue(cell);
		}
		catch(Exception e) {
			data="";
		}
		workbook.close();
		fi.close();
		return data;
		}
	
	public void setCellData(String sheetName,int rownum, int colnum, String data) throws IOException {
			
			File xlFile=new File(path);
			if(!xlFile.exists()) {                  //if file not exists then create file
				workbook=new XSSFWorkbook();
				fo=new FileOutputStream(path);
				workbook.write(fo);
				fi=new FileInputStream(path);
				workbook=new XSSFWorkbook(fi);
			}
				if(workbook.getSheetIndex(sheetName)==-1)            //if sheet not exists then create new sheet
				workbook.createSheet(sheetName);
				worksheet=workbook.getSheet(sheetName);
				
				if(worksheet.getRow(rownum)==null)                     //if row not exists then create row
				worksheet.createRow(rownum);
				row=worksheet.getRow(rownum);
				
				cell=row.createCell(colnum);
				cell.setCellValue(data);
				fo=new FileOutputStream(path);
				workbook.write(fo);
				workbook.close();
				fi.close();
				fo.close();
				
			}
			
	public void fillGreenColor(String sheetName, int rownum, int colnum) throws IOException {
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		worksheet=workbook.getSheet(sheetName);
		
		row=worksheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		style=workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		workbook.write(fo);
		fi.close();
		fo.close();
	}
	
	public void fillRedColor(String sheetname, int rownum,int colnum) throws IOException {
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		
		worksheet=workbook.getSheet(sheetname);
		
	    row=worksheet.getRow(rownum);
	    cell=row.getCell(colnum);
	    
	    style=workbook.createCellStyle();
	    style.setFillForegroundColor(IndexedColors.RED.getIndex());
	    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
	    cell.setCellStyle(style);
	    workbook.write(fo);
	    fi.close();
	    fo.close();
	    
	    
	}
			
			
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	