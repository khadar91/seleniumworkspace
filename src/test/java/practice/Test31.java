package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test31 {

	public static void main(String[] args) throws Exception
	{
		// download chrome driver software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("https://www.javatpoint.com/oprweb/test.jsp?filename=javascript-alert1");
		Thread.sleep(5000);
		//switch to frame
		driver.switchTo().frame("iframewrapper");
		//automate alert
		driver.findElement(By.xpath("//input[@value='Click me']")).click();
		Thread.sleep(5000);
		String x=driver.switchTo().alert().getText();
		System.out.println(x);
		driver.switchTo().alert().dismiss();
		//back to page
		driver.switchTo().defaultContent();
		//close page
		driver.close();

	}

}
