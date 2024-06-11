package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test5 {

	public static void main(String[] args) throws Exception {
		//download latest chrome driver software and open chrome browse(WDM)
		WebDriver driver=WebDriverManager.chromedriver().create();
		
		/*WebDriver driver=WebDriverManager.firefoxdriver().create();*/
		driver.get("http://google.co.in");
		Thread.sleep(5000);
		driver.close();
		
		
		

	}

}
