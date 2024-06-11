package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test73 {

	public static void main(String[] args) {
		// downloading latest chrome browser software
		WebDriverManager.chromedriver().setup();
		//open beowser window using that driver software
		RemoteWebDriver driver=new ChromeDriver();
		//Maximize the browser window
		driver.manage().window().maximize();
		//launch site(SWD code waits for complete loading of the page by default
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
		//define implicit wait at top of the automation code for wait if reaquired
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		//switch to frame
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.name("fname")).clear();
		driver.findElement(By.name("fname")).sendKeys("abdul");
		driver.findElement(By.name("lname")).clear();
		driver.findElement(By.name("lname")).sendKeys("kalam");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.switchTo().defaultContent();
		//close site
		//driver.close();
		

	}

}
