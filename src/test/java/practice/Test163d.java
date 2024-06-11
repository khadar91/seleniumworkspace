package practice;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class Test163d {

	public static void main(String[] args) throws Exception {
		XWPFDocument doc=new XWPFDocument();
		//create table with rows and columns
		int numRows=3;
		int numCols=3;
		XWPFTable table=doc.createTable(numRows,numCols);
		
		//set table with (optional)
		table.setWidth("100%");
		//Iterate over the rows and columns to set cell Content
		for(int row=0;row<numRows;row++)
		{
			XWPFTableRow tableRow=table.getRow(row);
			for(int col=0;col<numCols;col++)
			{
				XWPFTableCell tableCell=tableRow.getCell(col);
				XWPFParagraph paragraph=tableCell.addParagraph();
				XWPFRun run=paragraph.createRun();
				run.setText("Row "+(row + 1) + " , Column " + (col + 1));
				
			}
			
		}
		//save the document to a file
		File f=new File("src/test/resources/doc4.docx");
		FileOutputStream fo =new FileOutputStream(f);
		doc.write(fo);
		doc.close();
		fo.close();
		
		
		

	}

}
