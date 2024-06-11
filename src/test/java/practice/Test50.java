package practice;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test50   {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("https://www.amazon.com");
		//collect all links in page sorce
		List<WebElement> links=driver.findElements(By.tagName("a"));
		int totallinks=links.size();
		int correctlink=0;
		int brokenlink=0;
		int linkswithexception=0;
		int localpagelink=0;
		int nohreflinks=0;
		//click an each link an get attribute for href or not
		for(WebElement link:links) {
			String hrefpath;
			if((hrefpath=link.getAttribute("href"))!=null){
				//hef get attribut value http or https
				if(hrefpath.startsWith("https")||hrefpath.startsWith("http")) {
					try {

						//chect whether address is working or not
						URL u=new URL(hrefpath);
						HttpURLConnection con=(HttpURLConnection) u.openConnection();
						con.connect();//send dummu request and get response
						if(con.getResponseCode()==200) {
							correctlink++;
						}
						else {
							brokenlink++;
							System.out.println(hrefpath+"is broken link due to "+con.getResponseMessage());
						}
					}
					catch(Exception ex) {
						linkswithexception++;
						System.out.println(hrefpath+"is raised "+ex.getMessage());
					}		
				}
				else {
					localpagelink++;

				}
			}
			else {
				nohreflinks++;
			}

		}
		System.out.println("Total links are "+totallinks);
		System.out.println("Links with no href are "+nohreflinks);
		System.out.println("Loacal page links are "+localpagelink);
		System.out.println("Correct links are "+correctlink);
		System.out.println("Broken links are "+brokenlink);
		System.out.println("links raised Exception "+linkswithexception);
		//close the site
		driver.close();
	}
}