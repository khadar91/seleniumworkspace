package practice;

import java.io.BufferedInputStream;
import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test49 
{

	public static void main(String[] args) 
	{
		// to download latest chrome driver saotware
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("https://www.amazon.com");
		//create new folder if not exist
		File folder=new File("E://batch265images");
		if(!folder.exists()) {
			folder.mkdir();
		}
		//collect all images from the webpages
		List<WebElement> images=driver.findElements(By.tagName("img"));
		System.out.println("All images in count is: "+images.size());
		
		//take image src value attribute
		for(int i=0;i<=images.size();i++) 
		{
			try {
			String imageUrl=images.get(i).getAttribute("src");
			String filename="images"+(i+1)+".jpg";
		Path destinationpath=Path.of(folder.getAbsolutePath(),filename);
		//contact "src" url  to download iamge
		URL url=new URL(imageUrl);
		BufferedInputStream  in=new BufferedInputStream(url.openStream());
		//save that image in our floder
		Files.copy(in,destinationpath, StandardCopyOption.REPLACE_EXISTING);
		//close the stream
		in.close();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		}
		driver.close();
	}
}
