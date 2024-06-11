package utitilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CarouselSlider
{
	public int getCountOfSlides(WebElement slider)
	{
		int count=0;
		if(slider.getTagName().equalsIgnoreCase("ul")|| slider.getTagName().equalsIgnoreCase("ol"))
		{
			count=slider.findElements(By.xpath("child::li")).size();
		}
		else if(slider.getTagName().equalsIgnoreCase("div")) 
		{
			List<WebElement> temp1=slider.findElements(By.xpath("child::div"));
			List<WebElement> temp2=new ArrayList<WebElement>();
			for(WebElement e:temp1)
			{
				try
				{
				if(!e.getAttribute("class").contains("clone"))
				{
					if(e.getAttribute("data-clone").equals("false"))
					{
						temp2.add(e);
						}
					}
			}
			catch(Exception exe)
			{
				temp2.add(e);	
			}
			}
			count=temp2.size();
		}
		else
		{
		System.out.println("Unknown tag");
		System.exit(0);
	}
	return count;
	}
	public String getTypeOfSlider(WebElement slider) 
	{
		//Transform and transform-styles are css properties
		String value=slider.getCssValue("transform");
		if(value.equals("none"))
		{
			value=slider.getCssValue("transform-style");
				
			}
		//verification
			if(value.contains("3d"))
			{			
		return "3D slider";
			}
			else
			{
				return "2D Slider";
	}
	}
	public boolean areSlidesMovingAutomatically(WebElement slider) throws Exception
	{
		//old value
		String oldvalue=slider.getCssValue("transform");
		if(oldvalue.equals("none"))
		{
			//take transform-style property value
			oldvalue=slider.getCssValue("transform-style");
		}
		//verification
			if(oldvalue.contains("3D"))
			{
				//wait some time
				Thread.sleep(500);
				//get values again
				String newvalue=slider.getCssValue("transform");
				if(newvalue.equals("none"))
				{
				//take transform-style css balue
					newvalue=slider.getCssValue("transform-style");
				}
				//compare
				if(oldvalue.equals(newvalue))
				{
					return (false); //not roating
				}
				else
				{
					return (true);//rotating			
			}
		}
		else 
		{
			String[] y=oldvalue.split(",");
			y[4]=y[4].trim();
			y[5]=y[5].trim();
			y[5]=y[5].replace(")","");
			float tx=Float.parseFloat(y[4]);
			float ty=Float.parseFloat(y[5]);
			if(tx==0 && ty==0)
			{ 
			return (false); //not rotating
			}
			else
			{
				return (true); // raitating
			}
			}
	}
	public String getMovingDirectionOfSlidesInSlider(WebElement slider)
	{
		String value=slider.getCssValue("transform");
		if(value.contains("3d"))
		{
			String s=slider.getAttribute("style");
			if(s.contains("rotateZ(-"))
			{
				return ("front to back rotation");
			}
			else if(s.contains("rotateZ("))
			{
				return("back to front ratation");
			}
			else if(s.contains("rotateY(-"))
			{
				return("right to left rotation");
			}
			else if(s.contains("rotateY("))
			{
				return("left to right rotation");
			}
			else if(s.contains("rotateX(-"))
			{
				return("top to bottom rotation");
			}
			else if(s.contains("rotateX("))
			{
				return("bottom to top rotation");
			}
			else
			{
		return ("Not matching any specific rotation Condition");
			}
	}
		else //2D
		{
			String[] p=value.split(",");  //comma to seperator
			p[4]=p[4].trim();//removing leading and tailing spaces
			p[5]=p[5].trim();//remove unwanted spaces
			p[5]=p[5].replace(")","");//remove ")" symbal
			float tx=Float.parseFloat(p[4]);
			float ty=Float.parseFloat(p[5]);
			if(tx<0 && ty==0)
			{
				return ("Slides are moving right to left");
			}
			else if(tx>0 && ty==0)
			{
				return("Slides are moving left to right");
			}
			else if(tx==0 && ty<0)
			{
				return (" Slides are moving bottom to top");
			}
			else if(tx==0 && ty>0)
			{
				return ("Slides are moving top to bottom");
			}
			else //tx and ty both are zero
			{
				return("Not moving");
			}
		}
	}
		public String getSlideMoveDuration(WebElement slider)
		{
			//transition property value sane in 2d and 3d dimentiona slider in css
			String x=slider.getCssValue("transition");
			String[] y=x.split(" ");//split value depends on space
			y[1]=y[1].trim();//removing leading and trailing spaces in second piec
			if(y[1].contains("ms"))
			{
				String z=y[1];
				z=z.replace("ms",""); //remove if ms exist
				float duration=Float.parseFloat(z);//type conversion from string to float
				if(duration<=1) return(duration+"millisecond");
				else return(duration+"Milliseconds");
			}
			else
			{
				String z=y[1];
				z=z.replace("s","");//remove "s" if exists
				Float duration=Float.parseFloat(z);//type conversion from String to Float
				if(duration<=1) return(duration+"second");
				else return(duration+"Seconds");
			}
		}
		public String getslideMovingStyle(WebElement slider)
		{
			String x=slider.getCssValue("transition");
			String[] y=x.split(" ");//space as seperator
			y[2]=y[2].trim();
			if(y[2].equalsIgnoreCase("ease-in")) return("slow start");
			else if(y[2].equalsIgnoreCase("ease-out")) return("slow end");
			else return("Slow start and slow end");
		}
		public String grtDelayBetweenSlidesMove(WebElement slider)
		{
			String x=slider.getCssValue("transition");
			String[] y=x.split(" ");//seperator as space
			if(y[3].contains("ms"))
			{
				String z=y[3];
				z=z.replaceAll("[m][s][,]?","");//remove "ms,"or "ms" if exists
				float duration=Float.parseFloat(z);
				if(duration<=1) return(duration+" millisecond");
				else return(duration+" milliseconds");
			}
			else
			{
				String z=y[3];
				z=z.replaceAll("[s][,]?","");//remove" s," or "s" if exists
				float duration=Float.parseFloat(z);// type conversion String to float
				if(duration<=1) return(duration+" second");
				else return(duration+" seconds");
				
			}
		}
	}

