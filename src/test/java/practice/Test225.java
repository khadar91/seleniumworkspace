package practice;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.Command;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v117.network.Network;
import org.openqa.selenium.devtools.v117.network.model.ConnectionType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Test225 {
	@Test
	public void method1()
	{
	//open browser and launch SUT(Software under Testing)
	RemoteWebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	//create DEvTools sesion
	DevTools dt=((ChromiumDriver)driver).getDevTools();
	dt.createSession();
	//Define Expected Network Conditions
	Command cmd1=Network.enable(Optional.of(1000000),Optional.empty(),Optional.empty());
	Command cmd2=Network.emulateNetworkConditions(false, 100, 200000, 100000, Optional.of(ConnectionType.WIFI));
	dt.send(cmd1);
	dt.send(cmd2);
	//Calculated Ellapse time
long st=System.currentTimeMillis();
driver.get("http://www.redbus.in");
long et=System.currentTimeMillis();
System.out.println("Load Time is "+(et-st)+" msec");
driver.close();
	
	}

}
