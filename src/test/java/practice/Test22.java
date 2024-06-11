package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test22 {

	public static void main(String[] args)throws Exception
	{
		// download latest chrome driver software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
	/*	//launch site
		driver.get("https://the-internet.herokuapp.com/iframe");
		Thread.sleep(5000);
		//get visibale text
		driver.switchTo().frame(0);
		String s=	driver.findElement(By.tagName("p")).getText();
		System.out.println(s);
		//back to page
		driver.switchTo().defaultContent();
		//close site
		driver.close();*/
		driver.get("https://risk.lexisnexis.com/corporate/careers");
		driver.findElement(By.xpath("//a[@class='score-button hidden-xs hidden-sm']"));
		//Automate notifications pop window(Sikulix)
				ImagePath.add(System.getProperty("user.dir"));
				Screen s=new Screen();
				if(s.exists("src\\test\\resources\\images\\Searchjobs.png",2000)!=null);
				{
					s.click("src\\test\\resources\\images\\Searchjobs.png");
					
				}

	}

}
