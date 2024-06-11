
package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test23
{

	public static void main(String[] args) throws Exception
	{
		// download latest chrome driver software
		WebDriverManager.chromedriver().setup();
		//chromeDriver() constructor method runs chrome driver software to open chrome browser
		//and ChromeDriver() constructor nethod is useful to create "driver" object
		RemoteWebDriver driver=new ChromeDriver();
		//open site
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_file");
		Thread.sleep(5000);
		//locate an ememnt page source code
		//file uploading
		driver.switchTo().frame("iframeResult");//goto specific frame level
		driver.findElement(By.name("myfile")).sendKeys("C:\\Users\\HP\\Downloads\\gmailuiddata.txt");
		driver.findElement(By.xpath("//input[@type='submit'][1]")).click();
		driver.switchTo().defaultContent();//back to page
	}

}
