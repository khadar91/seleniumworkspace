package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test138lowertoupper {

	public static void main(String[] args)throws Exception {
	 //open file as read mode
		File f=new File("src/test/resources/mydata.txt");
		FileReader fr=new FileReader(f);
		//load file  from HDD into Ram
		BufferedReader br=new BufferedReader(fr);
		//get words strat with any case in each line
		Pattern p=Pattern.compile("[A-Za-z][a-z]+");
		List<String> ls=new ArrayList<String>();
		String line=null;
		while((line=br.readLine())!=null)
		{
			Matcher m=p.matcher(line);
			while(m.find())
			{
				System.out.println(m.group());
				ls.add(m.group());
			}
		}
		//convert init lower to init upper
		for(String l:ls)
		{
			char f1=l.charAt(0); //get first letter
			l=l.substring(1); // remove first letter
			if(f1>=97)// if lower
			{
				f1=(char) (f1-32); // change first letter to upper case
			}
			l=f1+l; //add converted first letter to remaining word
			System.out.println(l);	
	    }
	    //close file
	    br.close();
	    fr.close();
		

	}

}
