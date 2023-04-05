package com.ebanking.master;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Branch
{

	public static void main(String[] args) throws InterruptedException, IOException
			{
		
	//Instance Class
		
		Library LB=new Library();
		
		LB.OpenApp("http://103.211.39.246/ranford2");
		LB.AdminLgn("Admin","Mindq@Systems");
		
		//To Get Test Data File
		
		FileInputStream Fis=new FileInputStream("D:\\EvngProjMarch\\EBsnking\\src\\com\\ebanking\\testdata\\Branch.xlsx");
				//WorkBook
				
				XSSFWorkbook WB=new XSSFWorkbook(Fis);
				
				//Sheet
				
				XSSFSheet WS=WB.getSheet("Branchdata");
				
				//Row Count
				
			int	Rcount=WS.getLastRowNum();
			System.out.println(Rcount);
			
			//Multiple Iterations ...........
			
			for (int i=1; i<=Rcount;i++)
			{
				
				//Row
				
				XSSFRow WR=WS.getRow(i);
				
				//Cell
				
				XSSFCell WC=WR.getCell(0);
				XSSFCell WC1=WR.getCell(1);
				XSSFCell WC2=WR.getCell(2);
				XSSFCell WC3=WR.getCell(3);
				XSSFCell WC4=WR.getCell(4);
				XSSFCell WC5=WR.getCell(5);
				XSSFCell WC6=WR.createCell(6);
				
				//Cell Values
				String Brname=WC.getStringCellValue();
				String Add1=WC1.getStringCellValue();
				String Zip=WC2.getStringCellValue();
				String Country=WC3.getStringCellValue();
				String State=WC4.getStringCellValue();
				String City=WC5.getStringCellValue();
				
				
				String Res=LB.BranchCre(Brname,Add1,Zip,Country,State,City);
				System.out.println(Res);
	}


			}
}
