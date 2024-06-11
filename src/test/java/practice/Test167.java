package practice;

import java.io.File;
import java.io.FileInputStream;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

public class Test167 {

	public static void main(String[] args) throws Exception
	{
		// open an existing PDF File in READ File
		File f=new File("src/test/resources/mypdf.pdf");
		FileInputStream fi=new FileInputStream(f);
		PdfReader pr=new PdfReader(fi);
		//Get text of the 1st page
		String x=PdfTextExtractor.getTextFromPage(pr, 1);
		System.out.println(x);
		pr.close();
	

	}

}
