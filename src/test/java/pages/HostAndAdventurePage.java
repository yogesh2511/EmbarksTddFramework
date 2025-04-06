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
    By HostAndAdventureHeader = By.xpath("//h1[normalize-space(text())='Host an adventure']");
    By Next = By.xpath("//button[normalize-space(text())='Next']");
    By MinimumGroupSize = By.xpath("//input[@placeholder='Min']");
    By MaximumGroupSize = By.xpath("//input[@placeholder='Max']");
     
    
	public HostAndAdventurePage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterDetailsFromExcel() throws InterruptedException {
		WebElement HostAndAdventureHeaderElement = driver.findElement(By.xpath("//h1[normalize-space(text())='Host an adventure']"));
		Assert.assertTrue(HostAndAdventureHeaderElement.isDisplayed());
		LoggerUtils.info("Host an Adventure header is displayed");
		
		
		
		String categryvalue= excel.getCellData("HostAndAdventure", "Category", 2);
		
		CommanHelper.selectDropdownOptionByText("Category", categryvalue);
		LoggerUtils.info("Category is selected");
		String DifficultyValue= excel.getCellData("HostAndAdventure", "Difficulty", 2);
		
		CommanHelper.selectDropdownOptionByText("Difficulty", DifficultyValue);
		LoggerUtils.info("Difficulty is selected");
		String CityValue= excel.getCellData("HostAndAdventure", "City", 2);
		Thread.sleep(3000);
		CommanHelper.selectAutoDropdownOptionByText("City", CityValue);
		LoggerUtils.info("City is selected");
		Thread.sleep(3000);
		WebElement NextButton = driver.findElement(By.xpath("//button[normalize-space(text())='Next']"));
		NextButton.click();
		LoggerUtils.info("Clicking on Next button");
		WebElement MinimumGroupError = driver
				.findElement(By.xpath("//span[normalize-space(text())='The group size min field is required.']"));
		WebElement MinimumGroupSizeError = driver
				.findElement(By.xpath("//span[normalize-space(text())='The group size max field is required.']"));

		Assert.assertTrue(MinimumGroupError.isDisplayed());
		LoggerUtils.info("Minimum group size error is displayed");
		Assert.assertTrue(MinimumGroupSizeError.isDisplayed());
		LoggerUtils.info("Minimum group size error is displayed");

		WebElement MinimumGroupSize = driver.findElement(By.xpath("//input[@placeholder='Min']"));
		String MinimumGroupSizeValue= excel.getCellData("HostAndAdventure", "MinimumGroupSize", 2);
		
		MinimumGroupSize.sendKeys(MinimumGroupSizeValue);
		LoggerUtils.info("Minimum group size is entered");
		WebElement MaximumGroupSize = driver.findElement(By.xpath("//input[@placeholder='Max']"));
		String MaximumGroupSizeValue= excel.getCellData("HostAndAdventure", "MaximumGroupSize", 2);
		
		MaximumGroupSize.sendKeys(MaximumGroupSizeValue);
		LoggerUtils.info("Maximum group size is entered");
		NextButton.click();	
		LoggerUtils.info("Clicking on Next button");		
		
		
		
	}
//	public void saveAdventure() {
//		// TODO Auto-generated method stub
//		
//	}
//	public boolean isValidationMessageDisplayed(String string) {
//		// TODO Auto-generated method stub
//		return false;
//	}
//	public void enterGroupSize() {
//		// TODO Auto-generated method stub
//		
//	}
//	public boolean isSuccessMessageDisplayed(String string) {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
