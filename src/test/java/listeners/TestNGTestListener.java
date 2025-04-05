package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.codec.binary.Base64;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ExcelReader;
import utilities.ExtentReportHelper;
import utilities.LoggerUtils;
import utilities.ScreenshotUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestNGTestListener implements ITestListener {

    private ExcelReader excel;
    private final String sheetName = "TestResults";
    private int testCounter = 1;
    private int executionNumber = 1;
    private String excelPath;

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> testLog = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        try {
            // Initialize ExtentReports
            extent = ExtentReportHelper.ExtentDemo("AutomationReport");

            // Excel file setup
            String reportFolderPath = System.getProperty("user.dir") + "/report/";
            File reportDir = new File(reportFolderPath);
            if (!reportDir.exists()) {
                reportDir.mkdirs();
            }

            excelPath = reportFolderPath + "testResult.xlsx";
            File excelFile = new File(excelPath);

            if (!excelFile.exists()) {
                XSSFWorkbook workbook = new XSSFWorkbook();
                FileOutputStream fileOut = new FileOutputStream(excelFile);
                workbook.write(fileOut);
                fileOut.close();
                workbook.close();
                System.out.println("Created new Excel file: " + excelPath);
            }

            excel = new ExcelReader(excelPath);

            if (!excel.isSheetExist(sheetName)) {
                excel.addSheet(sheetName);
            }

            excel.addColumn(sheetName, "Execution No.");
            excel.addColumn(sheetName, "TestName");
            excel.addColumn(sheetName, "Status");
            excel.addColumn(sheetName, "Date");
            excel.addColumn(sheetName, "Time");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        testLog.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        testLog.get().log(Status.PASS, "Test Passed");
        writeTestResult(result, "PASS");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            String methodName = result.getName();
            String screenshotPath = ScreenshotUtil.captureScreenshot(methodName);
            File imageFile = new File(screenshotPath);
            String base64String = encodeFileToBase64Binary(imageFile);
            String base64Image = "data:image/png;base64," + base64String;

            // Log failure with exception and screenshot
            testLog.get().log(Status.FAIL, "Test Failed: " + result.getThrowable());
            testLog.get().addScreenCaptureFromBase64String(base64Image, methodName + " Screenshot");

            writeTestResult(result, "FAIL");

        } catch (Exception e) {
            LoggerUtils.info("Exception during failure reporting: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        testLog.get().log(Status.SKIP, "Test Skipped: " + result.getThrowable());
        writeTestResult(result, "SKIPPED");
    }

    @Override
    public void onFinish(ITestContext context) {
        if (excel != null) {
            excel.closeWorkbook();
        }

        if (extent != null) {
            extent.flush();
        }
    }

    private void writeTestResult(ITestResult result, String status) {
        try {
            String testName = result.getMethod().getMethodName();
            String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String time = new SimpleDateFormat("HH:mm:ss").format(new Date());

            int rowNum = testCounter + 1;

            excel.setCellData(sheetName, "Execution No.", rowNum, String.valueOf(executionNumber));
            excel.setCellData(sheetName, "TestName", rowNum, testName);
            excel.setCellData(sheetName, "Status", rowNum, status);
            excel.setCellData(sheetName, "Date", rowNum, date);
            excel.setCellData(sheetName, "Time", rowNum, time);

            testCounter++;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String encodeFileToBase64Binary(File file) {
        String encodedFile = null;
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] bytes = new byte[(int) file.length()];
            fis.read(bytes);
            encodedFile = new String(Base64.encodeBase64(bytes), "UTF-8");
        } catch (Exception e) {
            LoggerUtils.info("Base64 encoding failed: " + e.getMessage());
            e.printStackTrace();
        }
        return encodedFile;
    }
}
