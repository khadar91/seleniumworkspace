package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Test133 {

	public static void main(String[] args)  throws Exception 
	{
		//Open existing file into read mode
		File f=new File("src\\test\\resources\\mydata.txt");
		FileReader fr=new FileReader(f);
		// load file into HDD into Ram as text file
		BufferedReader br=new BufferedReader(fr);
		//Get and Display each line
		String lines="";
		while((lines=br.readLine())!=null)
		{
		System.out.println(lines);
	}
		br.close();
		fr.close();
	}
		

}
