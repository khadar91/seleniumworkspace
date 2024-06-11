package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Tesy135 {

	public static void main(String[] args) throws Exception
	{
		//Open file as read mode
		File f=new File("src\\test\\resources\\mydata.txt");
		FileReader fr=new FileReader(f);
		//Load file from HDD into as text file
		BufferedReader br=new BufferedReader(fr);
		//get count of words in each file
		String line="";
		int ln=1;
		while((line=br.readLine())!=null)
		{
			String pieces[]=line.split(" ");
			if(ln==1)
			{
				System.out.println("1st line as "+pieces.length+" words");
			}
			else if(ln==2)
			{
				System.out.println("2nd line as "+pieces.length+" words");
			}
			else if(ln==3)
			{
				System.out.println("3rd line as "+pieces.length+" words");
			}
			else
			{
				System.out.println(ln+"th line as "+pieces.length+" words");
			}
			ln++;//goto next line
		}
		br.close();
		fr.close();

	}

}
