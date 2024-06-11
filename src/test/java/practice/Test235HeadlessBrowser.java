package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test235HeadlessBrowser {

	public static void main(String[] args) throws Exception {
		//open Browser in Headless
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--headless");
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver(co);
		driver.get("http://www.google.co.in");
		Thread.sleep(5000);
		String x=driver.getTitle();
		System.out.println(x);
		driver.close();

	}

}
