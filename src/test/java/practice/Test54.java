package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test54 {

	public static void main(String[] args)  throws Exception
	{
		//download latest chrome driver software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("https://www.fastmail.com");
		//do login
		driver.findElement(By.xpath("//strong[text()='Log in']/parent::a")).click();
		Thread.sleep(10000);
		//enter uuser name and password
		driver.findElement(By.name("username")).sendKeys("sampleprogram12");
		driver.findElement(By.name("password")).sendKeys("vallikhadar15");
		driver.findElement(By.xpath("//span[text()='Log in']/parent::button")).click();;
		Thread.sleep(5000);
		//click on compose
		driver.findElement(By.xpath("//span[text()='Compose']/parent::a")).click();
		//collect all emenets in text boxes
		List<WebElement> l1=driver.findElements(By.xpath(
				"(//input[@type='text'])|(//textarea)|(//div[@role='textbox'])"));
		System.out.println("List of all textbox elements are "+l1.size());
		int vis=0;
		int invis=0;
		for(WebElement ele:l1) {
				if(ele.isDisplayed()) {
					vis++;
				}
				else {
					invis++;
				}
				
			}
			System.out.println("all visable text boxes are "+vis);
			System.out.println("all are hidden boxes are "+invis);
			
		}
		
	}


