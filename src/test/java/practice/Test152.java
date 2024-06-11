package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Test152 {

	public static void main(String[] args) throws Exception {
		// Connecting existing excel file either(.xls file or .xlsx file) in HDD
		File f=new File("src\\test\\resources\\exceldata.xlsx");
		//Take Read Permission on that File
		FileInputStream fs=new FileInputStream(f);
		//Consider that file as Excel File(workbook) and shift it RAM
		Workbook wb=WorkbookFactory.create(fs);
		//collect all sheets(Spread sheets) in that workbook
		int nos=wb.getNumberOfSheets();
		System.out.println(nos);
		//Goto Each sheet
		for(int i=0;i<nos;i++) // from first sheet to last sheet
		{
		Sheet sh=wb.getSheetAt(i);
		 String shn=sh.getSheetName();
		 try {
			int nur= sh.getPhysicalNumberOfRows();
			int nuc=sh.getRow(0).getLastCellNum();
			System.out.println(shn+" has "+nur+ " rows and "+nuc+ " columns ");
		 }
		 catch(NullPointerException ex)
		 {
			 System.out.println(shn+" is empty");
			 
		 }
		 //close permission
		 wb.close();
		 fs.close();
			
		}
		
		

	}

}
