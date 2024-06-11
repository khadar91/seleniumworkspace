package practice;

import java.util.Properties;
import java.util.Set;

public class Test149 {

	public static void main(String[] args) {
		// get in-Built properties values given by OS
		Properties p=new Properties();
		Set<Object> keys=p.keySet();
		for(Object key:keys)
		{
			System.out.println(key.toString()+"="+p.getProperty(key.toString()));
		}
		

	}

}
