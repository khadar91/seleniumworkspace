package practice;

import java.io.File;
import java.io.FileWriter;
import java.util.Properties;

public class Test146 {
	public static void main(String[] args) throws Exception {
		// create properties file object
		Properties p=new Properties();
		//define key-value pairs
		p.setProperty("name", "abdul kalam");
		p.setProperty("email", "apj@abdulukalam@gmail.com");
		//Save a new properties file with those pairs
		File f=new File("src//test//resources//config.properties");
		FileWriter fw=new FileWriter(f);//write mode
		p.store(fw, "My result properties file");

	}

}
