package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import base.TestBase;
import helper.CommanHelper;
import utilities.LoggerUtils;
import utilities.PathManager;
import utilities.ScreenshotUtil;

public class HostAndAdventurePageDetails extends TestBase {

	private WebDriver driver;
	private By title = By.xpath(OR.getProperty("title"));
	private By Summary = By.xpath(OR.getProperty("Summary"));
	private By Included = By.xpath(OR.getProperty("Included"));
	private By NotIncluded = By.xpath(OR.getProperty("NotIncluded"));
	private By SaveFirst = By.xpath(OR.getProperty("SaveFirst"));
	private By SaveSecond = By.xpath(OR.getProperty("SaveSecond"));
	private By SaveThird = By.xpath(OR.getProperty("SaveThird"));
	private By Duration = By.xpath(OR.getProperty("Duration"));	
	private By DaysAndTime = By.xpath(OR.getProperty("DaysAndTime"));
	private By Price = By.xpath(OR.getProperty("Price"));
	private By CurrencyType = By.xpath(OR.getProperty("CurrencyType"));
	private By GroupSecond = By.xpath(OR.getProperty("GroupSecond"));
	
	private By Availability = By.xpath(OR.getProperty("Availability"));
	private By WhatQualifies = By.xpath(OR.getProperty("WhatQualifies"));
	private By AdditionalInfo = By.xpath(OR.getProperty("AdditionalInfo"));
	private By Cancellation = By.xpath(OR.getProperty("Cancellation"));
	private By Itinerary = By.xpath(OR.getProperty("Itinerary"));
	
	private By SaveFour = By.xpath(OR.getProperty("SaveFour"));
	private By SaveFive = By.xpath(OR.getProperty("SaveFive"));
	private By ViewTour = By.xpath(OR.getProperty("ViewTour"));
	private By SaveToWishlist = By.xpath(OR.getProperty("SaveToWishlist"));
	
	public HostAndAdventurePageDetails(WebDriver driver) {
		this.driver = driver;
	}

	public void fillAdventureDetails() throws InterruptedException {
		Thread.sleep(3000);
		String TitleValue= excel.getCellData("Overview", "Title", 2);	
		WebElement titleElement = driver.findElement(title);
		titleElement.sendKeys(TitleValue);
		LoggerUtils.info("Title is entered");
		//test.createTest("Title is entered");
		
		String CategoryValue= excel.getCellData("Overview", "Category", 2);
		CommanHelper.selectDropdownOptionByText("Category", CategoryValue);
		LoggerUtils.info("Difficulty is selected");
		//test.createTest("Difficulty is selected");	
		
		String SummaryValue= excel.getCellData("Overview", "Summary", 2);
		WebElement SummaryElement = driver.findElement(Summary);
		SummaryElement.sendKeys(SummaryValue);
		LoggerUtils.info("Summary is entered");
		
		String IncludedyValue= excel.getCellData("Overview", "Included", 2);
		WebElement IncludedElement = driver.findElement(Included);
		IncludedElement.sendKeys(IncludedyValue);
		LoggerUtils.info("Included is entered");
		//test.createTest("Included is entered");
		
		String NotincludedValue= excel.getCellData("Overview", "Not included", 2);
		WebElement NotIncludedElement = driver.findElement(NotIncluded);
		NotIncludedElement.sendKeys(NotincludedValue);
		LoggerUtils.info("Not included is entered");
		//test.createTest("Not included is entered");
		
		WebElement SaveFirstElement = driver.findElement(SaveFirst);
		SaveFirstElement.click();
		LoggerUtils.info("Clicking on Save button");
		//test.createTest("Clicking on Save button");
	
		Thread.sleep(3000);
		String City2Value= excel.getCellData("Location", "City", 2);
		CommanHelper.selectAutoDropdownOptionByText("City", City2Value);
		LoggerUtils.info("City is selected");
		//test.createTest("City is selected");
			
		WebElement SaveSecondElement = driver.findElement(SaveSecond);
		SaveSecondElement.click();
		LoggerUtils.info("Clicking on Save button");
		//test.createTest("Clicking on Save button");
		String image = PathManager.getResourcePath("\\src\\main\\resources\\photos\\sample.jpg");
		ScreenshotUtil.uploadPhoto(image);
		
		WebElement SaveThirdElement = driver.findElement(SaveThird);
		SaveThirdElement.click();
		LoggerUtils.info("Clicking on Save button");
		//test.createTest("Clicking on Save button");
		
		Thread.sleep(3000);
		String DurationValue= excel.getCellData("Details", "Duration", 2);
		WebElement DurationElement = driver.findElement(Duration);
		DurationElement.sendKeys(DurationValue);
		LoggerUtils.info("Duration is entered");
		//test.createTest("Duration is entered");
		
		String DaysAndTimeValue= excel.getCellData("Details", "DaysAndTime", 2);
		WebElement DaysAndTimeElement = driver.findElement(DaysAndTime);
		CommanHelper.selectDropdownOptionByText2(DaysAndTimeElement, DaysAndTimeValue);
		LoggerUtils.info("Days and Time is selected");
		//test.createTest("Days and Time is selected");
		
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
		//test.createTest("Price is entered");
		
		String CurrencytypeValue= excel.getCellData("Details", "Currency  type", 2);
		WebElement CurrencyTypeElement = driver.findElement(CurrencyType);
		CommanHelper.selectDropdownOptionByText2(CurrencyTypeElement, CurrencytypeValue);
		LoggerUtils.info("City is selected");
		//test.createTest("City is selected");
	    
		String Group2Value= excel.getCellData("Details", "Group", 2);
		WebElement Group2 = driver.findElement(GroupSecond);
		CommanHelper.selectDropdownOptionByText2(Group2, Group2Value);
		LoggerUtils.info("Group is selected");
		//test.createTest("Group is selected");
		
		String Availability2Value= excel.getCellData("Details", "Availability", 2);
		WebElement AvailabilityElement = driver.findElement(Availability);
		AvailabilityElement.sendKeys(Availability2Value);
		LoggerUtils.info("Availability is entered");
		//test.createTest("Availability is entered");
		
		String WhatqualifiesValue= excel.getCellData("Details", "What qualifies you to give this tour?", 2);
		WebElement WhatQualifiesElement = driver.findElement(WhatQualifies);
		WhatQualifiesElement.sendKeys(WhatqualifiesValue);
		LoggerUtils.info("What qualifies you to give this tour? is entered");
		//test.createTest("What qualifies you to give this tour? is entered");
		
		String AdditionalinfoValue= excel.getCellData("Details", "Additional info", 2);
		WebElement AdditionalInfoElement = driver.findElement(AdditionalInfo);
		AdditionalInfoElement.sendKeys(AdditionalinfoValue);
		LoggerUtils.info("Additional info is entered");
		//test.createTest("Additional info is entered");
		
		String CancellationValue= excel.getCellData("Details", "Cancellation", 2);
		WebElement CancellationElement = driver.findElement(Cancellation);
		CancellationElement.sendKeys(CancellationValue);
		LoggerUtils.info("Cancellation is entered");
		//test.createTest("Cancellation is entered");
		
		WebElement SaveFourElement = driver.findElement(SaveFour);
		SaveFourElement.click();
		LoggerUtils.info("Clicking on Save button");
		//test.createTest("Clicking on Save button");
		Thread.sleep(2000);
		
		String MeetupLocationValue= excel.getCellData("Itinerary", "Meetup Location", 2);		
		CommanHelper.selectAutoDropdownOptionByText("Meetup Location", MeetupLocationValue);
		LoggerUtils.info("Meetup Location is selected");
		//test.createTest("Meetup Location is selected");
		
		String ItineraryValue= excel.getCellData("Itinerary", "Itinerary", 2);
		WebElement ItineraryElement = driver.findElement(Itinerary);
		ItineraryElement.sendKeys(ItineraryValue);
		LoggerUtils.info("Itinerary is entered");
		//test.createTest("Itinerary is entered");
		
		WebElement SaveFiveElement = driver.findElement(SaveFive);
		SaveFiveElement.click();
		LoggerUtils.info("Clicking on Save button");
		//test.createTest("Clicking on Save button");
		
		CommanHelper.verifyToastMessage("Tour updated successfully");
		Thread.sleep(3000);
		WebElement ViewTourElement = driver.findElement(ViewTour);
		ViewTourElement.click();
		LoggerUtils.info("Clicking on View Tour button");
		//test.createTest("Clicking on View Tour button");
		
		Thread.sleep(3000);
		LoggerUtils.info("Waiting for new window to open");
		//test.createTest("Waiting for new window to open");
		CommanHelper.switchToWindowByIndex(1);
		LoggerUtils.info("Switching to new window");
		//test.createTest("Switching to new window");
		
		WebElement SaveToWishlistElement = driver.findElement(SaveToWishlist);		
		SaveToWishlistElement.click();
		LoggerUtils.info("Clicking on Save to Wishlist button");
		//test.createTest("Clicking on Save to Wishlist button");
		
		driver.close();
		LoggerUtils.info("Closing the new Opened window");
		//test.createTest("Closing the new Opened window");
		
		CommanHelper.switchToWindowByIndex(0);
		LoggerUtils.info("Switching back to the original window");
		//test.createTest("Switching back to the original window");
		
	}

}
