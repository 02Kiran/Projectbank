package com.ebanking.master;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Notepad {

	public static void main(String[] args) throws IOException, InterruptedException
	{
		
		//Instance Class
		
				Library LB=new Library();
				
				LB.OpenApp("http://103.211.39.246/ranford2");
				LB.AdminLgn("Admin","Mindq@Systems");
				
				//To Get Test Data File Path
				
				String Fpath="D:\\EvngProjMarch\\EBsnking\\src\\com\\ebanking\\testdata\\Role.txt";
				
				//Results File Path
				
				String Rpath="D:\\EvngProjMarch\\EBsnking\\src\\com\\ebanking\\results";
				String SD;
				//To Get Test Data File
				
				FileReader FR=new FileReader(Fpath);
				BufferedReader BR=new BufferedReader(FR);
				String Sread=BR.readLine();
				System.out.println(Sread);
				
				//To write Header into Results File
				
				FileWriter FW=new FileWriter(Rpath);
				BufferedReader BW=new BufferedReader(FR);
				BW.write(Sread);
				BW.newLine();
				
				//Multiple Iterations.......
				
			
				while ((SD=BR.readLine())!=null)
				{
					System.out.println(SD);W
					
					//Split
					
				String SR[]=SD.split("###");
				
				String Rname=SR[0];
				String Rty=SR[1];
				
				String Res=LB.Role(Rname,Rty);
				System.out.println(Res);
				
				//Results
				
				 BW.write(SD+"$*^%*^"+Res);
				 BW.newLine();
				
				}
				
				 BW.close();
				 BR.close();			 				
	           
	             }

}
