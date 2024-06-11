package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test52 {

	public static void main(String[] args) {
		// download latest chrome driver software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("https://www.amazon.com");
		//collect all <input> tag element in page source
		List<WebElement> l=driver.findElements(By.tagName("input"));
		System.out.println("Count of input tag element is "+l.size());
		//segregate <input> tag element
		int ctb=0;
		int crb=0;
		int ccb=0;
		int ceb=0;
		int cpb=0;
		int cu=0;
		int ct=0;
		int csb=0;
		int ch=0;
		int others=0;
		//collect each element as type
		for(WebElement e:l) {
			String x=e.getAttribute("type");
			switch(x) {
			case "text":
				ctb++;
				break;
			case "radio":
				crb++;
				break;
			case "checkbox":
			ccb++;
			break;
			case "mail":
				ceb++;
				break;
			case "password":
				cpb++;
				break;
			case "url":
				cu++;
				break;
			case "submit":
				csb++;
				break;
			case "hidden":
				ch++;
				break;
			case "tel":
				ct++;
				break;
			default:
			others++;
			System.out.println(x);	
		}
	}
		System.out.println("count of text boxes : "+ctb);
		System.out.println("count of raido buttons : "+crb);
		System.out.println("count of email boxes : "+ceb);
		System.out.println("count of password boxes : "+cpb);
		System.out.println("count of check boxes : "+ccb);
		System.out.println("count of check url : "+cu);
		System.out.println("count of submit buttons : "+csb);
		System.out.println("count of hiden elements : "+ch);
		System.out.println("count of telephone elements : "+ct);
		
		System.out.println("count of others elements : "+others);

}
}