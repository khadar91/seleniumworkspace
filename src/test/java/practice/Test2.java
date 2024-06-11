package practice;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2 {

	public static void main(String[] args) throws InterruptedException {
		
		
		//download msedge driver software
		//WebDriverManager.edgedriver().setup();
		
		WebDriverManager.firefoxdriver().setup();
		
		//open edge browser using that browser driver software
		//EdgeDriver driver=new EdgeDriver();
		FirefoxDriver driver=new FirefoxDriver();
		
		//launche site
		driver.get("http://www.google.co.in");
		
		//wait few seconds
		Thread.sleep(5000);
		
		//close the browser window
		driver.close();
		
	
		

	}

}
