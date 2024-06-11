package practice;

import java.io.File;


import javax.imageio.ImageIO;

import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

public class Test126 {
	@Test
	public void methos1() throws Exception
	{
		//open browser
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//maximize the browser
		driver.manage().window().maximize();
		Thread.sleep(5000);
		//Launch site
		driver.get("https://semantic-ui.com/modules/dropdown.html");
		Thread.sleep(5000);
		//GET Screen shot of an Element
		WebElement e=driver.findElement(By.xpath("//h4[text()='Inline']/following-sibling::span/div"));
		File f1=e.getScreenshotAs(OutputType.FILE);
		File dest1=new File("target\\elescreenshot.png");
		FileHandler.copy(f1, dest1); 
		//get screenshot of visible screen
		File f2=driver.getScreenshotAs(OutputType.FILE);
		File dest2=new File("target\\pagescreenshot.png");
		FileHandler.copy(f2, dest2); 
		//get full screenshot of complete page using AShot
		AShot as=new AShot();
		ShootingStrategy shs=ShootingStrategies.viewportPasting(1000);
		Screenshot ss=as.shootingStrategy(shs).takeScreenshot(driver);
		File dest=new File("target\\fullscreenshot.png");
		ImageIO.write(ss.getImage(), "PNG", dest);
		//close site
		driver.close();
		
		
		
	}

}
