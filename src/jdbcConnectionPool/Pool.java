package jdbcConnectionPool;


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
private static String url_ , username_ , password_ , driver_;   // contains connection information
private static boolean isSet = false; 							// checks if properties were already set or not
private static int numberOfWaitingProcesses = 0;               // contains count of waiting processes
private static int maxLimit = 10;								// maximum number of connections in pool
private static int minLimit = 5;								// minimum number of connections in pool
private static int 	maxWaitngProcesses = 3;						// maximum number of processes that can wait
	
	



	/**
	 * @return  :  returns Connection object
	 */
	public static synchronized Connection get()
	{
		if(pool.peek() == null)
			numberOfWaitingProcesses++; // increasing the count of waiting processes
		
		if(numberOfWaitingProcesses<=maxWaitngProcesses)
			while(pool.peek()==null);    // busy waiting if no connection is available
		else
		{
			if(!createMoreConnections())    // create more connections if not max limit reached
				while(pool.peek()==null);	// busy waiting if max limit reached
		}
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
	public static  void establishPool(String url , String username , String password , String driver) throws Exception // just to run the static block
	{	
		if(isSet)
		{
			Resources.log.error("Pool Properties were already set. Can only set once");
			throw new Exception();
		}
		
		url_ = url;
		username_ = username;
		password_ = password;
		driver_= driver;
		
		
		try
		{
			
			Class.forName(driver_);		 // loading the DriverManager
			for(int i =1 ; i<=minLimit ;i++)
			{
				Connection conn = DriverManager.getConnection(url_,username_,password_); // establishing connection 
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
	
	/**
	 * 
	 */
	public static boolean createMoreConnections() // to create additional connections
	{
		try
		{
			if(pool.size() >= maxLimit )
				return false;
			
			Class.forName(driver_);		 // loading the DriverManager
			for(int i =1 ; i<=3 ;i++)
			{
				Connection conn = DriverManager.getConnection(url_,username_,password_); // establishing connection 
				pool.add(conn);		// adding connection  to queue
			}
			
			
		}
		catch(Exception e)
		{
			Resources.log.error(e);							// logging the error
		}
			
			return true;
		
	}
	
	
	/*		
	 * 
	 *   GETTERS AND SETTERS START
	 *
	 * -----------------------------------------------------------------------------------
	 */
	
	public static int getMinLimit() {
		return minLimit;
	}


	public static void setMinLimit(int minLimitP) throws Exception {
		if(isSet)
		{
			Resources.log.error("Pool Properties were already set. Can only set once");
			throw new Exception();
		}
		else if(minLimit <0 )
		{
			Resources.log.error("Maximum Limit of connections in pool cannot be zero");
			throw new Exception();
		}
		minLimit = minLimitP;
	}


	public static int getMaxLimit_() {
		return maxLimit;
	}


	public static void setMaxLimit(int maxLimitP) throws Exception
	{	
		if(isSet)
		{
			Resources.log.error("Pool Properties were already set. Can only set once");
			throw new Exception();
		}
		
		else if(maxLimit <0 )
		{
			Resources.log.error("Maximum Limit of connections in pool cannot be zero");
			throw new Exception();
		}
		maxLimit = maxLimitP;
	}


	public static int getMaxWaitngProcesses() {
		return maxWaitngProcesses;
	}


	public static void setMaxWaitngProcesses(int maxWaitngProcesses) {
		
		Pool.maxWaitngProcesses = maxWaitngProcesses;
	}

	/*		
	 * 
	 *   GETTERS AND SETTERS END
	 *
	 * -----------------------------------------------------------------------------------
	 */
	
	
}
