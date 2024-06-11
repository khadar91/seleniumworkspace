package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test38 {

	public static void main(String[] args) throws Exception{
		// download latest chrome driver software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("http://www.yahoomail.com");
		Thread.sleep(5000);
		//do login
		driver.findElement(By.linkText("Sign in")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("login-username")).sendKeys("standardenterprises1");
		Thread.sleep(5000);
		driver.findElement(By.id("login-signin")).click();
		Thread.sleep(5000);	
		driver.findElement(By.id("login-passwd")).sendKeys("saleem123");
		Thread.sleep(5000);
		driver.findElement(By.id("login-signin")).click();
		Thread.sleep(5000);
		//click on Compose button
		driver.findElement(By.linkText("Compose")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("message-to-field")).sendKeys("sampleprogram12@fastmail.com");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@aria-label='Subject']")).sendKeys("hidding selenium java");
		Thread.sleep(5000);
		//text body
		driver.findElement(By.xpath("//div[@aria-label='Message body']")).sendKeys("Hi student,\nhow are you\ni hope u r deep sleep");
		Thread.sleep(5000);
		//attach file in file uploding
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("E:\\notes7.txt");
		Thread.sleep(5000);
		//Click on send mail
		driver.findElement(By.xpath("//button[@title='Send this email']")).click();
		Thread.sleep(2000);
		String x=driver.findElement(By.xpath("//div[@role='presentation']/following-sibling::div[1]")).getText();
		//switch to new window/tab
		driver.switchTo().newWindow(WindowType.WINDOW);
		Set<String> s=driver.getWindowHandles();
		List<String> l=new ArrayList<String>(s);
		//switch to that window
		driver.switchTo().window(l.get(1));
		//launch fastmail site
		driver.get("http://www.fastmail.com");
		//do Login fiels
		driver.findElement(By.xpath("//strong[text()='Log in']/parent::a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sampleprogram12");
		driver.findElement(By.name("password")).sendKeys("vallikhadar15");
		//click login button
		driver.findElement(By.xpath("//span[text()='Log in']/parent::button")).click();
		Thread.sleep(5000);
		String y=driver.findElement(By.xpath(
				"//ul[contains(@class,'Mailbox')]/li[1]/a/div/span/span")).getAttribute("title");
		if(y.equals("standardenterpeises1@yahoo.com")) {
			System.out.println(" From address Test is passed");
		}
		else {
			System.out.println(" From address Test is failed");
		}
		//test Subject latest mail in mailbox
		String z=driver.findElement(By.xpath("//ul[contains(@class,'Mailbox')]/li[1]/a/div[4]")).getAttribute("title");
		if(z.equals("hidding selenium java")) {
			System.out.println("subjcet is same test is passed");
		}
			else {
				System.out.println("subject is not same test is failed");
		}
		//Log out for fastmail
		driver.findElement(By.xpath("//div[contains(@class,'MainNavToolbar')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.linkText("Log out")).click();
		Thread.sleep(5000);
		//back to yahoomail
		driver.switchTo().window(l.get(0));
		Thread.sleep(5000);
		//logout to yahoo 
		driver.findElement(By.id("ybarAccountMenu")).click();
		Thread.sleep(5000);
		driver.findElement(By.id("profile-signout-link")).click();
		Thread.sleep(5000);
		driver.close();
		

		
		
		
		
		
		
		


	}

}
