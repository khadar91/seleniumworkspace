package practice;


import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;


public class Test224 {
	@Test
	public void method1() throws Exception
	{
		///Open browser and launch SUT(site under testing)
		RemoteWebDriver driver1=new ChromeDriver();
		driver1.manage().window().maximize();
		driver1.get("https://www.google.com");
		//create DevTools session
		DevTools dt=((ChromiumDriver) driver1).getDevTools();
		dt.createSession();
		//Crash that browser window via CDP Command
		try
		{
		Command cd=new Command("Browser.crash",ImmutableMap.of());
		dt.send(cd);
		}
		catch(Exception ex)
		{
			System.out.println("Continue further Tesing");
		}
		Thread.sleep(5000);
//open new Browser and Relanch site foe recovery setting
		try
		{
		ChromeDriver driver2=new ChromeDriver();
		driver2.manage().window().maximize();
		driver2.get("https://www.facebook.com");
		System.out.println("Recovery test is passed");
		Thread.sleep(5000);
		//clsoe driver
		driver2.close();
		}
		catch(Exception ex)
		{
			System.out.println("Recovery test is failed due to relaunch browser:");
		}
	}
}
