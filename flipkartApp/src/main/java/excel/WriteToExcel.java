package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import baseFolder.BaseClass;

public class WriteToExcel {
	File file;
	FileInputStream fis;
	FileOutputStream fos;
	Workbook wb;
	Sheet sheet;
	Row row;
	Column colm;
	public WriteToExcel() {
		//log=LogManager.getLogger();
		file=new File("C:\\Users\\Navaneeth\\Desktop\\Flipkart\\TestData.xlsx");
		try {
			fis=new FileInputStream(file);
			wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
			//log.info("Excel data file path incorrect");
			e.printStackTrace();
		}
	}

	public void writeProductDetails(String name, String config, String size, String camera, String battery)throws Throwable  {
		int rowCount=sheet.getLastRowNum()+1;
		row=sheet.createRow(rowCount);
		row.createCell(2).setCellValue(name);
		row.createCell(3).setCellValue(config);
		row.createCell(4).setCellValue(size);
		row.createCell(5).setCellValue(camera);
		row.createCell(6).setCellValue(battery);
		fos=new FileOutputStream(file);
		wb.write(fos);
		
	}
	
	public void writeProductName(String productName) {
		sheet=wb.getSheet("product details");
		int rowCount=sheet.getLastRowNum();
		System.out.println("no of row is: "+rowCount);
		sheet.createRow(rowCount+1).createCell(0).setCellValue(productName);
		
		
	}

	public static void main(String[] args) throws Throwable {
		System.out.println("in main");
		WriteToExcel write=new WriteToExcel();
		write.writeProductName("REDMI 10 Prime");
		write.writeProductDetails("Redmi 10", "6 GB", "Large", "108MP", "5000mah");
		write.writeProductDetails("Redmi 10", "6 GB", "Large", "108MP", "6000mah");
		write.writeProductDetails("Redmi 10", "6 GB", "Large", "108MP", "7000mah");
		write.writeProductName("POCO M3");
		write.writeProductDetails("Redmi 10", "6 GB", "Large", "108MP", "5000mah");
		write.writeProductDetails("Redmi 10", "6 GB", "Large", "108MP", "6000mah");
		write.writeProductDetails("Redmi 10", "6 GB", "Large", "108MP", "7000mah");
		System.out.println("end of program");
	}
}
