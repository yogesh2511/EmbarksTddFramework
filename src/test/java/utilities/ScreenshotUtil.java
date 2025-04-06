package utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.TestBase;

public class ScreenshotUtil extends TestBase {

    public static String captureScreenshot(String testName) {
        try {
             File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotPath = System.getProperty("user.dir") + "/report/screenshots/" + testName + "_" + timestamp + ".png";

            File destFile = new File(screenshotPath);
            FileUtils.copyFile(srcFile, destFile);

            return screenshotPath;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static void uploadPhoto(String filePath) {
        // Locate the hidden file input using its ID
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));

        // Use JavaScript to make it visible (optional in some cases)
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", fileInput);

        // Upload file using sendKeys
        fileInput.sendKeys(filePath);
    }

}

