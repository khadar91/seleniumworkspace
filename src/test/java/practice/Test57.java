package practice;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test57 {

	public static void main(String[] args) throws Exception 
	{
		// download latest chrome driver software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//launch site
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		//collect multi -select dropdown in pagesorce
		WebElement dd=driver.findElement(By.xpath("(//select[@name='skills'])[1]/parent::div"));
		//scroll up that element to top of the screen
		driver.executeScript("arguments[0].scrollIntoView();",dd);
		Thread.sleep(5000);
		//open that dropdown
		dd.click();
		Thread.sleep(500);
		//collect all items in drop down and select each one
		List<WebElement> items=dd.findElements(By.xpath(
				"child::div[contains(@class,'menu')]/div"));
		//select each item in that multi-select drop down
		for(WebElement item:items) {
			item.click();
			Thread.sleep(5000);
		}
		//deselectd in selected items
		List<WebElement> selecteditems=dd.findElements(By.xpath("child::a"));
		for(WebElement selecteditem:selecteditems) {
			selecteditem.findElement(By.xpath("child::i")).click();
			Thread.sleep(5000);
		}

	}

}
