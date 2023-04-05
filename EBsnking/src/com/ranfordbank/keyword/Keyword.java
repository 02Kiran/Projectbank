package com.ranfordbank.keyword;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Keyword
{
        public static void main(String[] args)
        {
			//Instance class
        	Lib LB=new Lib();
        	
        	String Res=null;
        	
        	String Kpath="D:\\EvngProjMarch\\EBsnking\\src\\com\\ranfordbank\\keyword\\Keyword_data.xslx.xlsx";
        	String Kout="D:\\EvngProjMarch\\EBsnking\\src\\com\\ranfordbank\\keyword\\Res.Keyword_data.xlsx";
        	
	
        
        FileInputStream fi=new FileInputStream(xpath);
        
        //WorkBook
        
    	
		XSSFWorkbook WB=new XSSFWorkbook(fi);
		
		//Sheet
		
		XSSFSheet WS=WB.getSheet("TestCase");
		XSSFSheet WS1=WB.getSheet("TestSteps");
		
		XSSFSheet WS2=WB.getSheet("TestData");
		
		//Row Count
		
	      int tcRc=WS.getLastRowNum();
	        System.out.println(tcRc);
	        
	        

		      int tsRc=WS1.getLastRowNum();
		        System.out.println(tsRc);
		        
	        //test cases
	        

	    	for (int i=1; i<=tcRc;i++)
	    	{
	          String exe=WS.getRow(1).getCell(2).getStringCellValue();
	          if (exe.equalsIgnoreCase("Y"))
	          {
	        	  String tcId=WS.getRow(1).getCell(2).getStringCellValue();
	        	System.out.println(tcId);
	        	
	          //test steps
	        	
	        	for (int j=1; j <=tsRc; j++)
		    	{
		          String tsTcId=WS1.getRow(1).getCell(0).getStringCellValue();
		          System.out.println(tsTcId);
		           if (tcId.equalsIgnoreCase("tsTcid"))
		          {
		        	  String key=WS1.getRow(1).getCell(3).getStringCellValue();
		        	System.out.println(key);
		        	switch (key) 
		        	{
					case "RLaunch":
						Res=LB.openApp("http://122.175.8.158/ranford2");
						break;
					case "RLogin";
					      Res=LB.AdminLgn("Admin","Mindq@Systems");
					      break;
					case "RLogout:"
							LB.admlgt();
					       break;
					case "RBranch";
					      LB.branch();
					case "RRole":
						   Res=LB.Role("Cashierjhg","E");
						   break;
					case "RClose":
						LB.Appc();
						   break;
					
					default:
						System.out.println("Pass a Valid keyword");
						break;	
						}
		        	//result updation in test steps sheet:
		        	
		        	WS1=getRow(j).createCell(4).setCellValue(Res);
		        	
		        	//result updation in test case sheet:
		        	
		        	if (!WS1.getRow(j).getCell(4).getStringCellValue().equalsIgnoreCase("Fail"));
		        	{
		        		WS.getRow(i).createCell(3).setCellValue(Res);
		        	}
		        	else
		        	{
		        	     WS.getRow(i).createCell(3).setCellValue("Fail");
		        	}
		        	     
		          }     
		        	     
		        	
		        	
		        	
	          
	          }
	
	
        
                             }
	                       else
	                       {
	                    	   WS.getRow(i).createCell(3).setCellValue("BLOCKED");
	                       }
        
	    	           }
	    	               FileOutputStream fo=new FileOutputStream(kout);
	    	               WB.write(fo);
	    	               WB.close();
	    	               
                    }
	    	                      
}
