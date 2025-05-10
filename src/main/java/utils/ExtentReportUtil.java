package utils;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtil {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static void startTest(String testName) {
        if (extent == null) {
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
        }
        ExtentTest scenarioTest = extent.createTest(testName);
        test.set(scenarioTest);
    }

    public static ExtentTest getTest() {
        return test.get();
    }

    public static void endTest() {
        if (extent != null) {
            extent.flush();
        }
    }
}
