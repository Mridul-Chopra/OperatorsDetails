package tests;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args)
	{
		Result result = JUnitCore.runClasses(Tester.class);
		
		for(Failure failure : result.getFailures())
			System.out.println(failure.toString());   // displays expected and actual output
	}
}
