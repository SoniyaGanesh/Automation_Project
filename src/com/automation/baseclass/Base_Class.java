package com.automation.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_Class 
{	
	//1.Browser Launch
	public static WebDriver driver;
    public static WebDriver getdriver(String browser) 
    {
        try {
			if(browser.equalsIgnoreCase("chrome"))
			 {
				 System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
			      driver= new ChromeDriver();
			 }
			 else if (browser.equalsIgnoreCase("ie")) 
			 {
				 System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"\\Driver\\IEDriverServer.exe");
			     driver= new InternetExplorerDriver();
			}
			 else if (browser.equalsIgnoreCase("firefox")) 
			 {
				 System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Driver\\geckodriver.exe");
			     driver= new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
		} catch (Exception e)
        {
			e.printStackTrace();
		}
        return driver;
	 }
    
    //2.close
    public static void close() 
    {
         driver.close();
	 }
    
    //3.Quit
    public static void quit() 
    {
         driver.quit();
	 }
    
    //4.Navigate to
    public static void navigateto(String url) 
    {
        driver.navigate().to(url);
	}
    
    //5.Navigate back
    public static void navigateback()
    {
        driver.navigate().back();
	}
    
    //6.Navigate forward
    public static void navigateforward()
    {
        driver.navigate().forward();
	}
    
    //7.Navigate refresh
    public static void navigaterefresh()
    {
        driver.navigate().refresh();
	}
    
    //8.Get 
    public static void get(String url) 
    {
       driver.get(url);
	}
    
    //9.Alert
    public static void alert(WebElement element,String type,String a,String value)
    {
    	element.click();
        Alert alert = driver.switchTo().alert();
        if(type.equalsIgnoreCase("simpleAlert"))
        {
    	    alert.accept();
        }
        else if(type.equalsIgnoreCase("confirmAlert"))
        {
        	if(a=="Ok")
        	{
            	alert.accept();
        	}
        	else
        	{
        		alert.dismiss();
        	}
        }
        else if(type.equalsIgnoreCase("promptAlert"))
        {
        	if(a=="Ok")
        	{
        		alert. sendKeys(value);
            	alert.accept();
        	}
        	else
        	{
        		alert.dismiss();
        	}
        }             
  	   driver.switchTo().defaultContent();
	}
    
    public static void simpleAlert(WebElement element)
    {
    	element.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    
    public static void confirmAlert(WebElement element,String a)
    {
    	element.click();
        Alert alert = driver.switchTo().alert();
        if(a=="accept")
        {
        	alert.accept();
        }
        else
        {
        	alert.dismiss();
        }
  	   driver.switchTo().defaultContent();
    }   
    
    public static void promptAlert(WebElement element,String a,String value)
    {
    	element.click();
        Alert alert = driver.switchTo().alert();
    	 if(a=="accept")
         {
    	    alert. sendKeys(value);
         	alert.accept();
         }
         else
         {
         	alert.dismiss();
         }
   	   driver.switchTo().defaultContent();
	}
    
    
    
    //10.Action
    public static void action(WebElement element,String type)
    {
    	try {
			Actions a=new Actions(driver);
			if(type=="click")
			{
			  a.click(element).build().perform();
			}
			else if(type=="contextClick")
			{
			  a.contextClick(element).build().perform();
			}
			else if(type=="doubleClick")
			{
			  a.doubleClick(element).build().perform();
			}
			else if(type=="moveToElement")
			{
			  a.moveToElement(element).build().perform();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    	
       public static void draganddrop(WebElement element1,WebElement element2)
       {
    	 Actions a=new Actions(driver);
		 a.dragAndDrop(element1, element2).build().perform();
       }
    
        
       //11.Frames
       public static void frameByIndex(int value) 
       {
       	   driver.switchTo().frame(value);
       } 
       
       public static void frameById(String value) 
       {
       	   driver.switchTo().frame(value);
       }  
       public static void frameByElement(WebElement element) 
   	   {
   	   driver.switchTo().frame(element);
     	}
    
    //12.Robot
    public static void robot(WebElement element) throws Throwable 
    {
    	  try {
			Robot r=new Robot();
			  r.keyPress(KeyEvent.VK_DOWN);
			  r.keyRelease(KeyEvent.VK_DOWN); 
			  r.keyPress(KeyEvent.VK_ENTER);
			  r.keyRelease(KeyEvent.VK_ENTER);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
    
    //13.Window handles
    public void window_Handle(WebElement element) 
    {
    	//String windowHandle = driver.getWindowHandle();
    	//element.click();
    	//Set<String> windowHandles = driver.getWindowHandles();
    	//for (String string : windowHandles) 
    	{
			
		}
    }
    
    //14.Drop down
    public static void dropdown(WebElement element,String type,String value) 
    {
       try {
		Select s=new Select(element);
		   if(type.equalsIgnoreCase("byIndex"))
		   {
			   int index = Integer.parseInt(value);
			   s.selectByIndex(index);
		   }
		   else if(type.equalsIgnoreCase("byValue"))
		   {
			   s.selectByValue(value);
		   }
		   else if(type.equalsIgnoreCase("byVisibletext"))
		   {
			   s.selectByVisibleText(value);
		   }
	} catch (NumberFormatException e) {
		e.printStackTrace();
	}    
	}
    	
    //15.CheckBox
    public static void checkBox(WebElement element) 
    {
    	element.click();
    }
    //16.Is enable
    public static void isEnabled(WebElement element)
    {
       boolean enabled = element.isEnabled();
       System.out.println(enabled);
	}
    
    //17.Is disabled
    public static void isDisabled(WebElement element)
    {
       boolean disabled = element.isDisplayed();
       System.out.println(disabled);
	}
    
    //18.Is selected
    public static void isSelected(WebElement element)
    {
       boolean selected = element.isSelected();
       System.out.println(selected);
	}
    
    //19.Get Options
    public static void getOptions(WebElement element)
	{
        Select s=new Select(element);
   	    List<WebElement>  all_options = s.getOptions();
        for (WebElement selected1 : all_options) 
        {
        	  System.out.println(selected1.getText());
		}

	}
    
    //20.Get Title
    public static void getTitle() 
    {
        String title =driver.getTitle();
        System.out.println(title);
	 }
    
    //21.Get currentUrl
    public static void getCurrentUrl() 
    {
    	String currentUrl=driver.getCurrentUrl();
    	System.out.println(currentUrl);
	 }

    //22.Get text
    public static void getText(WebElement element ) 
    { 
        System.out.println(element.getText());
	 }
    
    //23.Get attribute
    public static void getAttribute(WebElement element ) 
    {
        String attribute =element.getAttribute("Value");
        System.out.println(attribute);
	 }
    
    //24.Wait
    public static void implicitwait(int time) 
    {    
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }	
    
    public static void explicitwait(WebElement element)
    {
    	WebDriverWait w=new WebDriverWait(driver, 30);
		w.until(ExpectedConditions.visibilityOf(element));
    }
			
    //25.Take screenshot
    public static void screen_shot(String filename) throws Throwable
    {
    	 try {
			TakesScreenshot ts=(TakesScreenshot) driver;
			 File source = ts.getScreenshotAs(OutputType.FILE);
			 File destination=new File(filename);
			 FileUtils.copyFile(source, destination);
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
   
    //26.Scroll up and down
     public static void scrollIntoView(WebElement element) 
     {
          try {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			e.printStackTrace();
		}          
	 }   
    

	//27.SendKeys
    public static void Sendkeys(WebElement element,String value) 
    {
         element.sendKeys(value);
	 }
    
    //28.Get first selected options
    public static void getFirstOptions(WebElement element) 
    {
      Select s=new Select(element);
      WebElement option = s.getFirstSelectedOption();
      System.out.println(option.getText());
	}
    
    //29.Get all selected options 
	public static void getAllSelectedOption(WebElement element) 
    {
        Select s=new Select(element);
        List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
   	    for (WebElement selected : allSelectedOptions) 
   	    {
   		   System.out.println(selected.getText());
   	   }
	}

    //30.Is multiple
	public static void isMultiple(WebElement element) 
    {
        Select s=new Select(element);
        boolean type=s.isMultiple();
   	    System.out.println(type);
    }
    
    //31.Click
    public static void clickOnElement(WebElement element) 
    {
        try {
			element.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
  
    
   //32.Thread
    public static void sleep(int seconds) throws Throwable 
    {
   	 Thread.sleep(seconds);
	 }
}
