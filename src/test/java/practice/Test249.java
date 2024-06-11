package practice;

import java.io.File;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test249 {

	public static void main(String[] args) throws InterruptedException, FindFailed {
		// Create an empty folder if not exist
		File fo=new File("src\\test\\resources\\downloads");
		fo.mkdir();
		//store preferences/argumnets with values as pairs in a hashmap
				//Store preferences/arguments with values as pairs in a hash map
				HashMap<String,Object> hm=new HashMap<String,Object>();
				hm.put("profile.default_content_settings.popups",0); //0 means off
				hm.put("download.default_directory",fo.getAbsolutePath());
				hm.put("safebrowsing.enabled",true);
				//Set hash map pairs to chrome browser preferences
				ChromeOptions co=new ChromeOptions();
				co.setExperimentalOption("prefs",hm); //"prefs" is a fixed command
				//Open browser with given preferences
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver=new ChromeDriver(co); 
				driver.manage().window().maximize();
				Thread.sleep(5000);
				//Launch site
				driver.get("https://selenium.dev/");
				driver.findElement(By.xpath("//*[text()='Downloads']")).click();
				Thread.sleep(5000);
				driver.findElement(By.linkText("4.16.1")).click();
				//Handle keep/discard pop-up if exists
				Screen s=new Screen();
				if(s.exists("src\\test\\resources\\images\\keep.png", 5)!=null)
				{
					s.click("src\\test\\resources\\images\\keep.png");
				}
				Thread.sleep(20000); //should be required for complete downloading
		

	}

}
