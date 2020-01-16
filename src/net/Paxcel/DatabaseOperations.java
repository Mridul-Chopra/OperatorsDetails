package net.Paxcel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;


public class DatabaseOperations {
	
	private String sql;
	private PreparedStatement st;
	private ResultSet rs;
	
		
	public ArrayList<String> printMessage(int sender , int receiver ) throws Exception 
	{
		try 
		{
			sql = "Select MESSAGES from ******* where SENDER = ? and receiver = ?  ;";
			st = Resources.conn.prepareStatement(sql);
			st.setInt(1,sender);
			st.setInt(1, receiver);
			
			rs = st.executeQuery();
			
			ArrayList<String> messages = new ArrayList<String>();
			
			if(!rs.next())
			{
				return null;
			}
			
			else
			{
				while(rs.next())
				{
					messages.add(rs.getString("MESSAGES"));
				}
				
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
