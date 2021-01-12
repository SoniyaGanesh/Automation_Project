package com.automation.baseclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Purchase_Details1 extends Base_Class
{
     public static void main(String[] args) throws Throwable 
     {
    	  getdriver("chrome");
    	  get("http://automationpractice.com/index.php");
		  
		  WebElement signin_Btn = driver.findElement(By.xpath("//a[@class='login']"));
		  clickOnElement(signin_Btn);
		  
		  WebElement already_Reg = driver.findElement(By.xpath("//form[@id='login_form']"));
		  scrollIntoView(already_Reg);
		  sleep(3000);
		  
		  WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		  Sendkeys(email, "email123456@gmail.com");
		  
		  WebElement password = driver.findElement(By.xpath("//input[@id='passwd']"));
		  Sendkeys(password, "54321");
			 
		  WebElement signin_Btn1 = driver.findElement(By.xpath("//button[@id='SubmitLogin']"));
		  clickOnElement(signin_Btn1);
		  implicitwait(10);
	  
		  WebElement women = driver.findElement(By.xpath("//a[text()='Women']"));
		  action(women, "moveToElement");
			  
		  WebElement evng_Dress = driver.findElement(By.xpath("//a[text()='Evening Dresses']"));
		  clickOnElement(evng_Dress);
		  
		  WebElement dress_Img = driver.findElement(By.xpath("//img[@title='Printed Dress']"));
		  scrollIntoView(dress_Img);
          action(dress_Img,"moveToElement");
		  sleep(3000);
         
          WebElement quick_View = driver.findElement(By.xpath("//a[@class='quick-view']"));
          clickOnElement(quick_View);
          sleep(3000);
         
		 // driver.switchTo().frame(0);   
          frameByIndex(0);
          sleep(3000);

		  WebElement plus = driver.findElement(By.xpath("//p[@id='quantity_wanted_p']/a[2]/span/i"));
		  clickOnElement(plus);
	      sleep(3000);
		  
		  WebElement size = driver.findElement(By.id("group_1"));
		  dropdown(size, "byValue", "2");
		  sleep(3000);
		  
		  WebElement color = driver.findElement(By.xpath("//a[@name='Pink']"));
		  clickOnElement(color);
		  sleep(3000);
		  
		  WebElement addtocart = driver.findElement(By.xpath("//button[@name='Submit']"));
		  clickOnElement(addtocart);
		  sleep(3000);			
		  		  
		  WebElement proceed = driver.findElement(By.xpath("//a[@title='Proceed to checkout']"));
		  clickOnElement(proceed);
		  sleep(3000);
		  
		  WebElement proceed1 = driver.findElement(By.xpath("//span[text()='Proceed to checkout']"));
		  clickOnElement(proceed1);
		  sleep(3000);
		  
		  WebElement proceed2 = driver.findElement(By.xpath("//span[text()='Proceed to checkout']"));
		  clickOnElement(proceed2);
		  sleep(3000);
		  
		  WebElement terms_Service = driver.findElement(By.xpath("//input[@type='checkbox']"));
		  clickOnElement(terms_Service);
		  sleep(3000);
		  
		  WebElement proceed3 = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		  clickOnElement(proceed3);
		  sleep(3000);		 
		
		  WebElement pay_Bank = driver.findElement(By.xpath("//a[@title='Pay by bank wire']"));
		  clickOnElement(pay_Bank);
		  sleep(3000);		 
		  
		  WebElement confirm_Order = driver.findElement(By.xpath("//span[text()='I confirm my order']"));
		  clickOnElement(confirm_Order);
		  sleep(3000);				 
		  
		  WebElement pageup = driver.findElement(By.xpath("//h1[text()='Order confirmation']"));
		  scrollIntoView(pageup);
		  sleep(3000);
         
		  screen_shot("C:\\Users\\soniya\\eclipse-workspace\\Final _Project\\Screenshot\\snap.png");
		  System.out.println("Screenshot1 done");
		  sleep(3000);
		   
		  WebElement t_Shirt = driver.findElement(By.xpath("(//a[text()='T-shirts'])[2]"));
		  clickOnElement(t_Shirt);
		  sleep(3000);		  

		  WebElement dress_Img1 = driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));
		  scrollIntoView(dress_Img1);
          action(dress_Img1, "moveToElement");
          sleep(3000);
		   
	      WebElement quick_View1 = driver.findElement(By.xpath("//a[@class='quick-view']"));
	      clickOnElement(quick_View1);
		  sleep(3000);	
		   
          frameByIndex(0);
          sleep(3000);
		
		  WebElement plus1 = driver.findElement(By.xpath("//p[@id='quantity_wanted_p']/a[2]/span/i"));
		  clickOnElement(plus1);
		  sleep(3000);		   			
			  
		  WebElement size1 = driver.findElement(By.id("group_1"));
		  dropdown(size1, "byValue", "2");
		  sleep(3000);
			  
		  WebElement color1 = driver.findElement(By.xpath("//a[@name='Blue']"));
		  clickOnElement(color1);
		  sleep(3000);
			
		  WebElement addtocart1 = driver.findElement(By.xpath("//button[@name='Submit']"));
		  clickOnElement(addtocart1);
		  sleep(3000);		    
			
		  WebElement tshirt_proceed = driver.findElement(By.xpath("//a[@title='Proceed to checkout']"));
		  clickOnElement(tshirt_proceed);
		  sleep(3000);
			
		  WebElement  tshirt_proceed1 = driver.findElement(By.xpath("//span[text()='Proceed to checkout']"));
		  clickOnElement(tshirt_proceed1);
		  sleep(3000);			
			  
		  WebElement  tshirt_proceed2 = driver.findElement(By.xpath("//span[text()='Proceed to checkout']"));
		  clickOnElement(tshirt_proceed2);
		  sleep(3000);				
			  
		  WebElement  tshirt_terms_Service = driver.findElement(By.xpath("//input[@type='checkbox']"));
		  clickOnElement(tshirt_terms_Service);
		  sleep(3000);				
			  
		  WebElement  tshirt_proceed3 = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
		  clickOnElement(tshirt_proceed3);
		  sleep(3000);				

		  WebElement  tshirt_pay_cheque = driver.findElement(By.xpath("//a[@class='cheque']"));
		  clickOnElement(tshirt_pay_cheque);
		  sleep(3000);		    
			  
		  WebElement  tshirt_confirm_Order = driver.findElement(By.xpath("//span[text()='I confirm my order']"));
		  clickOnElement(tshirt_confirm_Order);
		  sleep(3000);	
		  		   
		  WebElement pageup1 = driver.findElement(By.xpath("//h1[text()='Order confirmation']"));
		  scrollIntoView(pageup1);
	      sleep(3000);
       	      
	      screen_shot("C:\\Users\\soniya\\eclipse-workspace\\Final _Project\\Screenshot\\snap1.png");	          
	      System.out.println("Screenshot2 done");
		  sleep(3000);
		  
		  WebElement signout = driver.findElement(By.xpath("//a[@class='logout']"));
		  clickOnElement(signout);		
	}
}
