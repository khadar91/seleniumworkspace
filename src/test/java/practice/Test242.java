package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test242 {

	public static void main(String[] args) throws Exception {
		// Open Browser and Launch site
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.spicejet.com");
		//Automate notifications pop window(Sikulix)
		ImagePath.add(System.getProperty("user.dir"));
		Screen s=new Screen();
		if(s.exists("src\\test\\resources\\images\\block.png",2000)!=null);
		{
			s.click("src\\test\\resources\\images\\block.png");
			
		}
		
		
		
		//close site
		driver.close();
		

	}

}
