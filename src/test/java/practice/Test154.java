package practice;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Test154 {

	public static void main(String[] args) throws Exception {
		// Connecting existing file in HDD
		File f=new File("src\\test\\resources\\exceldata.xlsx");
		//Take Read Permissions on that file
		FileInputStream fis=new FileInputStream(f);
		//Consider that file as Excel file(workbook) and shift to the RAM
		Workbook wb=WorkbookFactory.create(fis);
		//Goto existing Sheet on that workbook
		Sheet sh=wb.getSheet("Mysheet");
		//get total data
		int nur=sh.getPhysicalNumberOfRows();
		for(int i=0;i<nur;i++) //row by row
		{
			DataFormatter df=new DataFormatter(); //to take any type of data as String by default
			Row r=sh.getRow(i);
			int nuc=r.getLastCellNum();
			for(int j=0;j<nuc;j++) //cell by cell
			{
				String x=df.formatCellValue(r.getCell(j));
				System.out.print(x+" , ");
				
			}
			System.out.println();
		}
		//close permissions
		fis.close();
		wb.close();
		

	}

}
