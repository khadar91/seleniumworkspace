package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Test155 {

	public static void main(String[] args) throws Exception {
		// Connect existing file in HDD
		File f=new File("src\\test\\resources\\numdata.xlsx");
		//Take read permissions
		FileInputStream fs=new FileInputStream(f);
		//Consider that file as excel file(workbook)and shit into ram
		Workbook wb=WorkbookFactory.create(fs);
		//goto existing sheet in that workbook
		Sheet sh=wb.getSheet("Sheet1");
		//get all type of data
		int nor=sh.getPhysicalNumberOfRows();
		//(index=0)1st row names of columns
		for(int i=1;i<nor;i++)
		{
			DataFormatter df=new DataFormatter(); //
			Row r=sh.getRow(i);
			String x=df.formatCellValue(r.getCell(0));
			int a=Integer.parseInt(x);
			String y=df.formatCellValue(r.getCell(1));
			int b=Integer.parseInt(y);
			r.createCell(2).setCellValue(a+b);
			r.createCell(3).setCellValue(a-b);
			r.createCell(4).setCellValue(a*b);
			r.createCell(5).setCellValue((float)a/b);
		}
		//take write permissions and save changes
		FileOutputStream fos=new FileOutputStream(f);
		wb.write(fos);
		fos.close();
		fs.close();
		wb.close();

	}

}
