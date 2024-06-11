package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.testng.annotations.Test;

public class Test128 {
	@Test
	public void method1() throws Exception
	{
		//convert original File  into to ZIP File
		File filetozip=new  File("E:\\selenium\\E__Model Resume Exp.doc");
		FileInputStream fis=new FileInputStream(filetozip);
		File zipfile =new File("E:\\selenium\\E__Model Resume Exp.zip");
		FileOutputStream fileOutput=new FileOutputStream(zipfile);
		ZipOutputStream zipOutput=new ZipOutputStream(fileOutput);
		ZipEntry zipEntry=new ZipEntry(filetozip.getName());
		zipOutput.putNextEntry(zipEntry);
		byte[] bytes=new byte[1024];
		int length;
		while((length=fis.read(bytes))>=0)
		{
			zipOutput.write(bytes, 0, length);
		}
		zipOutput.close();
		fis.close();
		fileOutput.close();
		System.out.println("zip complete:");
	}
}



