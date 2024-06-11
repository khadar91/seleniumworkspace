package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Test8 {

	public static void main(String[] args) {
		//primitive DtataTypes
		int x=60;
		System.out.println(x);// behave like a varible only
		//derived  Data types 2 only(String,array[] concepts)
		String y="java";
		System.out.println(y);// y is bheva like variable
		System.out.println(y.length());// y is behave like oject by calling length() method 
		
		int[] i= {12,13,14};
		System.out.println(i);// i is behave like avarible
	System.out.println(i.length);// and laso behave like obj calling length property
		
		//UserDefined DatatTypes(any class)
	RemoteWebDriver driver;
	driver=new ChromeDriver();
	driver.get("http://www.google.co.in");// drver behave like object only

	}

}
