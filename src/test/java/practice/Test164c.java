package practice;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class Test164c {

	public static void main(String[] args) throws Exception{
		File f=new File("src/test/resources/doc4.docx");
		FileInputStream fi=new FileInputStream(f);
		XWPFDocument doc=new XWPFDocument(fi);
		//specify the index of the table containing the target row
		int ti=0; // 1st table
		int ri=1; // 2nd row
		int ci=2; // 3rd coumn
		List<XWPFTable> tables=doc.getTables();
		XWPFTable table=tables.get(ti);
		List<XWPFTableRow>rows=table.getRows();
		XWPFTableRow row=rows.get(ri);
		List<XWPFTableCell> cells=row.getTableCells();
		XWPFTableCell cell=cells.get(ci);
		System.out.println(cell.getText());
		doc.close();
        fi.close();
		

	}

}
