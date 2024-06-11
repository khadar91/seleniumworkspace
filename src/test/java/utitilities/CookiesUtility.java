package utitilities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CookiesUtility
{
	public int getCookiesCount(RemoteWebDriver driver)
	{
		int x=driver.manage().getCookies().size();
		return(x);
	}
	public List<String> getCookiesList(RemoteWebDriver driver)
	{
		Set<Cookie> s=driver.manage().getCookies();
		List<Cookie> l=new ArrayList<Cookie>(s);
		List<String> names=new ArrayList<String>();
		for(Cookie c:l)
		{
			names.add(c.getName()+" - "+c.getValue()+" - "+c.getDomain()+" - "+c.getExpiry());
		}
		return(names);
	}
	public List<String> getTypeOfCookies(RemoteWebDriver driver,String samedomain,String superdomain)
	{
		Set<Cookie> s=driver.manage().getCookies();
		List<Cookie> l=new ArrayList<Cookie>(s);
		List<String> types=new ArrayList<String>();
		for(Cookie c:l)
		{
			if(c.isHttpOnly())
			{
				if(c.getExpiry()==null)
				{
					types.add(c.getName()+"is HttpOnly Session Cookie");
				}
				else
				{
					types.add(c.getName()+"is HTTP-Only persistent cookie and it is expires on:"+c.getExpiry());
			}
		}
		else if(c.isSecure())
		{
			if(c.getExpiry()==null)
			{
				types.add(c.getName()+"is secured session Cookie");
			}
			else
			{
				types.add(c.getName()+"is secured persistent cookie"+c.getExpiry());
			}
		}
		
		else if(c.getDomain().contains(samedomain))
			{
			types.add(c.getName()+"is Same site cookie");	
			}
		else if(c.getDomain().contains(superdomain))
		{
			types.add(c.getName()+"is super cookie");
		}
		else
		{
			types.add(c.getName()+"is third-party cookie came from:"+c.getDomain());
		}
		}
			
		return (types);
	}
	public void addNewCookie(RemoteWebDriver driver,String name,String value,String domain,String path,
			Date expiry,boolean isSecure,boolean isHttpOnly,String sameSite)
	{
		Cookie c=new Cookie(name,value,domain,path , expiry,isSecure,isHttpOnly,sameSite);
		driver.manage().addCookie(c);
	}
	public void addNewCookieViaBuilder(RemoteWebDriver driver,String name,String value,String domain,String path,
			Date expiry,boolean isHttpOnly,boolean isSecure,String sameSite)
	{
		Cookie.Builder b=new Cookie.Builder(name,value);
		Cookie c=b.domain(domain).path(path).expiresOn(expiry).isHttpOnly(isHttpOnly).isSecure(isSecure).sameSite(sameSite).build();
		driver.manage().addCookie(c);
}
	public void deleteCookie(RemoteWebDriver driver)
	{
		driver.manage().deleteAllCookies();
	}
}