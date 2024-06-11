package practice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test205 {

	public static void main(String[] args) throws Exception{
		// WebPage Containing testing
		//Take two words/Sentences  from keybaord
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter Word/sententence to be searched");
		String x=scn.nextLine();
		System.out.println("enter a target word/sentence/regular epression");
		String y=scn.nextLine();
		scn.close();
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site under testing(SUT)
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		//search a word
		driver.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
		Thread.sleep(5000);
		//Pagination on result pages
		int currentpageindex=1;
		int total=0;
		while(true) //infinite loop
		{
			try
			{
			//Step-1: get content(inner text) of current result page using JavaScript
			String w=(String) driver.executeScript("return(document.documentElement.innerText);");
			//Step-2: search for target word in that content using Regex
			Pattern p=Pattern.compile(y,Pattern.CASE_INSENSITIVE);
			Matcher m=p.matcher(w);
			//Step-3: Get count of target word's occurrences 
			int now=0;
			while(m.find())
			{
				now++;
			}
			//Step-4: add page level count to total count 
			total=total+now;
			//Step-5: Display page level count
			System.out.println(currentpageindex+"th consist of"+now);
			//Step-6: Go to next page if exists
			driver.findElement(By.xpath("//a[text()='"+(currentpageindex+1)+"']")).click();
			Thread.sleep(2000); 
			currentpageindex++;
		}
		catch(Exception e)
		{
			break; //terminate from current loop
		}
	}
		System.out.println("Total count of results is "+total);
		//close site
		driver.close();
	}
}
