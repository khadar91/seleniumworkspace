package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test37 {

	public static void main(String[] args) throws Exception {
		// download chrome driver software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("https://www.flipkart.com/");
		//close banner is exist
		try {
			driver.findElement(By.xpath("//span[text()='Login']/preceding::button[1]")).click();
		}
		catch(Exception e) {
			System.out.println("banner does not exist");
		}
		//part 1:
		//click on beauty link
		driver.findElement(By.xpath("//div[contains(text(),'Beauty')]")).click();
		Thread.sleep(5000);
		//click on viewall
		driver.findElement(By.linkText("VIEW ALL")).click();
		Thread.sleep(5000);
		//click on mirror-less camera
		driver.findElement(By.xpath("//div[contains(text(),'Top Mirrorless Cameras')]")).click();
		Thread.sleep(5000);
		//all displayed models in current page
		List<WebElement> all=driver.findElements(By.xpath("//div[text()='Newest First']/following::a[@class='_1fQZEK']"));
		for(int i=0;i<all.size();i++) {
			all.get(i).click();
		
		//switch to newly opened  2nd window/tab
		Set<String> s=driver.getWindowHandles();
		List<String> l=new ArrayList<String>(s);
		driver.switchTo().window(l.get(i+1));
		//get price to display amount
		String x=driver.findElement(By.xpath("//div[@id='price-info-icon']/preceding::div[@class='_30jeq3 _16Jk6d']")).getText();
		
		x=x.substring(1);// take 2nd position to avod the currency symbal
		x=x.replaceAll(",",""); //replae "," to null
		System.out.println(x);
		//close the window/tab
		driver.close();
		//back to previous page
		driver.switchTo().window(l.get(0));
		Thread.sleep(5000);
		
		}
		//close the site
		driver.quit();
		

	}

	}

