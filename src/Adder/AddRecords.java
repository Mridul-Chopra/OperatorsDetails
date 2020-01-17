package Adder;

import java.sql.*;
import net.Paxcel.*;
import java.util.Random;

public class AddRecords {
	
	private static PreparedStatement st;
	private static String sql;
	
	
	public static void main(String[] args)
	{
		try
		{
			Resources.loadResources();
			
			
			/*addOperators("Airtel" , "9876691201" , 10 , "Punjab" );
			addOperators("Airtel" , "9876691212" , 10 , "Mohali" );
			
			addOperators("Jio" , "9876691223" , 10 , "Punjab" );
			addOperators("Jio" , "9876691234" , 10 , "Mohali" );
			
			addOperators("Vodafone" , "9876691245" , 10 , "Punjab" );
			addOperators("Vodafone" , "9876691256" , 10 , "Mohali" );
			*/
			
			
			
			/*Random ran =  new Random();
			String start = "9876691201";
			
			for(int i =1; i<=50 ; i++)
			{
			char status = ran.nextInt(100)%2==0 ? 'Y' : 'N';
			
			int randomOffset = ran.nextInt(60);
			String sender = (Long.parseLong(start)+randomOffset)+"";
			
			randomOffset = ran.nextInt(60);
			String receiver = (Long.parseLong(start)+randomOffset)+"";
			
			String message = getMessage(10);
			
			addMessages(sender , receiver , message , status);
			}
			
			
			System.out.println("INSERTION SUCCESSFUL");*/
			
		}
		catch(Exception e)
		{
			System.out.print("Some Error occoureed while adding records");
		}
		
	}
	
	
	
	private static void addOperators(String name , String start , int offset , String Region) throws Exception
	{
		try 
		{
		sql = "Insert into OPERATORS values ( ? , ? , ? , ?)";
		st = Resources.conn.prepareStatement(sql);
		
		st.setString(1,name);
		st.setString(2,start+"");
		st.setString(3,(Long.parseLong(start)+offset)+"");
		st.setString(4,Region);
		
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
	
	

}
