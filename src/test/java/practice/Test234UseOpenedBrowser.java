package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Test234UseOpenedBrowser {

	public static void main(String[] args) {
		//connect to existing browser
		ChromeOptions co=new ChromeOptions();
		co.setExperimentalOption("debuggerAddress", "localhost:65449");
		ChromeDriver driver=new ChromeDriver(co);
		driver.findElement(By.name("q")).sendKeys("abdul kalam");

	}

}
