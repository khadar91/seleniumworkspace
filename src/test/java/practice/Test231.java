package practice;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import org.testng.annotations.Test;

public class Test231 {
	@Test
	public void method()
	{
		//open browser
		ChromeDriver driver=new ChromeDriver();
		//Create DevTools session and set latitude and longitude values of desired location
		DevTools dt=driver.getDevTools();
		dt.createSession();
		Map<String,Object> params=new HashMap<String,Object>();
		params.put("latitude", 17.41866098826535);
		params.put("longitude", 78.49265533106315);
	    params.put("accuracy", 1);
	    driver.executeCdpCommand("Emulation.setGeolocationOverride",params);
	    //Launch site
		driver.get("http://www.google.com");
	}

}
