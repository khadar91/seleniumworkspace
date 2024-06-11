package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test13 {

	public static void main(String[] args)throws Exception {
		// download chrome driver software
		WebDriverManager.chromedriver().setup();
		//open chrome browser using chrome driver software
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("http://www.sentia.in/");//base url
		Thread.sleep(5000);
		//get window handle id of active browser window/tab
		String x=driver.getWindowHandle();
		System.out.println(x);
		//close browser
		driver.close();
		
		

	}

}
