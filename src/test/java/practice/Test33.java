package practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test33 {

	public static void main(String[] args) throws Exception
	{
		//to download latest chrome driver software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("https://www.javatpoint.com/oprweb/test.jsp?filename=javascript-alert1");
		Thread.sleep(5000);
		//switch to frame
		driver.switchTo().frame("iframewrapper");
		driver.findElement(By.xpath("//input[@value='Click me']")).click();
		Alert al=driver.switchTo().alert();
		String x=al.getText();
		System.out.println(x);
		al.dismiss();
		//back to page
		driver.switchTo().defaultContent();
		//close site
		driver.close();

	}

}
