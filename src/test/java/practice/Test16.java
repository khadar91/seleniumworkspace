package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test16 {

	public static void main(String[] args) throws Exception {
		// open chrome browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("http://www.gmail.com");
		Thread.sleep(5000);
		//locate an emlent in page source
		By b=By.name("hiddenPassword");
		WebElement e=driver.findElement(b);
		
		// 2.if idebtify that element visability on page
		if(e.isDisplayed())
		{
			//3.operate that element
			e.click();
			
		}
		else {
			System.out.println("element found in pages source but not visable in page");
		}

	}

}
