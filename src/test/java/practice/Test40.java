package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test40 {

	public static void main(String[] args)  throws Exception{
		// download latest chrome driver software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//intatial lunch site
		driver.get("https://www.google.co.in");
		Thread.sleep(5000);
		//create  new tab
		driver.switchTo().newWindow(WindowType.TAB);
		Thread.sleep(5000);
		//collect window handle values(String) in winow/tab
		Set<String> s=driver.getWindowHandles();//sequentatial set
		List<String> l=new ArrayList<String>(s);//randam list
		//Switch to 2nd tab
		driver.switchTo().window(l.get(1));
		//launch gmail site
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		//craete new window
		driver.switchTo().newWindow(WindowType.WINDOW);
		Thread.sleep(5000);
		//collect window handles im window/tab
		s=driver.getWindowHandles();
		l=new ArrayList<String>(s);
		//switch 3rd window
		driver.switchTo().window(l.get(2));
		Thread.sleep(5000);
		//launch site
		driver.get("http://fastmail.com");
		Thread.sleep(5000);
		//close all window/tab
		driver.quit();

	}

}
