package practice;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test245 {

	public static void main(String[] args) throws Exception{
		//open Browser and Launch site With(SikuliX)
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/basic_auth");
		//Automate Login Pop-window via Sikulix
		ImagePath.add(System.getProperty("user.dir"));
		Screen sc=new Screen();
		sc.type("src/test/resources/images/username.PNG","admin");
		Thread.sleep(5000);
		sc.type("src/test/resources/images/password.PNG","admin");
		Thread.sleep(5000);
		sc.click("src/test/resources/images/signin.PNG");

	}

}
