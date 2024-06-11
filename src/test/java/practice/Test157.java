package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test157 {

	public static void main(String[] args) throws Exception {
		// 1.Connect existing file in HDD
		File f1=new File("src\\test\\resources\\numdata.xlsx");
		//Take Read Permissions on that file
		FileInputStream fi=new FileInputStream(f1);
		Workbook ewb= WorkbookFactory.create(fi);
		Sheet esh=ewb.getSheet("Sheet1");
		int nor=esh.getPhysicalNumberOfRows();
		//create new Excel file for result
		File f2=new File("src\\test\\resources\\result.xlsx");
		//write permissions
		FileOutputStream fo=new FileOutputStream(f2);
		//create Excel File
		XSSFWorkbook nwb=new XSSFWorkbook();
		Sheet nsh=nwb.createSheet("Result");
		Row r1=nsh.createRow(0);
		r1.createCell(0).setCellValue("Add");
		r1.createCell(1).setCellValue("Subtract");
		r1.createCell(2).setCellValue("Multipy");
		r1.createCell(3).setCellValue("Divide");
		//1st row index=0 has names of columns
		//3. so DDT from 2nd row (index=1) and last roe(nor-1)
		for(int i=1;i<nor;i++)
		{
			DataFormatter df =new DataFormatter();
			String x=df.formatCellValue(esh.getRow(i).getCell(0));
			int a=Integer.parseInt(x);
			String y=df.formatCellValue(esh.getRow(i).getCell(1));
			int b=Integer.parseInt(y);
			Row r2=nsh.createRow(i);
			r2.createCell(0).setCellValue(a+b);
			r2.createCell(1).setCellValue(a-b);
			r2.createCell(2).setCellValue(a*b);
			r2.createCell(3).setCellValue(a/b);
			
		}
		//save that new file with results
		nwb.write(fo);
		fo.close();
		fi.close();
		ewb.close();
		nwb.close();
		
		
		
		

	}

}
