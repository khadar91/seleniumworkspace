package practice;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test238 {

	public static void main(String[] args) {
		//way-1: code bypassing
		//open browser launch site and allow Web push notifications window
		//Create Map to store preferences
		Map<String,Object> m=new HashMap<String,Object>();
		//add key and value to map
		//pass the argument 1 to "allow" and argument 2 to is "block"
		m.put("profile.default_content_setting_values.notifications",1);
		//create instance of ChromOptions
		ChromeOptions co=new ChromeOptions();
		// set ExperimentalOption - prefs 
		co.setExperimentalOption("prefs", m);
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.get("http://www.spicejet.com");
	}

}
