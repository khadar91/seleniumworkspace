package practice;

import java.util.Scanner;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test6 {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		System.out.println("Enete Browser Name");
		String bn=scn.nextLine();
		scn.close();
		RemoteWebDriver driver=null;
		if(bn.equals("chrome")||bn.equals("chrme")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.get("http://google.co.in");
		}
		else if(bn.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.get("http://google.co.in");

		}
		else if(bn.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			driver.get("http://flipkart.co.in");
		}
		else {
			System.out.println("please check our browser name");
			System.exit(0);
		}
	}





}

