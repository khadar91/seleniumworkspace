package practice;

import java.io.File;
import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test189 {

	public static void main(String[] args) throws Exception {
		// single select drop-down developing <slect tag>
		//open Browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//define wait object
		FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(1000));
		//Launch site
		driver.get("https://www.amazon.in/");
		//Automate <Select> tag drop down
		Thread.sleep(5000);
		WebElement e=driver.findElement(By.id("searchDropdownBox"));
		Select s=new Select(e);
		//Test case-1: is it multi select or not ?
		if(s.isMultiple())
		{
			System.out.println("Multi-Select Drop Down");
		}
		else
		{
			System.out.println("Single-Select Drop Down");
		}
		//Test case-2 Get all items and Display
		List<WebElement> l=	s.getOptions();
		System.out.println("Count of all items in Selectct drop down :"+l.size());
		for(WebElement i:l)
		{
			System.out.println(i.getText());
		}
		//Test Case-3: Select an item
		System.out.println("Selected by index");
		//s.selectByIndex(9);
		s.selectByVisibleText("Garden & Outdoors");
		Thread.sleep(5000);
		//s.selectByValue("search-alias=industrial"); //copied from source code given by Dev team
		//Test case-4: get screen shot of drop down
		File src=s.getWrappedElement().getScreenshotAs(OutputType.FILE);
		File dest=new File("target/dropdown.png");
		FileHandler.copy(src, dest);
		//close site 
		driver.close();
		}

	}

