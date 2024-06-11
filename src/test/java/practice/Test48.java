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

public class Test48 {

	public static void main(String[] args) throws Exception {
		// download latest chrome driver software
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		//launch site
		driver.get("https://www.amazon.com");
		//create new folder
		File folder=new File("D://batch264images");
		int count=1;
		//condition checked
		if(!folder.exists()) {
			folder.mkdir();
		}
		//collect all images in page sorce
		List<WebElement> images=driver.findElements(By.xpath("//img"));
		System.out.println("Alla images:"+images.size());
		for(WebElement image:images) {
			//get image attrribute
			String imageUrl=image.getAttribute("src");
			String File="img"+count+".png";
			Path destinationPath=Path.of(folder.getAbsolutePath(),File);
			//contact src image to download imagges
			URL url=new URL(imageUrl);
			 BufferedInputStream in=new BufferedInputStream(url.openStream());
			 //save that download image in to our folder
			 Files.copy(in, destinationPath,StandardCopyOption.REPLACE_EXISTING);
			 //close stream
			 in.close();
			 count++;
			
		}
		//close the site
		driver.close();
		
		
		
		

	}

}
