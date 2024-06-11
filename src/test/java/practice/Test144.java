package practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test144 {
	@Test
	public void method1() throws Exception
	{
		//open file with reqired permissions
		File f=new File("src/test/resources/gmailuiddata.txt");
		FileReader fr=new FileReader(f);
		BufferedReader br=new BufferedReader(fr);
		//Data driven with Soft assertion
				SoftAssert sf=new SoftAssert();
		//Data driven with Hard assertion
		String line="";
		while((line=br.readLine())!=null)
		{
			//open and Launch site
			WebDriverManager.chromedriver().setup();
			RemoteWebDriver driver=new ChromeDriver();
			//maximze the browser
			driver.manage().window().maximize();
			Thread.sleep(5000);
			driver.get("https://www.gmail.com");
			Thread.sleep(5000);
			//split data into pieces
			String[] data=line.split(",");
			//Parameterized code
			driver.findElement(By.name("identifier")).sendKeys(data[0]);
			driver.findElement(By.xpath("//span[text()='Next']/parent::button")).click();
			try
			{
			if(data[1].equals("valid") && 
					driver.findElement(By.name("password")).isDisplayed())
			{
				Reporter.log("valid UID test passed");
				sf.assertTrue(true);
			}
			else if(data[1].equals("invalid") &&
					driver.findElement(By.xpath("//div[text()='Couldn’t find your Google Account']")).isDisplayed())
			{
				Reporter.log("Invalid uid test passed");
				sf.assertTrue(true);
			}
			else if(data[1].equals("blank") &&
			driver.findElement(By.xpath("//div[text()='Enter an email or phone number']")).isDisplayed())
			{
				Reporter.log("blank UID Test passed");
				sf.assertTrue(true);
				
			}
			else
			{
				Reporter.log(data[1]+" UID Test failed");
				//code for screenshot or video recording along with mail sending to manager
				sf.assertTrue(false);
			}
			}
			catch(Exception e)
			{
				Reporter.log(data[1]+" UID Test failed");
				//code for screenshot or video recording along with mail sending to manager
				sf.assertTrue(false); 
		}
			//close site
			driver.close();
		} //loop ending

		sf.assertAll(); //mandatory code to collect all results finally
		br.close();
		fr.close();
	}
	}

