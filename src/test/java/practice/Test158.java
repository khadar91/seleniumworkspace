package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test158 {
	File f1,f2;
	FileReader fr;
	Properties p;
	FileInputStream fi;
	Workbook wb;
	Sheet sh;
	int nor;
	int noc;
	RemoteWebDriver driver;
	FileOutputStream fo;
	
	@Test(priority=1)
	public void accessPropertiesfile() throws Exception
	{
		f1=new File("src\\test\\resources\\register.properties");
		fr=new FileReader(f1);
		 p=new Properties();
		p.load(fr); //into RAM	
	}
	@Test(priority=2)
	public void accessExcelFile() throws Exception
	{
		f2=new File(p.getProperty("testdatafilepath"));
		fi=new FileInputStream(f2);
		wb=WorkbookFactory.create(fi);
		sh=wb.getSheet("Sheet1");
		nor=sh.getPhysicalNumberOfRows();
		noc=sh.getRow(0).getLastCellNum();
	}
	@Test(priority=3)
	public void openBrowser() throws Exception
	{
		String bn=p.getProperty("browser");
		if(bn.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(bn.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(bn.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			Reporter.log("Wrong Browser name");
			fr.close();
			fi.close();
			wb.close();
			System.exit(0); // Forcibly exit
		}
	}
	@Test(priority=4)
	public void launchSite() throws Exception
	{
		driver.manage().window().maximize();
		driver.get(p.getProperty("url"));
		Thread.sleep(Long.parseLong(p.getProperty("waittime")));
	}
	@Test(priority=5)
	public void ddt() throws Exception
	{
		//create Result column with some decoration
		SimpleDateFormat sf=new SimpleDateFormat("dd-MMM-yyyy-hh-mm-ss");
		Date dt=new Date();
		//Creating Font and style objects
		Font font=wb.createFont();
		font.setFontHeightInPoints((short)11);
		font.setFontName("Arial");
		font.setItalic(true);
		font.setColor(IndexedColors.RED.getIndex());
		CellStyle style=wb.createCellStyle();
		style.setFont(font);
		//Applying Style to the cell
		Cell cl=sh.createRow(0).createCell(noc);
		cl.setCellValue("Result on "+sf.format(dt));
		cl.setCellStyle(style);
		sh.autoSizeColumn(0);
		//DDT for 2nd row because 1st row headings
		for(int i=1;i<nor;i++)
		{
			//Take test data from row
			DataFormatter df=new DataFormatter();
			String a=df.formatCellValue(sh.getRow(i).getCell(0));
			String b=df.formatCellValue(sh.getRow(i).getCell(1));
			String c=df.formatCellValue(sh.getRow(i).getCell(2));
			String d=df.formatCellValue(sh.getRow(i).getCell(3));
			String e=df.formatCellValue(sh.getRow(i).getCell(4));
			//fill fields in page
			driver.switchTo().frame("iframewrapper");
			driver.findElement(By.id("register_name")).sendKeys(a);
			driver.findElement(By.id("register_password")).sendKeys(b);
			driver.findElement(By.id("register_email")).sendKeys(c);
			if(d.equalsIgnoreCase("male"))
			{
				driver.findElement(By.id("register_gendermale")).click();
			}
			else
			{
				driver.findElement(By.id("register_genderfemale")).click();
			}
			WebElement ele=driver.findElement(By.id("register_country"));
			Select sel=new Select(ele);
			if(e.equalsIgnoreCase("india"))
			{
				sel.selectByIndex(0);
			}
			else if(e.equalsIgnoreCase("pakistan"))
			{
				sel.selectByIndex(1);
			}
			else if(e.equalsIgnoreCase("africa"))
			{
				sel.selectByIndex(2);
			}
			else if(e.equalsIgnoreCase("china"))
			{
				sel.selectByIndex(3);
			}
			else
			{
				sel.selectByIndex(4); //select other
			}
			Thread.sleep(Long.parseLong(p.getProperty("waittime")));
			//Submit the dta
			driver.findElement(By.id("register_0")).click();
			Thread.sleep(Long.parseLong(p.getProperty("waittime")));
			//get output message and write into last column as test results
			String o=driver.findElement(By.tagName("h1")).getText();
			sh.getRow(i).createCell(noc).setCellValue(o); // in excel file
			Reporter.log(o); // TestNg Report
			//back to page and refresh the page
			driver.switchTo().defaultContent();
			driver.navigate().refresh();  //for next iteration
			Thread.sleep(Long.parseLong(p.getProperty("waittime")));
		}
	}
	@Test(priority=6)
	public void saveExcelChanges() throws Exception
	{
		//save excel file
		fo=new FileOutputStream(f2);
		wb.write(fo);
		fi.close();
		fo.close();
		wb.close();
		
	}
	@Test(priority=7)
	public void closeSite() throws Exception
	{
		//close site
		driver.close();
	}
	
	@Test(priority=8)
	public void zipExcel() throws Exception
	{
		//zip the excel file
	}
	
	@Test(priority=9)
	public void sendEmail() throws Exception
	{
		//email zipped excel file and index.html to manager
	}

}
