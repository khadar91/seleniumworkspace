package practice;


import java.awt.*;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test72 {

	public static  void main(String[] args)throws Exception
	{
		// open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver(); //. browser opened in  normal size
		Thread.sleep(3000);
		//minimize the browser
		driver.manage().window().minimize();
		Thread.sleep(3000);
		//maximize the browser
		driver.manage().window().maximize();//maximize with tool bars
		Thread.sleep(3000);
		//get current size
		int w=driver.manage().window().getSize().getWidth();
		int h=driver.manage().window().getSize().getHeight();
		System.out.println(w+"  "+h);
		//resize the browser
		Dimension d=new Dimension(1366,768);
		//get current position
		int x=driver.manage().window().getPosition().getX();
		int y=driver.manage().window().getPosition().getY();
		System.out.println(x+"   "+y);
		//relocate browser on desktop
		Point p=new Point(200,200); // x and y coordinates
		driver.manage().window().setPosition(p);
		Thread.sleep(5000);
		//get ful screen
		driver.manage().window().fullscreen(); // maximize the window without tool bars
		Thread.sleep(5000);
		// back to normal(core java)
		Robot r=new Robot();
		//r.KeyPress=(KeyEvent.VK_ESCAPE);
		//r.KeyRelease(KeyEvent.VK_ESCAPE);
		Thread.sleep(5000);
	
		}		

	}


