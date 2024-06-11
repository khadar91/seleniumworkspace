package practice;

import java.awt.Robot;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;

import org.sikuli.script.ImagePath;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;



public class Test253 {

	public static void main(String[] args) throws Exception {
		// open Calculator window (Silulix with java Robot)
		Runtime.getRuntime().exec("calc.exe");
		Thread.sleep(5000);
		//Automate calculator Window
		StringSelection x=new StringSelection("-120");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(x, null);
		Robot ro=new Robot();
		ro.keyPress(KeyEvent.VK_CONTROL);
		ro.keyPress(KeyEvent.VK_V);
		ro.keyRelease(KeyEvent.VK_V);
		ro.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		ImagePath.add(System.getProperty("user.dir"));
		Screen sc=new Screen();
		Iterator<Match> m=sc.findAll("src\\test\\resources\\images\\addition.png");
		m.next().click();
		StringSelection y=new StringSelection("568");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(y, null);
		ro.keyPress(KeyEvent.VK_CONTROL);
		ro.keyPress(KeyEvent.VK_V);
		ro.keyRelease(KeyEvent.VK_V);
		ro.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		sc.click("src\\test\\resources\\images\\equal.png");
		Thread.sleep(3000);
		ro.keyPress(KeyEvent.VK_CONTEXT_MENU);
		ro.keyRelease(KeyEvent.VK_CONTEXT_MENU);
		Thread.sleep(3000);
		sc.click("src\\test\\resources\\images\\copy.png");
		Thread.sleep(3000);
		String z=(String) Toolkit.getDefaultToolkit().getSystemClipboard()
				                       .getData(DataFlavor.stringFlavor);
		sc.click("src\\test\\resources\\images\\closecalc.png");
	}

}
