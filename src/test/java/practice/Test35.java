package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test35 {

	public static void main(String[] args)throws Exception
	{
		// download latest chome driver software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");

		//part::1

		//click ona link
		//switch to frame
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.partialLinkText("Visit W3Schools")).click();
		Thread.sleep(5000);
		//back to page
		driver.switchTo().defaultContent();
		//goto 2nd window/tab
		Set<String> s=driver.getWindowHandles();
		List<String> l=new ArrayList<String>(s);
		driver.switchTo().window(l.get(1));
		driver.findElement(By.linkText("Log in")).click();	
		Thread.sleep(5000);

		//part2
 
		driver.switchTo().window(l.get(0));
		driver.findElement(By.partialLinkText("Get your")).click();
		Thread.sleep(5000);
		//goto 3rd window/tab
		//recollect window handles once again due to new tab/window opened
		s=driver.getWindowHandles();
		l=new ArrayList(s);
		driver.switchTo().window(l.get(2));
		driver.findElement(By.linkText("Log in")).click();
		Thread.sleep(5000);

		//part 3
		//back to first browser window/tab
		driver.switchTo().window(l.get(0));
	}

}
