package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test63 {

	public static void main(String[] args) throws Exception
	{
		String q="how are you?";
		// download latest chrome driver siftware 
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//maximize browser window
		driver.manage().window().maximize();
		//launch site
		driver.get("https://www.chatbot.com/");
		Thread.sleep(5000);
		//activate chat bot dailog
		driver.switchTo().frame("chat-widget");
		// driver.findElement(By.xpath(q))
		

	}

}
