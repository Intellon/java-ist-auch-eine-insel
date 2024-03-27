package com.tutego.exercises.optim;
import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class TestMBeanClient
{
	public static void main(String[] args) throws Exception
	{
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		
       ObjectName name = new ObjectName("com.example.mbeans:type=Hello"); 
  
       Basic mbean = new Basic(); 
  
       mbs.registerMBean(mbean, name); 
		
		while (true)
		{
			Thread.sleep(1000);
			
//			System.out.println( mbean.getData() );
			
		}
	}
}
