package practice;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class Test164b {

	public static void main(String[] args) throws Exception {
		//File in Read mode
		File f=new File("src/test/resources/doc1.docx");
		FileInputStream fi=new FileInputStream(f);
		XWPFDocument doc=new XWPFDocument(fi);
		//specify Paragraph of index we want to retrieve(Zero-Based)
		int paraindex=0; // Change this to the desired index
		List<XWPFParagraph> paras=doc.getParagraphs();
		if(paraindex >=0 && paraindex <paras.size())
		{
			//Retrieve the specific paragraph
			XWPFParagraph specificpara=paras.get(paraindex);
			System.out.println(specificpara.getText());
		}
		else
		{
			System.out.println("Invalid paragraph index");
		}
		doc.close();
		fi.close();
		
		
		
		

	}

}
