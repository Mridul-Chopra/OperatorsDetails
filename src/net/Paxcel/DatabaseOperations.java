package net.Paxcel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class DatabaseOperations {
	
	private String sql;
	private PreparedStatement st;
	private ResultSet rs;
	
		
	public ArrayList<String> printMessages(String sender , String receiver ) throws Exception 
	{
		try 
		{
			sql = "Select MESSAGE from MESSAGES where SENDER = ? and receiver = ?  ;";
			st = Resources.conn.prepareStatement(sql);
			
			st.setString(1,sender);
			st.setString(2, receiver);
			
			rs = st.executeQuery();
			
			ArrayList<String> messages = new ArrayList<String>();
			
			
				while(rs.next())
				{
					messages.add(rs.getString("MESSAGE"));
				}
				
			
			
			return messages;
			
		}
		catch(SQLException e)
		{
			Resources.log.error(e);
			throw new Exception();
		}
		
	}
	
	
	public ArrayList<String> printMessages(String sender , boolean isSender) throws Exception 
	{
		try 
		{	
			if(isSender)
				sql = "Select MESSAGE from MESSAGES where SENDER = ? ;";
			else
				sql = "Select MESSAGE from MESSAGES where RECEIVER = ? ;";
			
			st = Resources.conn.prepareStatement(sql);
			
			st.setString(1,sender);
			
			
			rs = st.executeQuery();
			
			ArrayList<String> messages = new ArrayList<String>();
			
			
				while(rs.next())
				{
					messages.add(rs.getString("MESSAGE"));
				}
				
			
			
			return messages;
			
		}
		catch(SQLException e)
		{
			Resources.log.error(e);
			throw new Exception();
		}
		
	}
	
	public ArrayList<String> printPunjabMessages(String receiver) throws Exception 
	{
		try 
		{	
			
				sql = "Select MESSAGES from OPERATORS JOIN MESSAGES where OPERATORS.REGION = 'Punjab' and MESSAGES.RECEIVER = ?";
			
			st = Resources.conn.prepareStatement(sql);
			
			st.setString(1,receiver);
			
			rs = st.executeQuery();
			
			ArrayList<String> messages = new ArrayList<String>();
			
			
				while(rs.next())
				{
					messages.add(rs.getString("MESSAGE"));
				}
				
			
			
			return messages;
			
		}
		catch(SQLException e)
		{
			Resources.log.error(e);
			throw new Exception();
		}
		
	}

}
