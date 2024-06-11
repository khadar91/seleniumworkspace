 package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test43 {

	public static void main(String[] args) {
		// Vsable program
		//download latest chrome driver software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("http://www.google.co.in");
		
		List<WebElement> l=driver.findElements(By.xpath("//*"));
		System.out.println("All elements count is :"+l.size());
		int vec=0;
		int invec=0;
		for(WebElement e:l) {
			if(e.isDisplayed()) {
				vec=vec+1;
				driver.executeScript("arguments[0].style.border='2px dotted yellow';", e);
			}
			else {
				invec=invec+1;
			}
		}
				System.out.println("Visable element count is "+vec);
				System.out.println("In visable Element is "+invec);
			
		

	}

}
