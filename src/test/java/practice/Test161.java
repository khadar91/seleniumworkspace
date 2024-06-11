package practice;

import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test161 {

	public static void main(String[] args) throws Exception {
		//create new Excel file(.XLSX) with sheet and headings
		File ef=new File("src/test/resources/fileresultbook.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook();
		Sheet sh=wb.createSheet("Mysheet");
		Row r1=sh.createRow(0);
		r1.createCell(0).setCellValue("Name");
		r1.createCell(1).setCellValue("File/Folder");
		r1.createCell(2).setCellValue("Size");
		r1.createCell(3).setCellValue("Last Modified");
		r1.createCell(4).setCellValue("Hidden");
		//copy all files names and other details into excel sheet from 2nd row (index=1)
		File target=new File("D:\\Selenium264");
		File[] l=target.listFiles();
		int rowindex=1; //1st row(index=0) has names for columns
		for(File f:l) //take each file or folder from list/collection
		{
			//1.get name of file/folder and then store in 1st column
			sh.createRow(rowindex).createCell(0).setCellValue(f.getName());
			sh.autoSizeColumn(0);
			// 2. get type and size and then store them into 2nd column and 3rd column
			if(f.isFile())
			{
				sh.getRow(rowindex).createCell(1).setCellValue("file");
				sh.autoSizeColumn(1);
				double b=f.length();
				double k=(b/1024);
				sh.getRow(rowindex).createCell(2).setCellValue(k+"KB");
				sh.autoSizeColumn(2);
				
			}
			else
			{
				sh.getRow(rowindex).createCell(1).setCellValue("folder");
				sh.autoSizeColumn(1);
				long b=FileUtils.sizeOfDirectory(f);
				double k=(b/1024);
				sh.getRow(rowindex).createCell(2).setCellValue(k+"kb");
				sh.autoSizeColumn(2);
			}
			//get last modified of date and time file/folder and then store in 4th column
			SimpleDateFormat sf=new SimpleDateFormat("MMM/dd/YYYY HH:mm:ss");
			sh.getRow(rowindex).createCell(3).setCellValue(sf.format(f.lastModified()));
			sh.autoSizeColumn(3);
			//4.get the file/folder is hidden or not and store in 5th column
			if(f.isHidden())
			{
				sh.getRow(rowindex).createCell(4).setCellValue("yes");
			}
			else
			{
				sh.getRow(rowindex).createCell(4).setCellValue("No");
			}
			sh.autoSizeColumn(4);
			rowindex++; //Mandatory to goto next row in excel sheet
		}
		//Take Write Permission on that file
		FileOutputStream fo =new FileOutputStream(ef);
		wb.write(fo);
		wb.close();
		fo.close();
		
		

	}

}
