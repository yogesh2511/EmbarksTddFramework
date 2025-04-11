package listeners;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import utilities.LoggerUtils;

public class EventCapture implements WebDriverListener {
    @Override
	public void beforeClick(WebElement element) {
		System.out.println("Before clicking on: " + element);
	}

	@Override
	public void afterClick(WebElement element) {
		LoggerUtils.info("After clicking on: " + element);
		System.out.println("After clicking on: " + element);
	}

	public void beforeNavigateTo(String url) {
		System.out.println("Navigating to: " + url);
	}

	public void afterNavigateTo(String url) {
		System.out.println("Navigated to: " + url);
	}

	public void beforeGetText(WebElement element) {
		System.out.println("Getting text from: " + element);
	}

	public void afterGetText(WebElement element, String text) {
		System.out.println("Got text: " + text + " from: " + element);
	}

	public void beforeFindElement(WebElement element) {
		System.out.println("Finding element: " + element);
	}

	public void afterFindElement(WebElement element, WebElement foundElement) {
		System.out.println("Found element: " + foundElement + " from: " + element);
	}

	public void beforeGetTitle() {
		System.out.println("Getting page title");
		LoggerUtils.info("Getting page title");
	}	
	// Add more overridden methods as needed for your specific requirements

}
