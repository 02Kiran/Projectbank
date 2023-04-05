package com.ranfordbank.keyword;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Sleeper;


public class Lib
{
                     public static Properties Pr;
                     public static FileInputStream Fis;
                     public static WebDriver driver;
                     public static String Expval,Actval;
                     
                     public String openApp(String Url)
                     {
                    	 String Expval="Ranford Bank";
                    	 driver=new FirefoxDriver();
                    	           driver.getClass(Url);
                    	  Sleeper.sleepTightInSeconds(4);
                    	  String Actval=driver.findElement(By.ByXPath("\"/html/body/form/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[1]/td[4]/p/span\")).getText();"))
                     
                    			        System.out.println(Actval);
                    	  if (Expval.equalsIgnoreCase(Actval))
                    	  {
                    		  
                    		  System.out.println("Application is launched");
                    		  return "pass";
                    		  }
                    	  else
                    	  {
                    		  System.out.println("Application not opened");
                    		                     return "fail";
                    	  }
                    	  }
                    	  public String AdmLgn(String Un, String Pwd)
                    	  {
                    		  Expval="Welcome to Admin";
                    		  driver.manage().window().maximize();
                    		  driver.findElement(By.id("login")).click();
                     }
                     
                     
                     
}
