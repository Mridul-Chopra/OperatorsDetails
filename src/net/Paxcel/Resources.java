package net.Paxcel;

import java.io.FileInputStream;
import java.util.*;
import org.apache.log4j.*;

import jdbcConnectionPool.Pool;

/**
 * @author Mridul
 *
 */
public class Resources  {
	
	public static Logger log;					// logger object 
	public static Properties connectionProp;	// properties for database connection
	private static String url , username , password , driver;
	
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
	 	Setting connection properties
	*/
	
	static
	{
		try
		{
			connectionProp = new Properties();     // contains connection properties
			connectionProp.load(new FileInputStream("src\\resources\\connectionProp.properties")); //loading the properties
			
			
			 /* Getting DB url , username ,password , driver */
			
			driver = connectionProp.getProperty("DB.Driver") ;
			url = connectionProp.getProperty("DB.url");
			username = connectionProp.getProperty("DB.username");
			password = connectionProp.getProperty("DB.password");
			
		}
		catch(Exception e)
		{
			log.error(e);									// logging the error
			System.out.println("Fatal Error. Exiting");     // Reporting to user
			System.exit(0);									// exiting the system
		}
		
	}
	
	/**
	 * 
	 */
	public static void loadResources()  // demo function to load all resources in static block
	{
		try
		{
			Pool.setMaxLimit(11); // setting max number of connections in pool
			Pool.setMinLimit(6);  // setting minimum number of connections in pool
			Pool.setMaxWaitngProcesses(4);  // setting waiting processes limit
			Pool.establishPool(url , username , password , driver );  // creating a pool
		}
		catch(Exception e)
		{
			System.out.println("Fatal Error. Exiting");     // Reporting to user
			System.exit(0);									// exiting the system
		}
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
