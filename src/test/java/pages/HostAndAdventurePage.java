package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import base.TestBase;
import helper.CommanHelper;
import utilities.ExcelReader;
import utilities.LoggerUtils;
import utilities.ScreenshotUtil;

public class HostAndAdventurePage extends TestBase{
    private WebDriver driver;
    
    //Locators
    By HostAndAdventureHeader = By.xpath(OR.getProperty("HostAndAdventureHeader"));
    By Next = By.xpath(OR.getProperty("Next"));
    By MinimumGroupError = By.xpath(OR.getProperty("MinimumGroupError"));
    By MaximumGroupError = By.xpath(OR.getProperty("MaximumGroupError"));
    By MinimumGroupSize = By.xpath(OR.getProperty("MinimumGroupSize"));
    By MaximumGroupSize = By.xpath(OR.getProperty("MaximumGroupSize"));
     
    
	public HostAndAdventurePage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterDetailsFromExcel() throws InterruptedException {
		WebElement HostAndAdventureHeaderElement = driver.findElement(HostAndAdventureHeader);
		Assert.assertTrue(HostAndAdventureHeaderElement.isDisplayed());
		LoggerUtils.info("Host an Adventure header is displayed");
		//test.createTest("Host an Adventure header is displayed");
			
		String categryvalue= excel.getCellData("HostAndAdventure", "Category", 2);	
		CommanHelper.selectDropdownOptionByText("Category", categryvalue);
		LoggerUtils.info("Category is selected");
		//test.createTest("Category is selected");
		
		String DifficultyValue= excel.getCellData("HostAndAdventure", "Difficulty", 2);		
		CommanHelper.selectDropdownOptionByText("Difficulty", DifficultyValue);
		LoggerUtils.info("Difficulty is selected");
		//test.createTest("Difficulty is selected");
		
		String CityValue= excel.getCellData("HostAndAdventure", "City", 2);
		Thread.sleep(3000);
		CommanHelper.selectAutoDropdownOptionByText("City", CityValue);
		LoggerUtils.info("City is selected");
		//test.createTest("City is selected");
		Thread.sleep(3000);
		
		
		WebElement NextButton = driver.findElement(Next);
		NextButton.click();
		LoggerUtils.info("Clicking on Next button");
		//test.createTest("Clicking on Next button");
		WebElement MinimumGroupErrorElement = driver.findElement(MinimumGroupError);
		WebElement MaximumGroupErrorElement = driver.findElement(MaximumGroupError);
		
		Assert.assertTrue(MinimumGroupErrorElement.isDisplayed());
		LoggerUtils.info("Minimum group size error is displayed");
		//test.createTest("Minimum group size error is displayed");
		
		Assert.assertTrue(MaximumGroupErrorElement.isDisplayed());
		LoggerUtils.info("Minimum group size error is displayed");
		//test.createTest("Maximum group size error is displayed");
		
		WebElement MinimumGroupSizeElement = driver.findElement(MinimumGroupSize);
		String MinimumGroupSizeValue= excel.getCellData("HostAndAdventure", "MinimumGroupSize", 2);
		MinimumGroupSizeElement.sendKeys(MinimumGroupSizeValue);
		LoggerUtils.info("Minimum group size is entered");
		//test.createTest("Minimum group size is entered");
		
		WebElement MaximumGroupSizeElement = driver.findElement(MaximumGroupSize);
		String MaximumGroupSizeValue= excel.getCellData("HostAndAdventure", "MaximumGroupSize", 2);	
		MaximumGroupSizeElement.sendKeys(MaximumGroupSizeValue);
		LoggerUtils.info("Maximum group size is entered");
		//test.createTest("Maximum group size is entered");
		
		NextButton.click();	
		LoggerUtils.info("Clicking on Next button");	
		//test.createTest("Clicking on Next button");
		Thread.sleep(2000);
		LoggerUtils.info("Waiting for new tab to load....");
		//test.createTest("Waiting for new tab to load....");
		
	}


}
