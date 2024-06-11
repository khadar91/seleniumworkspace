package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Test162 {

	public static void main(String[] args)throws Exception {
		//Connect existing file in project folder
		File f=new File("src\\test\\resources\\mybook.xlsx");
		//Take read permissions on that file
		FileInputStream fi=new FileInputStream(f);
		//create Workbook object
		Workbook wb=WorkbookFactory.create(fi);
		//get sheet1 name and take rows count and columns count
		Sheet sh=wb.getSheet("Sheet1");
		int nor=sh.getPhysicalNumberOfRows();
		int noc=sh.getRow(0).getLastCellNum();
		//Row sum
		for(int i=0;i<nor;i++) //row wise
		{
			DataFormatter df=new DataFormatter();
			int rowsum=0;
			for(int j=0;j<noc;j++)
			{
				String temp=df.formatCellValue(sh.getRow(i).getCell(j));
				int x=Integer.parseInt(temp);
				rowsum=rowsum+x;
			}
			sh.getRow(i).createCell(noc).setCellValue(rowsum);
		}
		//column sum
		for(int i=0;i<noc;i++) //column wise
		{
			DataFormatter df=new DataFormatter();
			int colsum=0;
			for(int j=0;j<nor;j++)
			{
				String temp=df.formatCellValue(sh.getRow(j).getCell(i));
				int x=Integer.parseInt(temp);
				colsum=colsum+x;
			}
			if(i==0) // create row for 1st time only
			{
				sh.createRow(nor).createCell(i).setCellValue(colsum);
			}
			else
			{
				sh.getRow(nor).createCell(i).setCellValue(colsum);
			}
		}
//Take Write permission on that file
		FileOutputStream fo=new FileOutputStream(f);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

}
