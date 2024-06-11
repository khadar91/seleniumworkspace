package practice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class Test163e {

	public static void main(String[] args)throws Exception {
		XWPFDocument doc=new XWPFDocument();
		//create paragraph on document
		XWPFParagraph para=doc.createParagraph();
		//add run to paragraph
		XWPFRun run=para.createRun();
		//Specify the path of the image file
		String imagePath="target\\myelement.png";
		//Load to the image File to InputStream
		InputStream imageStream=Files.newInputStream(Path.of(imagePath));
		//Add image to the run
		run.addPicture(imageStream, XWPFDocument.PICTURE_TYPE_PNG, "mtelement.png", Units.toEMU(200),Units.toEMU(100));
		// Parameters: InputStream, Picture Type (JPEG, PNG, etc.), Image Filename, Width, Height
        // Close the InputStream
		imageStream.close();
		//save document to the file
		File f=new File("src/test/resources/doc5.docx");
		FileOutputStream fo=new FileOutputStream(f);
		doc.write(fo);
		doc.close();
		fo.close();
		
		

	}

}
