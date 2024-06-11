package practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test51 {

	public static void main(String[] args) throws Exception {
		// download latest chrome driver software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//launch site3.
		driver.get("https://www.flipkart.com");
		Thread.sleep(5000);
		//collect all tags in page source
		List<WebElement> elements=driver.findElements(By.xpath("//*"));
		int totalelements=elements.size();
		int correctlinks=0;
		int brokenlinks=0;
		 int linkexception=0;
		 int localpagelinks=0;
		 int nohrefelements=0;
		//collect each link have attrtribute "href"
		for(WebElement element:elements)
		{
			String hrefpath;
			if((hrefpath=element.getAttribute("href"))!=null)
			{
				
			//check taht attribute value is"http" and "https"
			if(hrefpath.startsWith("http")||hrefpath.startsWith("https"))
			{
				try {
			//check the link http adress working or not
				URL u=new URL(hrefpath);
				HttpURLConnection con=(HttpURLConnection)u.openConnection();
				con.connect();
				//check that connection
				if(con.getResponseCode()==200) {
					correctlinks++;
				}
				else 
				{
					brokenlinks++;
				System.out.println(hrefpath+"is broken link due to "+con.getResponseMessage());
				}
				}
				catch(Exception ex) {
				linkexception++;
				System.out.println(hrefpath+" is exception raised "+ex.getMessage());
				}
			}
				else {
					localpagelinks++;
			}
			}
		else {
			nohrefelements++;
		}
	}
		System.out.println("Total elements asre "+totalelements);
		System.out.println("links no href are "+nohrefelements);
		System.out.println("Total links are "+(totalelements-nohrefelements));
		System.out.println("Local page links are "+localpagelinks);
		System.out.println("links with Exception "+linkexception);	
		System.out.println("Brokenlinks aare "+brokenlinks);
		System.out.println("Correctlinks are "+correctlinks);
		
		//close
		driver.close();
		}

}
