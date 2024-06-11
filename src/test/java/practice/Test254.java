package practice;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Test254 {

	public static void main(String[] args) throws Exception {
		// OPen calculator window(java Robot only)
		Runtime.getRuntime().exec("calc.exe");
		Thread.sleep(5000);
		//Automate calculator window
		StringSelection x=new StringSelection("-120");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(x,null);
		Robot ro=new Robot();
		ro.keyPress(KeyEvent.VK_CONTROL);
		ro.keyPress(KeyEvent.VK_V);
		ro.keyRelease(KeyEvent.VK_V);
		ro.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		ro.keyPress(KeyEvent.VK_ADD);
		ro.keyRelease(KeyEvent.VK_ADD);
		Thread.sleep(3000);
		StringSelection y=new StringSelection("528");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(y, null);
		ro.keyPress(KeyEvent.VK_CONTROL);
		ro.keyPress(KeyEvent.VK_V);
		ro.keyRelease(KeyEvent.VK_V);
		ro.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(3000);
		ro.keyPress(KeyEvent.VK_EQUALS);
		ro.keyRelease(KeyEvent.VK_EQUALS);
		Thread.sleep(3000);
		ro.keyPress(KeyEvent.VK_CONTEXT_MENU);
		ro.keyRelease(KeyEvent.VK_CONTEXT_MENU);
		Thread.sleep(3000);
		ro.keyPress(KeyEvent.VK_ENTER);
		ro.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		String z=(String) Toolkit.getDefaultToolkit().getSystemClipboard()
				                       .getData(DataFlavor.stringFlavor);
		System.out.println(z);
		ro.keyPress(KeyEvent.VK_ALT);
		ro.keyPress(KeyEvent.VK_F4);
		ro.keyRelease(KeyEvent.VK_F4);
		ro.keyRelease(KeyEvent.VK_ALT);
	}
		
		

	}


