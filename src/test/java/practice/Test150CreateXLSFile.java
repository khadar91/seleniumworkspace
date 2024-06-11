package practice;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Test150CreateXLSFile {

	public static void main(String[] args) throws Exception{
		// Create new Excel Workbook
		HSSFWorkbook wb=new HSSFWorkbook();
		//create new Sheet in workbook	
		HSSFSheet sheet=wb.createSheet("Sheet1");
		//create row in sheet
		HSSFRow row=sheet.createRow(0); // 0 means 1st row
		//create 1st cell in row add some data
		HSSFCell cell=row.createCell(0);// 0 means 1st cell
		cell.setCellValue("Hello Students");
		//save to workbook to a file and close permissions
		File f=new File("src\\test\\resources\\example1.xls");
		FileOutputStream fo=new FileOutputStream(f);
		wb.write(fo);  //save workbook(excel file)
		wb.close();
		fo.close();
		System.out.println("Excel file Created Sucessfully");
	}

}
