package adder;

import java.sql.*;
import net.Paxcel.*;

import java.util.ArrayList;
import java.util.Random;

public class AddRecords {
	
/*	private static PreparedStatement st;
	private static String sql;
	private static ArrayList<String> n = new ArrayList<String>();
	
	public static void main(String[] args)
	{
		try
		{
			Resources.loadResources();
			
			
			int Airtel = 1;
			int Jio = 2;
			int BSNL = 3;
			
			int Punjab = 1;
			int Chandigarh = 2;
			
			String asp ="98766912";
			String asc ="98766920";
			String jsp ="98766921";
			String jsc ="98766922";
			String bsp ="98766931";
			String bsc ="98766932";
			
			
			
			 * Random ran = new Random();
			 * 
			 * int first = ran.nextInt(9); int second = ran.nextInt(9); String x =
			 * first+""+second; String number = bsc+ x;
			 * 
			 * for(int i=1;i<=10;i++) {
			 * 
			 * number = (Long.parseLong(number)+1)+""; addOperators(number,Chandigarh,BSNL);
			 * 
			 * }
			 * 
			 * System.out.print("DONE");
			 
			
			
			
			
			System.out.println("Hello");	
			get();
			Random ran = new Random();
			
			for(int  i =1 ; i<=200 ; i++)
			{
				String sender = n.get(ran.nextInt(n.size()));
				String receiver = n.get(ran.nextInt(n.size()));
				String message = getMessage(10);
				
				char status = ran.nextInt(100)%2==0 ? 'Y' : 'N';
			
				addMessages(sender, receiver , message , status);
			}
			
			
			System.out.println("INSERTION SUCCESSFUL");
			
		}
		catch(Exception e)
		{
			System.out.print("Some Error occoureed while adding records");
		}
		
	}
	
	
	
	private static void addOperators(String number , int region , int operator) throws Exception
	{
		try 
		{
		sql = "Insert into MOBILE_NUMBERS values ( ? , ? , ? ) ;";
		st = Resources.conn.prepareStatement(sql);
		
		st.setString(1,number);
		st.setInt(2,operator);
		st.setInt(3,region);
		
		st.executeUpdate();
		}
		catch(Exception e)
		{
			Resources.log.error("ADDING ERRROR :::::: -> "+e);
			throw new Exception();
			
		}
	}
	
	private static void addMessages(String sender, String receiver, String message , char status) throws Exception
	{
		try 
		{
			sql = "Insert into MESSAGES(SENDER , RECEIVER , MESSAGE , MESSAGE_STATUS) values ( ? , ? , ? , ?)";
			st = Resources.conn.prepareStatement(sql);
			
			st.setString(1,sender);
			st.setString(2,receiver);
			st.setString(3,message);
			st.setString(4,status+"");
			
			st.executeUpdate();
			
		}
		catch(Exception e)
		{
			Resources.log.error("ADDING ERRROR :::::: -> "+e);
			throw new Exception();
		}
		
	}
	
	// function to generate a random string of length n 
    private static String getMessage(int n) 
    { 
  
        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
  
        return sb.toString(); 
    } 
    
    
    private static void get() 
    {
    	sql = "Select NUMBER from MOBILE_NUMBERS ;";
		try 
		{
			st = Resources.conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			
			while(rs.next())
				n.add(rs.getString("NUMBER"));
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
    	
    	
    }
	
*/	

}
