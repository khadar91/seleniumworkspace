package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.sikuli.script.Button;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Location;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test252 {

	public static void main(String[] args) throws Exception{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//Launch site(SWD)
		driver.get("http://www.youtube.com");
		FluentWait<ChromeDriver> w=new FluentWait<ChromeDriver>(driver);
		w.withTimeout(Duration.ofSeconds(20));
		w.pollingEvery(Duration.ofMillis(500));
		//Search for a video(SWD)
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("search_query"))).sendKeys("abdul kalam sir speeches");
		Thread.sleep(5000);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@aria-label=\"Search\"])[1]"))).click();
		Thread.sleep(5000);
		w.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//a[@title='Greatest speech of all time | Dr.APJ Abdul Kalam in European Union Parliament.']"))).click();
		//Automate video elements/controls/icons(SikuliX)
		ImagePath.add(System.getProperty("user.dir"));
		Screen sc=new Screen();
		if(sc.exists("src\\test\\resources\\images\\skipadd.png",10)!=null)
{
	sc.click("src\\test\\resources\\images\\skipadd.png");
}
else if(sc.exists("src\\test\\resources\\images\\skipadds.png",10)!=null)
{
	sc.click("src\\test\\resources\\images\\skipadds.png");
}
else
{
	System.out.println("No add");
}
Thread.sleep(2000);
try
{
	w.until(ExpectedConditions.elementToBeClickable(
			By.cssSelector("button[aria-label='Skip trial']"))).click();
}
catch(Exception ex)
{
	System.out.println("No dialog related to License");
}
//move mouse pointer to video body to get icons visibility
Location l1= new Location(200,300); //video body x & y-coordinates
sc.wheel(l1,Button.LEFT,0);//0 means no click, just move mouse pointer to video body
sc.click("src\\test\\resources\\images\\pause.png"); //pause
Thread.sleep(5000);
sc.wheel(l1,Button.LEFT ,0);//move to given location
sc.click("src\\test\\resources\\images\\play.png"); //play
Thread.sleep(5000);
sc.wheel(l1,Button.LEFT, 0); //move to given location
sc.mouseMove("src\\test\\resources\\images\\volume.png");
Match e=sc.find("src\\test\\resources\\images\\bubble.png");
int x1=e.getX();
int y1=e.getY();
Location l2=new Location(x1-50,y1);
sc.dragDrop(e,l2);//decrease volume
Thread.sleep(5000);
int x2=e.getX();
int y2=e.getY();
Location l3=new Location(x2+50,y2);
sc.dragDrop(e,l3); //increase volume
Thread.sleep(5000);
sc.wheel(l1,Button.LEFT,0); 
sc.click("src\\test\\resources\\images\\volume.png"); //mute




	}

}
