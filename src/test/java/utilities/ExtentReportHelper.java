package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentSparkReporterConfig;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.util.logging.Logger;

public class ExtentReportHelper {

    public static ExtentReports extent;
    private static ExtentSparkReporter htmlReporter;
    private static ExtentTest test;
    private static final Logger log = Logger.getLogger(ExtentReportHelper.class.getName());

    public static ExtentReports ExtentDemo(String reportName) {
        try {
            extent = new ExtentReports();

            // ✅ Define report path
            String reportPath = System.getProperty("user.dir") + "/Output/" + reportName + ".html";
            htmlReporter = new ExtentSparkReporter(reportPath);

            // ✅ Configure ONLY via builder (NO external config file)
            ExtentSparkReporterConfig config = ExtentSparkReporterConfig.builder()
                    .offlineMode(true)
                    .theme(Theme.DARK)
                    .documentTitle("Automation Report")
                    .reportName("Automation Test Results")
                    .encoding("utf-8")
                    .timeStampFormat("yyyy-MM-dd HH:mm:ss")
                    .build();

            htmlReporter.config(config);

            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Host Name", "Yogesh-PC");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("User Name", "Yogesh Solanki");

        } catch (Exception ex) {
            log.warning("Failed to initialize Extent Report: " + ex.getMessage());
        }
        return extent;
    }
}
