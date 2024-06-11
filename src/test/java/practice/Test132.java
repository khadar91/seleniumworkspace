package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class Test132 {
public static void main(String[] args) throws Exception
{
	// open existing file in inread mode
	File f=new File("src\\test\\resources\\mydata.txt");
	FileReader fr=new FileReader(f);
	// load file  From HHD into  to RAM as text file
	BufferedReader br=new BufferedReader(fr);
	// Get count
	int count=0;
	String line="";
	while((line=br.readLine())!=null) //loop terminate after last line's reading
	{
		count++;
	}
	System.out.println("count of file lines is  ::"+count);
	br.close();
	fr.close();
}
}
