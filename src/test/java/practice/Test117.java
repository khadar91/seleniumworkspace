package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test117 {

	public static void main(String[] args) throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//Launch site
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_submit");
		Thread.sleep(10000);// waiting time to load complete page
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.name("fname")).sendKeys("khadar");
		driver.findElement(By.name("lanme")).sendKeys("valli");
		driver.findElement(By.xpath("//input[@value='Submt']")).submit();

	}

}
