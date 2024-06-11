package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test14 {

	public static void main(String[] args)  throws Exception
	{
		// download chrome driver software
		WebDriverManager.chromedriver().setup();
		//open chrome browser 
		RemoteWebDriver driver=new ChromeDriver();
		//lunchig site
		driver.get("http://www.w3schools.com"); //base url
		Thread.sleep(5000);
		//click on a button
		driver.findElement(By.linkText("Try it Yourself")).click();
		Thread.sleep(5000);
		//to get Window handle ids of all browser windows or tabs
		Set<String> x=driver.getWindowHandles();
		System.out.println(x);
		//Switch to 2nd tab
		List<String> l=new ArrayList<String>(x);
		driver.switchTo().window(l.get(1));
		//close 2nd window/tab
		driver.close();
		Thread.sleep(5000);
		//Switch back 1st tab
		driver.switchTo().window(l.get(0));
		//close tab
		driver.close();


	}

}
