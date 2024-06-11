package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test11 {

	public static void main(String[] args)throws Exception {
		// download Chrome Driver software
		WebDriverManager.chromedriver().setup();
		// open chrome driver software
		RemoteWebDriver driver=new ChromeDriver();
		//open brwser
		driver.get("http://www.sentia.in/");
		//wait few seconds
		Thread.sleep(5000);
		//get current url
				String x=driver.getCurrentUrl();
				if(x.startsWith("https"))
						{
					System.out.println("is secured");
				}
					else {
						System.out.println("unsecured");
						
					}
					
			//close the broser
			driver.close();

	}
}


