package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test181 {

	public static void main(String[] args) {
		//open browser and launch site
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com");
		//Locate and operate element
		FluentWait<RemoteWebDriver> w=new FluentWait<RemoteWebDriver>(driver);
		w.withTimeout(Duration.ofSeconds(20));
		w.pollingEvery(Duration.ofMillis(1000));
		WebElement uid=w.until((RemoteWebDriver d) -> {
            WebElement e=d.findElement(By.name("email"));
            String c=e.getAttribute("aria-label");
            System.out.println(c);
            return(c.contains("Email address") ? e : null);
        });
		uid.sendKeys("magnitiait");

	}

}
