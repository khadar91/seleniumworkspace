package practice;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import utitilities.DivDropDownUtility;

public class Test192 {

	public static void main(String[] args) throws Exception{
		// open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Define wait object
		FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(1000));
		//Launch site
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		//Locate Multi-select drop down developed using <div> tag
		WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[@id='multiple-selection']/following-sibling::div")));
		DivDropDownUtility ddu=new DivDropDownUtility();
		//Test case-1: is it multi-select or not?
		if(ddu.isMultiSelect(e))
		{
			System.out.println("Multi-select drop down");
		}
		else
		{
			System.out.println("Single-select drop down");
		}
		//Test-case-2:get items count
		int n=ddu.getItemsCount(e);
		System.out.println(n);
		//Test case-3: get all items and display
		List<String>l=ddu.getItemsNames(driver, e);
		for(String i:l)
		{
			System.out.println(i.trim()); 
		}
		Thread.sleep(5000);
		//Test case-4: select multiple items
		String[] x= {"HTML","CSS", "Ruby", "Python", "React"};
		ddu.selectedItemsByNames(e, x);
		Thread.sleep(5000);
		List<String> ax=ddu.getAllSelectedItems(e);
		List<String> ex=Arrays.asList(x);
		//compare both lists
		if(ddu.compareTwoList(ex, ax))
		{
			System.out.println("Selection Test passed");
		}
		else
		{
			System.out.println("Selection test failed");
		}
		//Test case-5: deselect multiple items
		String y[]= {"CSS", "Python", "React"};
		ddu.deselectItemsByNames(e, y);
		//close site
		//driver.close();
		
		

	}

}
