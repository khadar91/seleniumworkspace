package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.testng.annotations.Test;

public class Test129 {
	@Test
	public void method1() throws Exception
	{
		String zipFilepath="E:\\selenium\\chromedriver-win64.zip";
		String unzipDirectory="E:\\selenium";
		// to create a FileinputStream to read the ZIP file
		FileInputStream fis=new FileInputStream(zipFilepath);
		// create zipnputStream to read the ZIP file
		ZipInputStream zis=new ZipInputStream(fis);
		//create a buffer read data from the ZIP file
		byte[] buffer=new byte[1024];
		// Loop through the entries in the ZIP file
		ZipEntry entry;
		while((entry=zis.getNextEntry())!=null)
		{
			String entryName=entry.getName();
			String entryPath=unzipDirectory +File.separator +entryName;
			//create  directories if they don't exist
			File entryFile =new File(entryPath);
			if(entry.isDirectory())
			{
				entryFile.mkdir();
			}
			else
			{
				//create parent directories if they don't exist
				File parent=entryFile.getParentFile();
				if(parent!=null && !parent.exists())
				{
					parent.mkdirs();
				}
				//write the entry's data to the file
				FileOutputStream fos=new FileOutputStream(entryFile);
				int bytesRead;
				while((bytesRead=zis.read(buffer))!=-1)
				{
					fos.write(buffer, 0, bytesRead);
				}
				fos.close();
			}
		}
		//close the ZipInputStream and FileInputStream
		zis.close();
		fis.close();
		System.out.println("UNZP Completed::");
	}

}
 
