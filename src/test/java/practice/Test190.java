package practice;



import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test190 {

	public static void main(String[] args) throws Exception {
		// open Browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//define wait object
		FluentWait<RemoteWebDriver> wait=new FluentWait<RemoteWebDriver>(driver);
		wait.withTimeout(Duration.ofSeconds(20));
		wait.pollingEvery(Duration.ofMillis(1000));
		//Launch site
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		//Automate <select> tag drop-down
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.id("iframeResult")));
		WebElement e=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cars")));
		//Test Case-1: is it multy select or not
		Select s=new Select(e);
		if(s.isMultiple())
		{
			System.out.println("It is Mtlti-Select Drop Down");
		}
		else
		{
			System.out.println("It is Single select Drop Down");
		}
		
		//Test case-2:get all items and display
		List<WebElement> l=s.getOptions();
		System.out.println("Count og all drop down list are:"+l.size());
		System.out.println("All items are ");
		System.out.println("---------------------");
		for(WebElement i:l)
		{
		System.out.println(i.getText());
		}
		//Test-3 select multiple items one by one
		Actions act=new Actions(driver);
		if(System.getProperty("os.name").contains("Win"))
		{
			act.keyDown(Keys.CONTROL)
			.click(s.getOptions().get(3)).pause(3000)
			.click(s.getOptions().get(1)).pause(3000)
			.click(s.getOptions().get(0)).pause(3000)
			.click(s.getOptions().get(2)).pause(3000)
			.keyUp(Keys.CONTROL).build().perform();
		}
		else if(System.getProperty("os.name").contains("Mac"))
		{
			act.keyDown(Keys.COMMAND).
			click(s.getOptions().get(3)).pause(3000)
			.click(s.getOptions().get(1)).pause(3000)
			.click(s.getOptions().get(0)).pause(3000)
			.click(s.getOptions().get(2)).pause(3000)
			.keyUp(Keys.COMMAND).build().perform();
		}
		else
		{
			System.out.println("unknown platform ::::");
		}
		//Test case-4
		String x=s.getFirstSelectedOption().getText();
		System.out.println("First item in selected items:");
		System.out.println("==================================");
		System.out.println(x);
		//Test case-5: get all selected items
		List<WebElement> y=s.getAllSelectedOptions();
		System.out.println("All Selected Items");
		System.out.println("--------------------");
		for(WebElement i:y)
		{
			System.out.println(i.getText());
		}
		//Test case-5: D_eselect items
		s.deselectByVisibleText("Audi");
		Thread.sleep(5000);
		s.deselectByIndex(2); //2nd item
		Thread.sleep(5000);
		s.deselectByValue("saab"); //value in source code
		Thread.sleep(5000);
		s.deselectAll();
		
		
		

	}

}
