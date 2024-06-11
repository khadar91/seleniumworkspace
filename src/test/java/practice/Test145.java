package practice;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.testng.annotations.Test;

public class Test145
{
	@Test
public void method1() throws Exception
{
	//open existing file as read mode
		File f1=new File("src/test/resources/myvalues.txt");
		FileReader fr=new FileReader(f1);
		//load file from HDD into Ram 
		BufferedReader br=new BufferedReader(fr);
		//take a new file from write  ode
		File f2=new File("src/test/resources/myoutput.txt");
		FileWriter fw=new FileWriter(f2);
		BufferedWriter bw=new BufferedWriter(fw);
		//take each lne
		String line="";
		while((line=br.readLine())!=null)
		{
			String[] pieces=line.split(",");
			int input1=Integer.parseInt(pieces[0]);
			int input2=Integer.parseInt(pieces[2]);
			if(pieces[1].equalsIgnoreCase("add"))
			{
				String temp=""+(input1+input2);
				bw.write(temp);
				bw.newLine();
			}
			else if(pieces[1].equalsIgnoreCase("subtract"))
			{
				String temp=""+(input1-input2);
				bw.write(temp);
				bw.newLine();
				
			}
			else if(pieces[1].equalsIgnoreCase("multiply"))
			{
				String temp=""+(input1*input2);
				bw.write(temp);
				bw.newLine();
			}
			else 
			{
				String temp=""+(float)input1/(float)input2;
						bw.write(temp);
						bw.newLine();
			}
		}
		 //close 1st file
	    br.close();
	    fr.close();
	    //close 2nd file
	    bw.close();
	    fw.close();
}
}
