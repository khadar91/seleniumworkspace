package practice;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test58
{
	public static void main(String[] args) throws Exception
	{
		//Open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver(); 
		driver.manage().window().maximize();
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter a word :");
		String x=scn.nextLine();
		//Launch site
		driver.get("https://www.google.co.in");
		//Enter a value
		driver.findElement(By.name("q")).sendKeys(x);
		Thread.sleep(5000);
		//test a cache item as per given value
		List<WebElement> suggestions=driver.findElements(By.xpath("//ul[@role='listbox'][1]/li"));
		int flag=0;
		for(WebElement suggestion:suggestions) {
			String y=suggestion.getText();
			y=y.toLowerCase();
			y=y.replace(" ", "");
			x=x.toLowerCase();
			x=x.replace(" ", "");
			if(!y.contains(x)) {
			System.out.println(y);
			flag=1;
			}
		}
		if(flag==0) {
			System.out.println("All suggestions are correct");
		}
		else {
			System.out.println("All suggestions are incorrect");
		}
		//close site
		
	}
}





