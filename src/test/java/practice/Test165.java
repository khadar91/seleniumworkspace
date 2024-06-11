package practice;

import java.io.File;
import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;



public class Test165 {

	public static void main(String[] args) throws Exception {
		// add text into new pdf file
		File f=new File("src/test/resources/mypdf.pdf");
		FileOutputStream fo=new FileOutputStream(f);
		Document doc=new Document();
		PdfWriter.getInstance(doc, fo);
		doc.open();
		Font ft=FontFactory.getFont(FontFactory.COURIER,16, BaseColor.BLACK);
		Chunk chunk=new Chunk(" Hello Friend, are you feeling Sleepy?",ft);
		doc.add(chunk);
		doc.close();
		
		

	}

}
