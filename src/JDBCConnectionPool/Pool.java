package JDBCConnectionPool;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
import net.Paxcel.Resources;


/**
 * @author Mridul
 *
 */
public class Pool
{
	
private static Queue<Connection> pool = new LinkedList<Connection>();  // Contains all Connection Objects 
private static Properties connectionProp;							//	Contains Connection Object

	static
	{
		try
		{
			connectionProp = new Properties();     // contains connection properties
			connectionProp.load(new FileInputStream("src\\resources\\connectionProp.properties")); //loading the properties
			
			
			Class.forName(connectionProp.getProperty("DB.Driver"));		 // loading the DriverManager
			
			/*
			 * Getting DB url , username and password
			*/
			String url = connectionProp.getProperty("DB.url");
			String username = connectionProp.getProperty("DB.username");
			String password = connectionProp.getProperty("DB.password");
			
			for(int i =1 ; i<=5 ;i++)
			{
				Connection conn = DriverManager.getConnection(url,username,password); // establishing connection 
				pool.add(conn);		// adding connection  to queue
			}
		}
		catch(Exception e)
		{
			Resources.log.error(e);							// logging the error
			System.out.println("Fatal Error. Exiting");     // Reporting to user
			System.exit(0);									// exiting the system
		}
		
	}
	
	
	/**
	 * @return  :  returns Connection object
	 */
	public static Connection get()
	{
		while(pool.peek()==null);    // busy waiting if no connection is available
		
		return pool.remove();		// returning connection object and removing from queue
	}
	
	
	/**
	 * @param cn  : getting back connection and inserting to pool
	 */
	public static void returnBack(Connection cn)
	{
		pool.add(cn);		// adding connection to pool
	}
	
	/**
	 * 
	 */
	public static  void establishPool() // just to run the static block
	{}
	
	/**
	 * 
	 */
	public static void deletePool()  // function to delete all connections in pool
	{	
		pool.stream().forEach(i->{
			try {
				i.close();		// closing all the connections
			} catch (SQLException e) {
				Resources.log.error(e);  // logging error on exception
			}
		});
		pool.clear();		// deleting all the elements of pool
		
	}

}
