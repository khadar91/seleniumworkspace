package practice;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

public class Test147 {

	public static void main(String[] args) throws Exception {
		// read from existing properties file
		File f=new File("src\\test\\resources\\config.properties");
		FileReader fr=new FileReader(f);
		//create properties file object
		Properties p=new Properties();
		//loda key-values
		p.load(fr);
		System.out.println("Content properties file is "+ p.keySet().size());
		System.out.println(p.getProperty("name"));
		System.out.println(p.getProperty("testleadEmail"));

	}

}
