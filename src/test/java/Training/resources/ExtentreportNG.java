package Training.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentreportNG {
	

	public static ExtentReports ERConfig()
	{
		ExtentSparkReporter ESR = new ExtentSparkReporter(System.getProperty("user.dir")+"//report//result.html");
		ESR.config().setReportName("FrameworkTest");
		ESR.config().setDocumentTitle("Test Results");
		
		ExtentReports ER = new ExtentReports();
		ER.attachReporter(ESR);
		ER.setSystemInfo("Tester", "Sriram");
		return ER;
		
		
	}
	
	
}
