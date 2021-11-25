package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {
	File file;
	FileInputStream fis;

	Workbook wb;
	Sheet sheet;
	Row row;
	Column colm;
	public ReadFromExcel(String sheetName) {
		//log=LogManager.getLogger();
		file=new File("C:\\Users\\Navaneeth\\Desktop\\Flipkart\\TestData.xlsx");
		try {
			fis=new FileInputStream(file);
			wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
			//log.info("Excel data file path incorrect");
			e.printStackTrace();
		}
		sheet=wb.getSheet(sheetName);
	}
	
	public void readData(String colName, int rowNo) {
		int headerColNum = 0;
		row=sheet.getRow(0);
		int colCount=row.getLastCellNum();
		for(int i=0;i<colCount;i++) {
			if(colName.contains(row.getCell(i).getStringCellValue())) {
				headerColNum=i;
			}
		}
		System.out.println("header position is : "+headerColNum);
		String itemName=sheet.getRow(rowNo).getCell(headerColNum).getStringCellValue();
		System.out.println("product name is : "+itemName);
	}
	
	public static void main(String[] args) {
		System.out.println("in main");
		ReadFromExcel read=new ReadFromExcel("product names");
		read.readData("Search With", 2);
	}
	
}
