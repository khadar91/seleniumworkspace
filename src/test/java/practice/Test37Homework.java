package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test37Homework {

	public static void main(String[] args)throws Exception
	{
		// download latest chrome driver software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("http://www.flipkart.com");
		//if banner exist to close the banner
		try {
			driver.findElement(By.xpath(
					"//span[text()='Login']/preceding::button[1]")).click();
			Thread.sleep(5000); 
		}
		catch(Exception ex) {
			System.out.println("dont have any banner");
		}
		//click on Beuty link
		driver.findElement(By.xpath("//div[contains(text(),'Beauty')]")).click();
		Thread.sleep(5000);
		//click view All
		driver.findElement(By.xpath("//a[text()='VIEW ALL']/following::div[@class='_30kJiF']")).click();
		Thread.sleep(5000);
		//click on Remotecontroller toys
		driver.findElement(By.xpath("//div[text()='Remote Control Toys']")).click();
		Thread.sleep(5000);
		//switch to handle window
		List<WebElement> all=driver.findElements(By.xpath("//div[text()='Newest First']/following::a[@class='s1Q9rs']"));
		for(int i=0;i<all.size();i++) {
			all.get(i).click();
			//switch to new window/tab
			Set<String>s=driver.getWindowHandles();
			List<String>l=new ArrayList<String>(s);
			driver.switchTo().window(l.get(1));	
			//amount should be display
			String x=driver.findElement(By.xpath("//div[@id='price-info-icon']/preceding::div[@class='_30jeq3 _16Jk6d']")).getText();
			x=x.substring(1);//to take 2nd postion of the string
			x.replaceAll(",","");// to avoid "," 
			System.out.println(x);
			driver.close();
			//switch to default window/tab
			driver.switchTo().window(l.get(0));
		}



	}

}
