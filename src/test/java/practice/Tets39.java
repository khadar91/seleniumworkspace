package practice;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tets39 {

	public static void main(String[] args) throws Exception {
		//download latest chrome driver software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("http://www.facebook.com");
		Thread.sleep(5000);
		//to get active element(Email id)
		driver.switchTo().activeElement().sendKeys("abdulkalam",Keys.TAB);
		Thread.sleep(5000);
		//fill activate element (login button)
		driver.switchTo().activeElement().sendKeys("batch264",Keys.TAB,Keys.TAB);
		//click on actvateElement on(login button)
		driver.switchTo().activeElement().click();
		
		

	}

}
