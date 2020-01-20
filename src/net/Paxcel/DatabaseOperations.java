package net.Paxcel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


/**
 * @author Mridul
 *
 */
public class DatabaseOperations {
	
	private String sql;					// contains sql queries
	private PreparedStatement st;		// PreparedStatement declared 
	private ResultSet rs;				// ResultSet declared
	
		
	/**
	 * @param sender :  sender number
	 * @param receiver : receiver number
	 * @return  returns Array List of messages
	 * @throws Exception
	 */
	public ArrayList<String> printMessages(String sender , String receiver ) throws Exception 
	{
		try 
		{
			sql = "Select MESSAGE from MESSAGES USE INDEX (MESSAGE_INDEX) where SENDER = ? and receiver = ?  ;";
			st = Resources.conn.prepareStatement(sql);    // getting the statement
			
			
			// Setting parameters in sql query						
			st.setString(1,sender);         
			st.setString(2, receiver);
			
			rs = st.executeQuery();
			
			ArrayList<String> messages = new ArrayList<String>();  // ArrayList to store messages
			
			// Saving messages to ArrayList
				while(rs.next())
				{
					messages.add(rs.getString("MESSAGE"));
				}
				
			
			
			return messages;   // returning messages
			
		}
		catch(SQLException e)
		{
			Resources.log.error(e);			// logging the encountered exception
			throw new Exception();			// throwing exception to be handled by driver
		}
		
	}
	
	
	/**
	 * @param number   : sender or receiver  number
	 * @param isSender : true if sender , false if receiver 
	 * @return         : returns ArrayList of messages
	 * @throws Exception
	 */
	public ArrayList<String> printMessages(String number , boolean isSender) throws Exception 
	{
		try 
		{	
			if(isSender)    // checking if sender
  				sql = "Select MESSAGE from MESSAGES USE INDEX (MESSAGE_INDEX)  where SENDER = ? ;";   // sql quuery if sender 
			else
				sql = "Select MESSAGE from MESSAGES where RECEIVER = ? ;"; // sql query if receiver
			
			st = Resources.conn.prepareStatement(sql);  // getting statement
			
			st.setString(1,number);    // setting parameters in query
			
			
			rs = st.executeQuery();   // execute query
			
			ArrayList<String> messages = new ArrayList<String>();
			
			/*
				Adding Messages to ArrayList
			*/
			while(rs.next())
				{
					messages.add(rs.getString("MESSAGE"));
				}
				
			
			
			return messages;
			
		}
		catch(SQLException e)
		{
			Resources.log.error(e);		// logging messages
			throw new Exception();		// throwing exception to be handled by driver
		}
		
	}
	
	/**
	 * @param receiver  : receiver number
	 * @return			: returns ArrayList of messages
	 * @throws Exception
	 */
	public ArrayList<String> printPunjabMessages(String receiver) throws Exception 
	{
		try 
		{	
			
			sql = "Select MESSAGES.MESSAGE from MESSAGES USE INDEX (MESSAGE_INDEX) INNER JOIN MOBILE_NUMBERS "
					+ "where MOBILE_NUMBERS.REGION_ID = '1' and MOBILE_NUMBERS.NUMBER = MESSAGES.SENDER "
					+ "AND MESSAGES.RECEIVER = ? ";     // sql quert declared
			
			st = Resources.conn.prepareStatement(sql);  // getting statement
			
			st.setString(1,receiver);					// setting parameters in query
			
			rs = st.executeQuery();					// executing query
			
			ArrayList<String> messages = new ArrayList<String>();
			
			/*
			Adding Messages to ArrayList
			 */
			while(rs.next())
				{
					messages.add(rs.getString("MESSAGE"));
				}
				
			
			
			return messages;
			
		}
		catch(SQLException e)
		{
			Resources.log.error(e);  // logging the exception
			throw new Exception();	 // throwing te exception o be handled by caller
		}
		
	}
	
	/**
	 * @param receiver  : receiver number
	 * @return			: returns ArrayList of messages
	 * @throws Exception
	 */
	public ArrayList<String> printPunjabAirtelMessages(String receiver) throws Exception // print messages of punjab airtel for a number
	{
		try 
		{	
			
			sql = "Select MESSAGES.MESSAGE from MESSAGES USE INDEX (MESSAGE_INDEX) INNER JOIN MOBILE_NUMBERS "
					+ "where MOBILE_NUMBERS.REGION_ID = '1' and MOBILE_NUMBERS.NUMBER = MESSAGES.SENDER "
					+ "AND MESSAGES.RECEIVER = ? "
					+ "AND MOBILE_NUMBERS.OPERATOR_ID = 1 ; ";		// sql query declared
			
			st = Resources.conn.prepareStatement(sql);     // gettting statement
			
			st.setString(1,receiver);     // setting parameters in query
			
			rs = st.executeQuery();      // executing the query
			
			ArrayList<String> messages = new ArrayList<String>();
			
			/*
			Adding Messages to ArrayList
			*/
			while(rs.next())
				{
					messages.add(rs.getString("MESSAGE"));
				}
				
			
			
			return messages;
			
		}
		catch(SQLException e)
		{
			Resources.log.error(e);  // logging the exception
			throw new Exception();	 // throwing new exception to be handled by caller
		}
		
	}
	

	/**
	 * @return
	 * @throws Exception
	 */
	public ArrayList<String> numberLike() throws Exception   // displays messages from numbers of specific pattern 
	{
		try 
		{	
			
		sql= "SELECT MESSAGE FROM MESSAGES USE INDEX (MESSAGE_INDEX) WHERE SENDER LIKE '98766912__'  ; ";  // sql Query 
			
			st = Resources.conn.prepareStatement(sql);      // Preparing statement
			rs = st.executeQuery();                        // Query execution
			ArrayList<String> messages = new ArrayList<String>();
			
			/*
				Storing Results in ArrayList
			*/
			while(rs.next())
				{
					messages.add(rs.getString("MESSAGE"));
				}
				
			
			
			return messages;
			
		}
		catch(SQLException e)
		{
			Resources.log.error(e);  // logging the exception
			throw new Exception();	// exception to be handled by caller
		}
		
	}
	
	
	/**
	 * @return
	 * @throws Exception
	 */
	public ArrayList<String> failedMessages() throws Exception   // displays messages from numbers of specific pattern 
	{
		try 
		{	
			
		sql= "SELECT MESSAGE FROM MESSAGES USE INDEX (MESSAGE_INDEX) INNER JOIN MOBILE_NUMBERS " + 
				"WHERE MESSAGES.SENDER = MOBILE_NUMBERS.NUMBER AND " + 
				"MOBILE_NUMBERS.REGION_ID = 1 AND MESSAGE_STATUS = 'N' ;";  // sql Query 
			
			st = Resources.conn.prepareStatement(sql);      // Preparing statement
			rs = st.executeQuery();                        // Query execution
			ArrayList<String> messages = new ArrayList<String>();
			
			/*
				Storing Results in ArrayList
			*/
			while(rs.next())
				{
					messages.add(rs.getString("MESSAGE"));
				}
				
			
			
			return messages;
			
		}
		catch(SQLException e)
		{
			Resources.log.error(e);  // logging the exception
			throw new Exception();	// exception to be handled by caller
		}
		
	}



}
