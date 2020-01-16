package net.Paxcel;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;
import org.apache.log4j.*;

public class Resources {
	
	public static Logger log;
	public static Properties connectionProp;
	public static Connection conn;
	
	
	static
	{
		try
		{
		log = Logger.getLogger("GLOBAL");
		Properties prop = new Properties();
		prop.load(new FileInputStream("src\\resources\\log4j.properties"));
		PropertyConfigurator.configure(prop);
		log.setLevel(Level.ERROR);
		}
		catch(Exception e)
		{
			System.out.println("Cannot load resources. Exiting");
			System.exit(0);
		}
	}
	
	
	static
	{
		try
		{
			connectionProp = new Properties();
			connectionProp.load(new FileInputStream("src\\resources\\connectionProp.properties"));
			PropertyConfigurator.configure(connectionProp);
			
			Class.forName(connectionProp.getProperty("DB.Driver"));
			conn = DriverManager.getConnection(connectionProp.getProperty("DB.url"));
			
			String url = connectionProp.getProperty("DB.url");
			String username = connectionProp.getProperty("DB.username");
			String password = connectionProp.getProperty("DB.password");
			
			conn = DriverManager.getConnection(url,username,password);
			
		}
		catch(Exception e)
		{
			log.error(e);
			System.out.println("Fatal Error. Exiting");
			System.exit(0);
		}
		
	}
	
	public static void loadResources()
	{}
	

}
