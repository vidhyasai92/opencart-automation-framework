package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

/**
 * TestNG listener that creates an Extent HTML report under {project}/reports/.
 * File name example: Test-Report-2025.10.07.13.42.22.html
 */
public class ExtendReportUtility implements ITestListener {

    private ExtentSparkReporter sparkReporter;
    private ExtentReports extent;
    private ExtentTest test;
    private String repName;

    @Override
    public void onStart(ITestContext context) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repName = "Test-Report-" + timeStamp + ".html";

        // report path -> {project root}/reports/Test-Report-*.html
        String reportPath = System.getProperty("user.dir") + "/reports/" + repName;

        sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.config().setDocumentTitle("OpenCart Automation Report");
        sparkReporter.config().setReportName("OpenCart Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        // System info (safe if params are absent)
        extent.setSystemInfo("Application", "OpenCart");
        extent.setSystemInfo("Module", "Admin");
        extent.setSystemInfo("Sub Module", "Customers");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");

        String os = context.getCurrentXmlTest() != null ? context.getCurrentXmlTest().getParameter("os") : null;
        if (os != null) extent.setSystemInfo("Operating System", os);

        String browser = context.getCurrentXmlTest() != null ? context.getCurrentXmlTest().getParameter("browser") : null;
        if (browser != null) extent.setSystemInfo("Browser", browser);

        List<String> groups = context.getCurrentXmlTest() != null ? context.getCurrentXmlTest().getIncludedGroups() : null;
        if (groups != null && !groups.isEmpty()) extent.setSystemInfo("Groups", groups.toString());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String className = result.getTestClass().getRealClass().getSimpleName(); // ✅ your test class
        String methodName = result.getMethod().getMethodName();                  // ✅ your test method

        test = extent.createTest(className + " - " + methodName); // shows e.g. TC_001AccountRegTest - verify_account_registration
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.PASS, methodName + " passed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String className = result.getTestClass().getRealClass().getSimpleName();
        String methodName = result.getMethod().getMethodName();

        test = extent.createTest(className + " - " + methodName);
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL, methodName + " failed");

        if (result.getThrowable() != null) {
            test.log(Status.INFO, result.getThrowable().getMessage());
        }

        try {
            String imgPath = new BaseClass().captureScreen(methodName);
            test.addScreenCaptureFromPath(imgPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String className = result.getTestClass().getRealClass().getSimpleName();
        String methodName = result.getMethod().getMethodName();

        test = extent.createTest(className + " - " + methodName);
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, methodName + " skipped");

        if (result.getThrowable() != null) {
            test.log(Status.INFO, result.getThrowable().getMessage());
        }
    }


    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
        }
        // Auto-open the report (works on macOS too)
        try {
            File report = new File(System.getProperty("user.dir") + "/reports/" + repName);
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(report.toURI());
            }
        } catch (IOException ignored) { }
    

 /*   try {
        // Construct the report URL (use forward slashes for compatibility)
        URL reportUrl = new URL("file:///" + System.getProperty("user.dir") + "/reports/" + repName);

        // Create and configure the email
        ImageHtmlEmail email = new ImageHtmlEmail();

        // Set the Data Source Resolver to correctly render images from local HTML report
        email.setDataSourceResolver(new DataSourceUrlResolver(reportUrl));

        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("vidhyasai92@gmail.com", "vidhya"));
        email.setSSLOnConnect(true);
        email.setFrom("vidhyasai92@gmail.com", "Automation Reports");
        email.setSubject("Automation Test Results");
        email.setMsg("Hello,Please find the attached test execution report.\n\nRegards,\nQA Automation Team");

        // Add recipient(s)
        email.addTo("recipient@example.com");

        // Attach the Extent Report
        email.attach(reportUrl, "Extent Report", "Please check the attached test report.");

        // Send the email
        email.send();

        System.out.println("Test report emailed successfully with embedded images!");

    } catch (Exception e) {
        System.err.println("Failed to send test report email: " + e.getMessage());
        e.printStackTrace();
    }
*/

}
        
    }

