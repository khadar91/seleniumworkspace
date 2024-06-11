package practice;


import org.openqa.selenium.ScriptKey;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Test222 {
	@Test
	public void method() throws Exception
	{
		//Open browser and launch site
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site
		driver.get("https://users.cs.cf.ac.uk/Dave.Marshall/Internet/FRAMES/nested_frame.html"); 
		Thread.sleep(5000);
		//write JavaScript statements individually
		ScriptKey sk1=driver.pin("return(window.frames.length);");
		ScriptKey sk2=driver.pin("var frames=window.frames;");
		ScriptKey sk3=driver.pin("frames[3].location='https://www.bbc.com';");
		ScriptKey sk4=driver.pin("frames[4].location='https://www.magnitia.com';");
		//Scenario:1 get all frame count
		long n=(long)driver.executeScript(sk1); 
		System.out.println(n);
		//Scenario:2 goto 4th frame
		driver.executeScript(sk2); //collect all frames
		driver.executeScript(sk3); //goto 4th frame
		//Scenario:3 goto 5th frame
		driver.executeScript(sk2); //collect all frames
		driver.executeScript(sk4); //goto 5th frame
		//close site
		//driver.close();
		
		
		
	}

}
