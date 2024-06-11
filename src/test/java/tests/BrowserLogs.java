package tests;

import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserLogs {

	public static void main(String[] args) {
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.facebook.com");
		//collect logs
		Set<String> s=driver.manage().logs().getAvailableLogTypes();
		System.out.println(s);
		//get browser logs
		System.out.println("Browser logs");
		LogEntries bl=driver.manage().logs().get("browser");
		for(LogEntry l:bl)
		{
			System.out.println(l.getMessage());
			
		}
		//Driver logs
		System.out.println("Browser software driver logs");
		LogEntries dl=driver.manage().logs().get("driver");
		for(LogEntry l1:dl)
		{
			System.out.println(l1.getMessage());
		}
		//get clint logs(OS , N/W , Memory and other resources)
				System.out.println(" client logs");
				LogEntries cl=driver.manage().logs().get("client");
				for(LogEntry l2:cl)
				{
					System.out.println(l2.getMessage());
				}
				driver.close();
				
	}

}
