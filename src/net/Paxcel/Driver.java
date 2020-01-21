package net.Paxcel;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Mridul
 *
 */
public class Driver 
{

	public static void main(String[] args)	
	{
		try (Scanner sc = new Scanner(System.in))
		{	
			Resources.loadResources();  // loading required resources before program begins
		
		/*	
				PRINTING MESSAGES TO THE USER
		*/
			System.out.println("Welcome Users");
			System.out.println("1. Print messages received by a number from any number.");
			System.out.println("2. Print messages sent by any number.");
			System.out.println("3. Print messages received by any number.");
			System.out.println("4. Print messages received by a number from Punjab.");
			System.out.println("5. Print messages received by a number from Airtel Punjab.");
			System.out.println("6. Print messages received from 98766912**.");
			System.out.println("7. Print messages that were sent from Punjab and failed.");
			
			
			
			
			
			
			System.out.println("----------------------------------------------------------------------------");
			System.out.println("Copy the Following Inputs to get results (For 1 to 3 only): ");
			System.out.println("1. Sender : 9876692037    Receiver : 9876692244");
			System.out.println("2. Sender : 9876692037");
			System.out.println("3. Receiver : 9876692244");
			System.out.println("4. Receiver : 9876692244");
			System.out.println("5. Receiver : 9876692244");
			System.out.println("----------------------------------------------------------------------------");
		/*	
				MESSAGE PRINTING ENDS
		*/	
			
			int option = sc.nextInt();   // getting user's choice
			sc.nextLine();				// clearing scanner buffer
			
			DatabaseOperations operator = new DatabaseOperations();  // object of DatabaseOperations declared
			
			switch(option)
			{
				case 1:
				{
					/*PRINTING MESSAGES TO USER*/
					
					System.out.print("Enter Sender : ");
					String sender = sc.nextLine();
					System.out.print("Enter Receiver : ");
					String receiver = sc.nextLine();
					System.out.println("Messages are : ");
					
					/* MESSAGE PRINTING ENDS*/
					
					ArrayList<String>result = operator.printMessages(sender , receiver); // getting Messages
					
					if(result.isEmpty())
						System.out.println("NO RECORDS FOUND. ");   // if nothing found
					else 
					result.stream().forEach(System.out::println);  // printing messages
					
					break;
				}
				case 2:
				{
					/*PRINTING MESSAGES TO USER*/
					
					System.out.print("Enter Sender : ");
					String sender = sc.nextLine();
					System.out.println("Messages are : ");
					
					/* MESSAGE PRINTING ENDS*/
					
					ArrayList<String>result = operator.printMessages(sender , true);  // getting messages
					
					if(result.isEmpty())
						System.out.println("NO RECORDS FOUND. ");  // if no messages found
					else 
						result.stream().forEach(System.out::println);  // print messages
					
					break;
					
				}
				case 3:
				{
					/*PRINTING MESSAGES TO USER*/
					
					System.out.print("Enter Receiver : ");
					String receiver = sc.nextLine();
					System.out.println("Messages are : ");
					
					/* MESSAGE PRINTING ENDS*/
					
					ArrayList<String>result = operator.printMessages(receiver , false); // getting messages
					
					if(result.isEmpty())
						System.out.println("NO RECORDS FOUND. ");  // if no messages found
					else 
						result.stream().forEach(System.out::println);  // print messages
					
					break;
					
				}
				case 4:
				{
					/*PRINTING MESSAGES TO USER*/
					
					System.out.print("Enter Receiver : ");
					String receiver = sc.nextLine();
					System.out.println("Messages are : ");
					
					/* MESSAGE PRINTING ENDS*/
					
					ArrayList<String>result = operator.printPunjabMessages(receiver);  // getting messages
					System.out.println("Messages are : ");
					
					if(result.isEmpty())
						System.out.println("NO RECORDS FOUND. "); // if no messages found
					else 
						result.stream().forEach(System.out::println); // print messages
					
					break;
				}
				case 5:
				{
					/*PRINTING MESSAGES TO USER*/
					
					System.out.print("Enter Receiver : ");
					String receiver = sc.nextLine();
					System.out.println("Messages are : ");
					
					/* MESSAGE PRINTING ENDS*/
					
					ArrayList<String>result = operator.printPunjabAirtelMessages(receiver);  // getting messages
					System.out.println("Messages are : ");
					
					if(result.isEmpty())
						System.out.println("NO RECORDS FOUND. ");   // if no messages found
					else 
						result.stream().forEach(System.out::println); // print messages
					
					break;
					
				}
				case 6:
				{
					ArrayList<String>result = operator.numberLike();  // getting messages
					System.out.println("Messages are : ");
					
					if(result.isEmpty())
						System.out.println("NO RECORDS FOUND. ");  // if no messages found
					else 
						result.stream().forEach(System.out::println); // print messages
					
					break;
				}
				
				case 7:
				{
					ArrayList<String>result = operator.failedMessages();  // getting messages
					System.out.println("Messages are : ");
					
					if(result.isEmpty())
						System.out.println("NO RECORDS FOUND. ");  // if no messages found
					else 
						result.stream().forEach(System.out::println); // print messages
					
					break;
				}
				default:
				{
					System.out.println("Invalid Input");   // on invalid input
				}
				
			}
		Resources.releaseResources();	// releasing the resources before exiting
		}
		catch(Exception e)
		{
			System.out.println("Some error occoured");  // if any Exception caught
		}

	}		
}
