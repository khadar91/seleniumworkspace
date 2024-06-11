package practice;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test160 {

	public static void main(String[] args) throws Exception {
		// Take Excel and create sheet
		File f=new File("src/test/resources/Book2.xlsx");
		//create object to workbook
		XSSFWorkbook wwb=new XSSFWorkbook();
		Sheet swb;
		try {
			swb=wwb.createSheet("Sheet1");
		}
		catch(Exception e) //if already exist
		{
			swb=wwb.getSheet("Sheet1");
		}
		//create font Object to workbook
		Font font=wwb.createFont();
		font.setFontHeightInPoints((short)60);
		font.setFontName("Arial");
		font.setItalic(true);
		font.setColor(IndexedColors.BROWN.getIndex());
		CellStyle style=wwb.createCellStyle();
		style.setFont(font);
		//Applying style to the cell
		Cell cell=swb.createRow(0).createCell(0); // Creating a cell
		cell.setCellValue("Hello, All of You");
		cell.setCellStyle(style);
		swb.autoSizeColumn(0);
		//save Excel file
		FileOutputStream fo=new FileOutputStream(f); //WRITE mode(Appending)
		wwb.write(fo);
		fo.close();
		wwb.close();

	}

}
