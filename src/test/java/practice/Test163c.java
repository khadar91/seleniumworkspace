package practice;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class Test163c {

	public static void main(String[] args) throws Exception{
		XWPFDocument doc=new XWPFDocument();
		//create a paragraph with bullet points
		XWPFParagraph para=doc.createParagraph();
		para.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun run=para.createRun();
		run.setText("\u2713 Item 1");
		run.addBreak(BreakType.TEXT_WRAPPING);
		run=para.createRun();
		run.setText("\u2605 Item 2");
		run.addBreak(BreakType.TEXT_WRAPPING);
		run=para.createRun();
		run.setText("\u25B6 Item 3");
		run.addBreak(BreakType.TEXT_WRAPPING);
		//save in HDD
		File f=new File("src/test/resources/doc3.docx");
		FileOutputStream fo=new FileOutputStream(f);
		doc.write(fo);
		doc.close();
		fo.close();
		

	}

}
