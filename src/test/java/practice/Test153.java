package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Test153 {

	public static void main(String[] args) throws Exception {
		//Connect existing Excel file in HDD
		File f=new File("src\\test\\resources\\exceldata.xlsx");
		//Read permissions on that file
		FileInputStream fis=new FileInputStream(f);
		//Consider that file as workbook(eigther .xls file or .xlsx) file 
		Workbook wb=WorkbookFactory.create(fis);
		//create new Sheet
		Sheet sh=wb.createSheet("Mysheet");
		//create row in a sheet set values taht sheet
		Row r1=sh.createRow(0);
		r1.createCell(0).setCellValue("Abdul Kalam");
		r1.createCell(1).setCellValue("india");
		Row r2=sh.createRow(1);
		r2.createCell(0).setCellValue("Thomas Kutty");
		r2.createCell(1).setCellValue("india");
		Row r3=sh.createRow(2);
		r3.createCell(0).setCellValue("Rohit Sharma");
		r3.createCell(1).setCellValue("india");
		//Auto fit
		sh.autoSizeColumn(0);
		sh.autoSizeColumn(1);
		//save changes
		FileOutputStream fos=new FileOutputStream(f);
		wb.write(fos); //save changes
		fos.close();
		fis.close();
		wb.close();
		System.out.println("Excel file updated successfully.");

	}

}
