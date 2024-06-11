package practice;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test244 {

	public static void main(String[] args) throws Exception{
		//Open browser and launch site
				WebDriverManager.chromedriver().setup();
				RemoteWebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.get("https://the-internet.herokuapp.com/basic_auth");
				Thread.sleep(5000);
				//Automate Login pop-up window via Keyboard Automation
				StringSelection x=new StringSelection("admin");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(x, null);
				Robot ro=new Robot();
				ro.keyPress(KeyEvent.VK_CONTROL);
				ro.keyPress(KeyEvent.VK_V);
				ro.keyRelease(KeyEvent.VK_V);
				ro.keyRelease(KeyEvent.VK_CONTROL);
				Thread.sleep(5000);
				ro.keyPress(KeyEvent.VK_TAB);
				ro.keyRelease(KeyEvent.VK_TAB);
				Thread.sleep(5000);
				StringSelection y=new StringSelection("admin");
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(y, null);
				ro.keyPress(KeyEvent.VK_CONTROL);
				ro.keyPress(KeyEvent.VK_V);
				ro.keyRelease(KeyEvent.VK_V);
				ro.keyRelease(KeyEvent.VK_CONTROL);
				Thread.sleep(5000);
				ro.keyPress(KeyEvent.VK_TAB);
				ro.keyRelease(KeyEvent.VK_TAB);
				Thread.sleep(5000);
				ro.keyPress(KeyEvent.VK_ENTER);
				ro.keyRelease(KeyEvent.VK_ENTER);
	}

}
