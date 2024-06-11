package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {

	public static void main(String[] args) throws InterruptedException {
	/*	//download chrome driver software
		WebDriverManager.chromedriver().setup();
		
		//open chrome browser using that browser driver software
		ChromeDriver driver=new ChromeDriver();*/
		
		//download latest geck drivers software
		WebDriverManager.firefoxdriver().setup();
		
		//and open firefox driver using that brwser driver s/w
		FirefoxDriver driver=new FirefoxDriver();
		
		
		//lainch site
		driver.get("http://www.google.co.in");
		
		//wait few seconds
		Thread.sleep(5000);
		
		//close the browser window
		driver.close();
		
		
		
	}

}
