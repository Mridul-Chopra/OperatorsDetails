package net.Paxcel;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver 
{

	public static void main(String[] args)	
	{
		try (Scanner sc = new Scanner(System.in))
		{	Resources.loadResources();
		
			System.out.println("Welcome Users");
			System.out.println("1. Print messages received by a number from any number.");
			System.out.println("2. Print messages sent by any number.");
			System.out.println("3. Print messages received by any number.");
			System.out.println("4. Print messages received by a person from other person.");
			System.out.println("5. Print messages received by a number from Airtel Punjab.");
			System.out.println("6. Print messages received from 987869112**.");
			
			int option = sc.nextInt();
			DatabaseOperations operator = new DatabaseOperations();
			
			switch(option)
			{
				case 1:
				{
					ArrayList<String>result = operator.printMessage(1,2);
					result.stream().forEach(System.out::print);
					break;
				}
				case 2:
				{
					break;
				}
				case 3:
				{
					break;
				}
				case 4:
				{
					break;
				}
				case 5:
				{
					break;
				}
				case 6:
				{
					break;
				}
				default:
				{
					System.out.println("Invalid Input");
				}
				
			}
			
		}
		catch(Exception e)
		{
			System.out.println("Some error occoured");
		}

	}		
}
