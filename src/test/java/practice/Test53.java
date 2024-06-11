
package practice;




import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test53
{
	public static void main(String[] args) throws Exception
	{
		//download latest chrome driver software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("https://www.google.in");
		int ctb=0;
		int crb=0;
		int ceb=0;
		int cpb=0;
		int ccb=0;
		int chb=0;
		int cu=0;
		int cte=0;
		int csb=0;
		int others=0;

		//collect all elements in page source
		List<WebElement> l=driver.findElements(By.tagName("input"));
		System.out.println("count all elemnets input tag : "+l.size());
		for(int i=0;i<l.size();i++) 
		{
			String x=l.get(i).getAttribute("type");
			if(x.equals("text")) 
			{
				ctb++;
			}
			else if(x.equals("radio"))
			{
				crb++;
			}
			else if(x.equals("email"))
			{
				ceb++;
			}
			else if(x.equals("password"))
			{
				cpb++;
			}
			else if(x.equals("checkbox"))
			{
				ccb++;
			}
			else if(x.equals("hidden"))
			{
				chb++;
			}
			else if(x.equals("url"))
			{
				cu++;
			}
			else if(x.equals("tel"))
			{
				cte++;
			}
			else if(x.equals("submit"))
			{
				csb++;
			}
			else
			{
				others++;
				System.out.println(x);
			}

		}
		System.out.println("count of text boxes "+ctb);
		System.out.println("count of password boxes "+cpb);
		System.out.println("count of check boxes "+ccb);
		System.out.println("count of radio buttons "+crb);
		System.out.println("count of email boxes "+ceb);
		System.out.println("count of url elements "+cu);
		System.out.println("count of telephone elements "+ctb);
		System.out.println("count of submit buttons "+csb);
		System.out.println("count of hidden elements "+chb);
		System.out.println("count of others "+others);
		//close site
		driver.close();



	}
}






