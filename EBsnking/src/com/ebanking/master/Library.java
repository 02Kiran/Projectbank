package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Library
 {
	public static WebDriver driver;
    public static String Expval,Actval;
	public static  FileInputStream FIS;
	public static Properties PR;
	 
	 
	 public String OpenApp(String URL) throws IOException
	 {
		 
		 FIS=new FileInputStream("D:\\EvngProjMarch\\EBsnking\\src\\com\\ebanking\\properties\\Exp.properties");
		 PR=new Properties();
		 PR.load(FIS);
		 
		 Expval="Ranford Bank";
	 
		
		//Launch Browser
		
		
		 driver=new FirefoxDriver();
			
		//Maximize
		
		driver.manage().window().maximize();
		
		//URL
		
		
		driver.get(URL);
		
		//Actual Value
		
		 Actval=driver.findElement(By.xpath("/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span")).getText();
		
		//Comparison
		
		if (Expval.equalsIgnoreCase(Actval))
		{
			System.out.println("Application Launch Succ");
		}
		else
		{
			System.out.println("Application Failed to Launch");
		}
	      return "Pass";
	 }
	 
	 public String AdminLgn(String Un,String Pwd) throws InterruptedException
	 {
		 Expval="welcome to Admin";		
			
			driver.findElement(By.id(PR.getProperty("Uname"))).sendKeys(Un);
			driver.findElement(By.id(PR.getProperty("Pswd"))).sendKeys(Pwd);
			Thread.sleep(3000);
			driver.findElement(By.xpath(PR.getProperty("Lgn"))).click();
			
			Actval=driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/strong/font/font")).getText();
			
			//Comparison
			
			if (Expval.equalsIgnoreCase(Actval))
			{
				System.out.println("Admin Login Succ");
			}
			else
			{
				System.out.println("Admin Login Failed");
			}
			    return "Actval";
	 }  		
	        //Branch Creation
			    		 public String BranchCre(String Bname,String add1,String ZC,String Contry,String Sta, String Cty) throws InterruptedException
			    		 {    		 
			    		 Expval="Sucessfully";
			    		
			    		
			driver.findElement(By.xpath(PR.getProperty("Brbutton"))).click();
			driver.findElement(By.id(PR.getProperty("NewBbutton"))).click();
	
			driver.findElement(By.id(PR.getProperty("BrName"))).sendKeys(Bname);
			driver.findElement(By.id(PR.getProperty("Add1"))).sendKeys(add1);
			driver.findElement(By.id(PR.getProperty("Zip"))).sendKeys(ZC);
			
			//Drop Down
			
			Select ctry=new Select(driver.findElement(By.id(PR.getProperty("Contry"))));
			ctry.selectByVisibleText(Contry);
		
			new Select(driver.findElement(By.id(PR.getProperty("state")))).selectByVisibleText(Sta);
			new Select(driver.findElement(By.id(PR.getProperty("City")))).selectByVisibleText(Cty);
			
			//Submit
			 driver.findElement(By.id(PR.getProperty("BSubmit"))).click();
			 
			 driver.switchTo().alert().getText();
		
			 
			 //comparison
			 
				if (Actval.contains(Expval))
				{
					System.out.println("Branch Created");
				}
				else
				{
					System.out.println("Branch Already Exist");
				}
				
			 
			     //Alert
			     driver.switchTo().alert().accept();
			     driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")).click();		 
			    
			     return Actval;  
			     }
			    	//Role		
					 public String Role(String Rname, String Rtpe) throws InterruptedException
			    		 {
			    	 Expval="Sucessfully";
			
		     driver.findElement(By.xpath(PR.getProperty("RButton"))).click();
	     	 driver.findElement(By.id(PR.getProperty("NewRButton"))).click();
		 
		 
	     	//Role Creation
		 
		    driver.findElement(By.id(PR.getProperty("RName"))).sendKeys(Rname);
		 
	    	 //Drop Down
		     new Select(driver.findElement(By.id(PR.getProperty("RType")))).selectByVisibleText(Rtpe);

			
			//Submit
			
		   driver.findElement(By.id(PR.getProperty("RSubmit"))).click();
		  
		    Actval=driver.switchTo().alert().getText();
			 
			 //comparison
			 
				if (Actval.contains(Expval))
				{
					System.out.println("Role Created");
				}
				else
				{
					System.out.println("Role Already Exist");
				}
				
			   
				   //Alert
				
		         driver.switchTo().alert().accept();
		         driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")).click();
		         
		         return Actval;
		         
			    		 }
					 //Employee creation
			    		 
			  	 public String Employee(String Ename, String Epwd, String  ERol, String Brach) throws InterruptedException
			    		 {
			   	 Expval= "Successfully";
			    
		        driver.findElement(By.xpath(PR.getProperty("EButton"))).click();
		        driver.findElement(By.id(PR.getProperty("ENewE"))).click();
		        driver.findElement(By.id(PR.getProperty("EUName"))).sendKeys(Ename);
	        	driver.findElement(By.id(PR.getProperty("Epw"))).sendKeys(Epwd);
		 
	        	 //Drop Down
		 
		       new Select(driver.findElement(By.id(PR.getProperty("ERol")))).selectByVisibleText(ERol);
	       	 new Select(driver.findElement(By.id(PR.getProperty("EBrach")))).selectByVisibleText(Brach);
		 
		      //Submit
		       driver.findElement(By.id(PR.getProperty("ESubmit"))).click();
		     
		      
              Actval=driver.switchTo().alert().getText();
		 
		 //comparison
		 
			if (Actval.contains(Expval))
			{
				System.out.println("Employee Created");
			}
			else
			{
				System.out.println("Employee Already Exist");
			}
		  
		
		 //Alert
			
		     driver.switchTo().alert().accept();
		 
		 
		    driver.findElement(By.xpath("/html/body/div/form/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[3]/table/tbody/tr/td[1]/a/img")).click();
		    
		    return Actval;
		 
		 //Logout
		 
	}
	 
	       public void AdminLogOut()
	 {
		    driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td[4]/table/tbody/tr/td[3]/a/img")).click();
      
	 }    
	 
	 
	 
	       public void Close()
	 { 
           driver.close(); 
	 
	 }
	       
 }

		
			
			
		
		    
		
		
			
		
	 
	 

	
	
		 
	 
	 

		
		
		 
	 
	
	 
	 
 
	

	

	
	
	
	
	

	

	


