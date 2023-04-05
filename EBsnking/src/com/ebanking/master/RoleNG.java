package com.ebanking.master;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RoleNG extends Base
{
  @Test(dataProvider="Rdata")
  public void Role() throws InterruptedException
  {
     LB.Role("GeneralManagerQC","E");
  }
  @DataProvider
  
  public Object [][] Rdata()
  {
   Object [][] obj=new Object[3][2];
   
   obj[0][0]=""