package Tests;

import static org.junit.Assert.assertEquals;
import net.Paxcel.*;
import java.util.ArrayList;
import java.util.stream.Stream;
import org.junit.Test;

public class Tester {
	
	ArrayList<String> expectedOutput= new ArrayList<String>();
	private DatabaseOperations operator = new DatabaseOperations();

	@Test
	public void testSetup()
	{	
		try 
		{
		
		setOutput(new String[]{"lmUE1I6bvn"});
		assertEquals(expectedOutput ,   operator.printMessages("9876692037" , "9876692244"));   //1 
		
		setOutput(new String[]{"lmUE1I6bvn", "jDvjbsHCV0", "LKDlx1Lgbj", "nuvHKqQzN5"});
		assertEquals(expectedOutput ,   operator.printMessages("9876692037" , true));  //2
		
		setOutput(new String[]{"lmUE1I6bvn"});
		assertEquals(expectedOutput ,   operator.printMessages("9876692244" , false));		//3
		
		setOutput(new String[]{"LTNdZq1yRh", "aIuGtooazD", "ipSeHavnBT", "RE02zcDkjq", "75gFYu7gu5"});
		assertEquals(expectedOutput ,   operator.printPunjabMessages("9876692242"));  //4
		
		setOutput(new String[]{"LTNdZq1yRh"});
		assertEquals(expectedOutput ,   operator.printPunjabAirtelMessages("9876692242"));  //5
		
		setOutput(new String[]{"tOSz8UHRk2", "CKNAKZXu23", "5s4fPPJZIB", "eSPrUEnMTa", "kRdVUoLxOM", "Cvr7oR5eAt", "8Xzn1M8klz", "2n2KqVi69I", "LTNdZq1yRh", "5M3sRqiTqi", "v3CTneMgMI", "4vgzHVyaST", "xgMKXP9BqW", "Unn1vimeo2", "PVZEdX3B6k", "lXtm5RJjvF", "x0aKYi5g04", "D1IYq7c5ay", "Zp2mhyLPs7", "PcJmz8ATAm", "MC3oNfayPc", "QQAWfxPPuS", "R0pijeynqv", "eRtBlvQoKl", "AlSR3vSZqt", "7ehc6qcV0G", "0JvXvP5YZo", "8kMmB8Govo", "F6h0em1ez6", "2UuPDqMbaX", "spTRCHYgTT", "LATmjkvgWA", "fcluxtVFLE", "9t5CPQDVJO", "j4B9DUpWnD", "PPYYAlKA3h", "EUGxEZaJt5", "K0EvYipKBo", "TWC6hv64E9", "pIKfJuRNYo", "jLSqUKvC35"});
		assertEquals(expectedOutput ,   operator.numberLike()); //6
		
		/*setOutput(new String[]{"lmUE1I6bvn"});
		assertEquals(expectedOutput ,   operator.failedMessages());  // very long output
		*/
		
		}
		
		catch(Exception e)
		{
			System.out.println("Exception Occoured while testing");
		}
	}
	
	
	private void setOutput(String ar[])
	{
		expectedOutput.clear();
		Stream.of(ar)
					.forEach(
							
							i-> expectedOutput.add(i)
							
							);;
	}
}
