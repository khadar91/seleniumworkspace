package practice;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test201 {
	public static void main(String[] args) throws Exception
	{
	//Take value from keyboard
	Scanner scn=new Scanner(System.in);
	System.out.println("Enter Password value::");
	String x=scn.nextLine();
	scn.close();
	//open Browser
	WebDriverManager.chromedriver().setup();
	RemoteWebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://www.facebook.com");
	//Step-1:locate password element and enter a value
	WebElement e=driver.findElement(By.id("pass"));
	e.sendKeys(x);
	Thread.sleep(5000);
	//Step-2: change password box type to "text" to get visibility of given value
	driver.executeScript("arguments[0].setAttribute('type','text');", e);
	Thread.sleep(5000);
	//Step-3: get that visible value
	String y=e.getAttribute("value");
	if(x.equals(y))
	{
		System.out.println("Passsword Making Test passed");
	}
	else
	{
		System.out.println("Passsword Making Test failed");
	}
	}
}
