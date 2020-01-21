package net.Paxcel;

import java.io.FileInputStream;
import JDBCConnectionPool.Pool;
import java.util.*;
import org.apache.log4j.*;

/**
 * @author Mridul
 *
 */
public class Resources  {
	
	public static Logger log;					// logger object 
	public static Properties connectionProp;	// properties for database connection
	
	/*
	 *	Preparing the Logger
	*/
	static
	{
		try
		{
		log = Logger.getLogger("GLOBAL");  		// getting logger
		Properties prop = new Properties();		// contains logger properties
		prop.load(new FileInputStream("src\\resources\\log4j.properties")); // loading logger properties
		PropertyConfigurator.configure(prop);  // configuring properties
		log.setLevel(Level.ERROR);				// setting logging level
		}
		catch(Exception e)
		{
			System.out.println("Cannot load resources. Exiting");  
			System.exit(0);		// Exiting on unsucessfull loading
		}
	}
	
	/*
	 * 	Setting connection properties
	
	static
	{
		try
		{
			connectionProp = new Properties();     // contains connection properties
			connectionProp.load(new FileInputStream("src\\resources\\connectionProp.properties")); //loading the properties
			PropertyConfigurator.configure(connectionProp);  // configuring properties
			
			Class.forName(connectionProp.getProperty("DB.Driver"));		 // loading the DriverManager
			
			
			 * Getting DB url , username and password
			
			String url = connectionProp.getProperty("DB.url");
			String username = connectionProp.getProperty("DB.username");
			String password = connectionProp.getProperty("DB.password");
			
			conn = DriverManager.getConnection(url,username,password); // establishing connection
			
		}
		catch(Exception e)
		{
			log.error(e);									// logging the error
			System.out.println("Fatal Error. Exiting");     // Reporting to user
			System.exit(0);									// exiting the system
		}
		
	}*/
	
	/**
	 * 
	 */
	public static void loadResources()  // demo function to load all resources in static block
	{
		Pool.establishPool();
	}
	
	/**
	 * 
	 */
	public static void releaseResources()
	{
		try 
		{
			Pool.deletePool();	// Releasing the connection
		}
		catch(Exception ex)
		{
			log.error(ex);													// logging the error
			System.out.println("Fatal Error. Abnormal Termination");     	// Reporting to user
			System.exit(0);													// exiting the system
		}
	}

}
