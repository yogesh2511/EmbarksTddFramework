package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.TestBase;
import helper.CommanHelper;
import utilities.ExcelReader;
import utilities.LoggerUtils;
import utilities.PathManager;
import utilities.ScreenshotUtil;

public class HostAndAdventurePageDetails extends TestBase {

	private WebDriver driver;
	private By title = By.xpath("//input[@placeholder='Enter the name of your tour']");
	private By Summary = By.xpath("//textarea[@placeholder='Brief summary of the tour and other helpful details']");
	private By Included = By.xpath("//textarea[@placeholder='List of things that are included in the tour. Enter each item on a new line to display as a bulleted list.']");
	private By NotIncluded = By.xpath("//textarea[@placeholder='List of things that are NOT included in the tour. What should guests bring themselves? Enter each item on a new line to display as a bulled list']");
	private By SaveFirst = By.xpath("//button[normalize-space()='Save']");
	private By SaveSecond = By.xpath("//button[normalize-space()='Save']");
	private By SaveThird = By.xpath("//button[normalize-space()='Save']");
	private By Duration = By.xpath("//input[@type='number']");	
	private By DaysAndTime = By.xpath("(//label[text()='Duration']/following-sibling::div//div)[2]");
	private By Price = By.xpath("//input[@placeholder='Price']");
	private By CurrencyType = By.xpath("(//label[text()='Price']/following-sibling::div/div/div)[1]/div");
	private By GroupSecond = By.xpath("(//label[text()='Price']/following-sibling::div/div/div)[2]");
	
	private By Availability = By.xpath("(//label[normalize-space(text())='Availability']/following::textarea)[1]");
	private By WhatQualifies = By.xpath("(//label[normalize-space(text())='What qualifies you to give this tour?']/following::textarea)[1]");
	private By AdditionalInfo = By.xpath("(//label[normalize-space(text())='Additional info']/following::textarea)[1]");
	private By Cancellation = By.xpath("//label[normalize-space(text())='Cancellation']/following::textarea");
	private By Itinerary = By.xpath("//div[@class='itinerary-day']//textarea");
	
	private By SaveFour = By.xpath("//button[normalize-space()='Save']");
	private By SaveFive = By.xpath("//button[normalize-space()='Save']");
	private By ViewTour = By.xpath("//a[normalize-space()='View Tour']");
	private By SaveToWishlist = By.xpath("//div[@class='wishlist-btnwrapper']//div[@title='Save to Wish List']");
	
	public HostAndAdventurePageDetails(WebDriver driver) {
		this.driver = driver;
	}

	public void fillAdventureDetails() throws InterruptedException {
		Thread.sleep(3000);
		String TitleValue= excel.getCellData("Overview", "Title", 2);
		
		WebElement titleElement = driver.findElement(title);
		titleElement.sendKeys(TitleValue);
		
		String CategoryValue= excel.getCellData("Overview", "Category", 2);
		CommanHelper.selectDropdownOptionByText("Category", CategoryValue);
		LoggerUtils.info("Difficulty is selected");
		
		String SummaryValue= excel.getCellData("Overview", "Summary", 2);
		WebElement SummaryElement = driver.findElement(Summary);
		SummaryElement.sendKeys(SummaryValue);
		LoggerUtils.info("Summary is entered");
		
		String IncludedyValue= excel.getCellData("Overview", "Included", 2);
		WebElement IncludedElement = driver.findElement(Included);
		IncludedElement.sendKeys(IncludedyValue);
		LoggerUtils.info("Included is entered");
		
		String NotincludedValue= excel.getCellData("Overview", "Not included", 2);
		WebElement NotIncludedElement = driver.findElement(NotIncluded);
		NotIncludedElement.sendKeys(NotincludedValue);
		LoggerUtils.info("Not included is entered");
		
		WebElement SaveFirstElement = driver.findElement(SaveFirst);
		SaveFirstElement.click();
		LoggerUtils.info("Clicking on Save button");
	
		Thread.sleep(3000);
		String City2Value= excel.getCellData("Location", "City", 2);
		CommanHelper.selectAutoDropdownOptionByText("City", City2Value);
		LoggerUtils.info("City is selected");
			
		WebElement SaveSecondElement = driver.findElement(SaveSecond);
		SaveSecondElement.click();
		LoggerUtils.info("Clicking on Save button");
		String image = PathManager.getResourcePath("\\src\\main\\resources\\photos\\sample.jpg");
		ScreenshotUtil.uploadPhoto(image);
		
		WebElement SaveThirdElement = driver.findElement(SaveThird);
		SaveThirdElement.click();
		LoggerUtils.info("Clicking on Save button");
		
		Thread.sleep(3000);
		String DurationValue= excel.getCellData("Details", "Duration", 2);
		WebElement DurationElement = driver.findElement(Duration);
		DurationElement.sendKeys(DurationValue);
		LoggerUtils.info("Duration is entered");
		
		String DaysAndTimeValue= excel.getCellData("Details", "DaysAndTime", 2);
		WebElement DaysAndTimeElement = driver.findElement(DaysAndTime);
		CommanHelper.selectDropdownOptionByText2(DaysAndTimeElement, DaysAndTimeValue);
		LoggerUtils.info("Days and Time is selected");

//		String Difficulty2Value= excel.getCellData("Details", "Difficulty", 2);
//		WebElement Difficulty2Value2 = driver.findElement(By.xpath("//label[text()='Difficulty']/following-sibling::div/div"));
//		CommanHelper.selectDropdownOptionByText2(Difficulty2Value2, Difficulty2Value);
//		LoggerUtils.info("Difficulty is selected");
//
//		String GroupSizeminValue= excel.getCellData("Details", "Group Size min", 2);
//		WebElement GroupSizemin = driver.findElement(By.xpath("//input[@placeholder='Min']"));
//		GroupSizemin.sendKeys(GroupSizeminValue);
//		LoggerUtils.info("Minimum group size is entered");
//		
//		String GroupSizemaxValue= excel.getCellData("Details", "Group Size max", 2);
//		WebElement GroupSizemax = driver.findElement(By.xpath("//input[@placeholder='Max']"));
//		GroupSizemax.sendKeys(GroupSizemaxValue);
//		LoggerUtils.info("Maximum group size is entered");

		String PriceValue= excel.getCellData("Details", "Price", 2);
		WebElement PriceElement = driver.findElement(Price);
		PriceElement.sendKeys(PriceValue);
		LoggerUtils.info("Price is entered");
	
		String CurrencytypeValue= excel.getCellData("Details", "Currency  type", 2);
		WebElement CurrencyTypeElement = driver.findElement(CurrencyType);
		CommanHelper.selectDropdownOptionByText2(CurrencyTypeElement, CurrencytypeValue);
		LoggerUtils.info("City is selected");
		
		String Group2Value= excel.getCellData("Details", "Group", 2);
		WebElement Group2 = driver.findElement(GroupSecond);
		CommanHelper.selectDropdownOptionByText2(Group2, Group2Value);
		LoggerUtils.info("Group is selected");
		
		String Availability2Value= excel.getCellData("Details", "Availability", 2);
		WebElement AvailabilityElement = driver.findElement(Availability);
		AvailabilityElement.sendKeys(Availability2Value);
		
		String WhatqualifiesValue= excel.getCellData("Details", "What qualifies you to give this tour?", 2);
		WebElement WhatQualifiesElement = driver.findElement(WhatQualifies);
		WhatQualifiesElement.sendKeys(WhatqualifiesValue);
		
		String AdditionalinfoValue= excel.getCellData("Details", "Additional info", 2);
		WebElement AdditionalInfoElement = driver.findElement(AdditionalInfo);
		AdditionalInfoElement.sendKeys(AdditionalinfoValue);
		
		String CancellationValue= excel.getCellData("Details", "Cancellation", 2);
		WebElement CancellationElement = driver.findElement(Cancellation);
		CancellationElement.sendKeys(CancellationValue);
		
		
		WebElement SaveFourElement = driver.findElement(SaveFour);
		SaveFourElement.click();
		LoggerUtils.info("Clicking on Save button");
		
		Thread.sleep(2000);
		String MeetupLocationValue= excel.getCellData("Itinerary", "Meetup Location", 2);
		
		CommanHelper.selectAutoDropdownOptionByText("Meetup Location", MeetupLocationValue);
		LoggerUtils.info("City is selected");
		
		String ItineraryValue= excel.getCellData("Itinerary", "Itinerary", 2);
		WebElement ItineraryElement = driver.findElement(Itinerary);
		ItineraryElement.sendKeys(ItineraryValue);
		LoggerUtils.info("Itinerary is entered");
		
		WebElement SaveFiveElement = driver.findElement(SaveFive);
		SaveFiveElement.click();
		LoggerUtils.info("Clicking on Save button");	
		
		CommanHelper.verifyToastMessage("Tour updated successfully");
		Thread.sleep(3000);
		WebElement ViewTourElement = driver.findElement(ViewTour);
		ViewTourElement.click();
		LoggerUtils.info("Clicking on View Tour button");
		Thread.sleep(3000);
		
		CommanHelper.switchToWindowByIndex(1);
		LoggerUtils.info("Switching to new window");
		WebElement SaveToWishlistElement = driver.findElement(SaveToWishlist);
		
		SaveToWishlistElement.click();
		driver.close();
		CommanHelper.switchToWindowByIndex(0);
	
		
		
	}

}
