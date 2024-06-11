package practice;

import java.io.File;
import java.io.FileWriter;
import java.util.Properties;

public class Test146append {

	public static void main(String[] args) throws Exception{
		// create properties class object
		Properties p=new Properties();
		//define key-values pairs
		p.setProperty("testleadname", "abdul kalam123456");
		p.setProperty("testleadEmail", "apj1234567@abdulkalam.com");
		//save a new properties file with those pairs
		File f=new File("src//test//resources//config.properties");
		FileWriter fw=new FileWriter(f,true);// true indicates append mode
		p.store(fw, "Data from jessy");

	}

}
