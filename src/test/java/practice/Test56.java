package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test56 {

	public static void main(String[] args) {
		// download latest chrome driver software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		//collect all dropdown
		List<WebElement> dds=driver.findElements(By.xpath("//div[@class=\"ui active tab\"]/div/div[contains(@class,'dropdown')]"));
		//System.out.println("count of dropdown list are "+dds.size());
		//segregate multipl dropdown in lit
		int ssdd=0;
		int msdd=0;
		for(WebElement dd:dds) {
			if(dd.getAttribute("class").contains("multiple")){
				msdd++;
				driver.executeScript("arguments[0].style.border='2px solid blue ';",dd);
			}
			else {
				ssdd++;
			}
		}
		System.out.println("count of all dropdowns is :"+dds.size());
		System.out.println("Count of single select drop downs is "+ssdd);
		System.out.println("Count of multi select drop downs is "+msdd);

	}

}
