package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test44 {

	public static void main(String[] args) throws Exception{
		// download latest chrome driver software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("http://google.co.in");
		Thread.sleep(5000);
		//list links on page source 
		List<WebElement> l=driver.findElements(By.tagName("a"));
		System.out.println("All Elenments an tagname of a "+l.size());
		int vec=0;
		int ivec=0;
				
		for(WebElement e:l) {
			if(e.isDisplayed()) {
				vec=vec+1;
				driver.executeScript("arguments[0].style.border='2px dotted yellow';", e);
			}
			else {
				ivec=ivec+1;
				
			}
		}
			System.out.println("visable Elements is "+vec);
			System.out.println("Invisable elements is "+ivec);
//close site
			driver.close();
	}

}
