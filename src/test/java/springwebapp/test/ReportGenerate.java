package springwebapp.test;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ReportGenerate  implements ITestListener{
	public static int pass=0;
	public static int fail=0;
	public static int skip=0;
	

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		pass++;
		
	}

	public void onTestFailure(ITestResult result) {
		fail++;
	}

	public void onTestSkipped(ITestResult result) {
		skip++;
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Pass...."+pass);
		System.out.println("Fail...."+fail);
		System.out.println("Skip...."+skip);
		
		PieChart.chart(pass,fail,skip);
		
	}

}
