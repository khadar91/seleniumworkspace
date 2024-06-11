package practice;

import java.io.File;
import java.io.FileOutputStream;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class Test163b {

	public static void main(String[] args) throws Exception {
		// create new word document
		XWPFDocument doc=new XWPFDocument();
		//create centered heading
		XWPFParagraph title=doc.createParagraph();
		title.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun titleRun=title.createRun();
		titleRun.setText("Selenium WebDriver JAVA");
		titleRun.setBold(true);
		titleRun.setFontSize(16);
		//create Paragraph with italic sized text
		XWPFParagraph para=doc.createParagraph();
		XWPFRun run=para.createRun();
		run.setText("This is a Website Functional test automation library .");
		run.setItalic(true);;
		run.setFontSize(11);
		//save in HDD
		File f=new File("src/test/resources/doc2.docx");
		FileOutputStream fo=new FileOutputStream(f);
		//sve
		doc.write(fo);
		doc.close();
		fo.close();
		

		

	}

}
