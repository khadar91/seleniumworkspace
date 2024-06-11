package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test170 {

	public static void main(String[] args) throws Exception{
		// 1.Connect to DB as per DB Technology used by DEV Team
			
		Class.forName("com.mysql.cj.jdbc.Driver"); //for mysql server
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/batch264","root","admin");
	//Get data from DB table using SQL QUERY
	Statement st=con.createStatement();
	ResultSet result=st.executeQuery("SELECT * FROM table1");
	while(result.next()) //go to each row
	{
		String value=result.getString(2); //take 2nd column(word) value in that row
		//Launch site
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.get("https://www.google.co.in");
		driver.findElement(By.id("q")).sendKeys(value,Keys.ENTER);
		if(driver.getTitle().contains(value))
		{
			System.out.println("Test Passesed"+ value);
		}
			else
			{
				System.out.println("Test Failed"+ value);
			}
		driver.close();
		}
	//disconnect from DB
			con.close();
	}
}
