package practice;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test151CreateXLSXFile {

	public static void main(String[] args) throws Exception{
		// Create new Excel WorkBook
		XSSFWorkbook wb=new XSSFWorkbook();
		//create sheet in excel workbook
		XSSFSheet sheet=wb.createSheet("Sheet1");
		//create row in sheet1 in work book
		XSSFRow row=sheet.createRow(0); //0 means 1st row
		//create cell in row add some date and save it
		XSSFCell cell=row.createCell(0);
		cell.setCellValue("Hello SDET's");
		//save work book and read permission and close
		File f=new File("src\\test\\resources\\example2.xlsx");
		FileOutputStream fo=new FileOutputStream(f);
		wb.write(fo);
		wb.close();
		fo.close();
		System.out.println("Excel file created successfully.");

	}

}
