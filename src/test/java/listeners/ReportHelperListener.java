package listeners;

import org.apache.commons.codec.binary.Base64;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import base.TestBase;
import utilities.ExcelReader;
import utilities.ExtentManager;
import utilities.LoggerUtils;
import utilities.PathManager;
import utilities.ScreenshotUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ReportHelperListener extends TestBase implements ITestListener {

	private ExcelReader excel;
	private final String sheetName = "TestResults";
	private int testCounter = 1;
	private int executionNumber = 1;
	private String excelPath;
	
	@Override
	public void onStart(ITestContext context) {
		try {
			// Excel file setup
			String reportFolderPath = PathManager.getResourcePath("/report/");
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
				LoggerUtils.info("Excel file created: " + excelPath);
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
			LoggerUtils.info("Error setting up Excel file: " + e.getMessage());
				}
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = extent
				.createTest(result.getTestClass().getName() + "     @TestCase : " + result.getMethod().getMethodName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		writeTestResult(result, "PASS");
		String methodName = result.getMethod().getMethodName();
		String screenshotPath = ScreenshotUtil.captureScreenshot(methodName);
		String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + " PASSED" + "</b>";
		try {

			test.pass("<b><font color=green>" + "Screenshot of PASSED" + "</font></b><br>",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtils.info("Exception during success reporting: " + e.getMessage());
		}

		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		test.pass(m);

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String screenshotPath = ScreenshotUtil.captureScreenshot(methodName);
		File imageFile = new File(screenshotPath);
		String base64String = encodeFileToBase64Binary(imageFile);
		String base64Image = "data:image/png;base64," + base64String;

		String excepionMessage = Arrays.toString(result.getThrowable().getStackTrace());
		test.fail(excepionMessage);
		String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + " FAILED" + "</b>";
		try {
			writeTestResult(result, "FAIL");
			test.fail("<b><font color=red>" + "Screenshot of failure" + "</font></b><br>",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			test.addScreenCaptureFromBase64String(base64Image, methodName + " Screenshot");

		} catch (Exception e) {
			LoggerUtils.info("Exception during failure reporting: " + e.getMessage());
			test.fail("Exception during failure reporting: " + e.getMessage());
		}
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		test.log(Status.FAIL, m);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		writeTestResult(result, "SKIPPED");
		String methodName = result.getMethod().getMethodName();
		String screenshotPath = ScreenshotUtil.captureScreenshot(methodName);
		String logText = "<b>" + "Test Case:- " + methodName + " Skipped" + "</b>";
		try {

			test.skip("<b><font color=grey>" + "Screenshot of Skipped" + "</font></b><br>",
					MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			LoggerUtils.info("Exception during skipping reporting: " + e.getMessage());
			test.skip("Exception during skipping reporting: " + e.getMessage());
		}
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		test.skip(m);
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
			LoggerUtils.info("Error writing test result to Excel: " + e.getMessage());
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
					}
		return encodedFile;
	}
}
