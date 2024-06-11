package practice;

import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test188Solution {

	public static void main(String[] args) throws Exception{
		// Drag and Drop between two elements in two different frames
		//Setting up chrome driver
		WebDriverManager.chromiumdriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//launch site
		driver.get("https://codepen.io/rjsmer/full/vvewWp");
		Thread.sleep(10000);
		//Via Mouse automation on Desktop
		Robot r=new Robot();
		r.mouseMove(120, 300);
		Thread.sleep(2000);
		r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		r.mouseMove(500, 320);
		r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		//driver.close();

	}

}
