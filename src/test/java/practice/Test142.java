package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Test142
{
	public static void main(String[] args) throws Exception
	{
		//Open existing file in read mode
		File f=new File("src\\test\\resources\\myvalues.txt");
		FileReader fr=new FileReader(f);
		//Load file from HDD into RAm as text file
		BufferedReader br=new BufferedReader(fr);
		//vrify each line is duplate
		List<String> lines=new ArrayList<String>();
		String line="";
		while((line=br.readLine())!=null)
		{
			int flag=0;
			//compare new line with existing lines to skip duplicates
			for(int i=0;i<lines.size();i++)
			{
				if(line.equalsIgnoreCase(lines.get(i)))
				{
					flag=1;
							break;
				}
			}
				if(flag==0)
				{
					lines.add(line);
				}
			}
		//close the read mode
		br.close();
		fr.close();
		
		//Open same file in write mode(Existing data will be overwritten)
	    FileWriter fw=new FileWriter(f);  
        BufferedWriter bw=new BufferedWriter(fw);
        for(int i=0;i<lines.size();i++)
        {
        	bw.write(lines.get(i));
        	bw.newLine();
        }
        //close file in write mode
        bw.close();
        fw.close();
	}
}
