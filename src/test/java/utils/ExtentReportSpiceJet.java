package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentReportSpiceJet {
	public static ExtentReports report() {
	
	String path="E:\\guvi\\SpiceJet\\report\\SpiceJetReport.html";
	// To create report in the given location
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Raswanth");
	
	// To capture test data
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(reporter);
	
	return extent;
	}
}
