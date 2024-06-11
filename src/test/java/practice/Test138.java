package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test138 {

	public static void main(String[] args) throws Exception
	{
		// Open existing file as Read mode
				File f=new File("src\\test\\resources\\mydata.txt");
				FileReader fr=new FileReader(f);
				//Load file from HDD into Ram as text file
				BufferedReader br=new BufferedReader(fr);
				String line="";
				Pattern p=Pattern.compile("[A-Z][a-z]+"); //GET words with initcap onlyonly in each line
				
				while((line=br.readLine())!=null)// loop terminates after last line reading
				{
					
					Matcher m=p.matcher(line);
					while(m.find())
					{
						System.out.println(m.group());
					}
					
				}
				
				br.close();
				fr.close();

			}

	}


