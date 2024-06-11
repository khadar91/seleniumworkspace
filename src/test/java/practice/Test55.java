package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test55 {

	public static void main(String[] args)throws Exception
	{
		// download laterst chrome driver software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		//collect all dropdowns in a pagesourxe
		List<WebElement> l=driver.findElements(By.xpath("//div[@class='ui active tab']/div/div[contains(@class,'dropdown')]"));
		System.out.println("count of all dropdowns : "+l.size());
		//open 3rd dropdown
		l.get(2).click();
		Thread.sleep(5000);
		//select 2nd item
		l.get(2).findElement(By.xpath("//div/child::div[contains(@class,'menu transition visible')]/div[2]")).click();
		Thread.sleep(5000);
		//open 4th dropdown
		l.get(3).click();
		Thread.sleep(5000);
		//select in 6th item
		l.get(3).findElement(By.xpath("//div[text()='Select Friend']/following::div[contains(@class,'menu')]/div[6]")).click();
		Thread.sleep(5000);
		//close site
		//driver.close();

	}

}
