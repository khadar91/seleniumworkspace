package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Test134 {

	public static void main(String[] args)throws Exception
	{
		// open exist file as readmode
		File f=new File("src\\test\\resources\\mydata.txt");
		FileReader fr=new FileReader(f);
		//load file from HDD into ram as a text file
		BufferedReader br=new BufferedReader(fr);
		int count=0;
		String line="";
		while((line=br.readLine())!=null) //loop terminates after last lines'reading
		{
			count++;
		
		if(count==1||count==3||count==5)
		{
			System.out.println(line);
		}
		}
		br.close();
		fr.close();
	}
}

