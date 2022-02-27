package com.framework.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.framework.initialization.DriverInitalization;

public class BasicActions extends DriverInitalization {

	WaitUtils wait = new WaitUtils();

	/**
	 * Method to click on web element
	 * 
	 * @param ele - provide Element to click
	 */
	public void clickElement(WebElement ele) {

		wait.waitForVisibility(ele);
		ele.click();
	}

	
	/**
	 * Method to click on web element
	 * 
	 * @param ele - provide Element to click
	 */
	public boolean waitForElementDisapear(WebElement ele) {

		return ele.isDisplayed();
	}
	
	/**
	 * Method to click on web element
	 * 
	 * @param ele - provide Element to click
	 */
	public void clickElementJavaScript(WebElement ele) {

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
		
	}

	public void scrollTo(WebElement ele) {

		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
	}
	/**
	 * This method is used to check if element is available or not
	 * 
	 * @param ele - Web Element to fetch status
	 * @return - return true if found else false
	 */
	public boolean isElementAvailable(WebElement ele) {

		boolean flag = false;
		try {
			wait.waitForVisibility(ele);
			flag = ele.isDisplayed();
		} catch (Exception e) {
			return flag;
		}

		return flag;
	}

	/**
	 * Method to enter text
	 * 
	 * @param ele - provide Element to enter text
	 */
	public void enterText(WebElement ele, String input) {

		ele.sendKeys(input);
	}

	/**
	 * Method to enter text
	 * 
	 * @param ele - provide Element to enter text
	 */
	public void clearText(WebElement ele) {

		ele.clear();
	}

	/**
	 * Method to click on web element
	 * 
	 * @param ele - provide Element to click
	 */
	public String getText(WebElement ele) {

		wait.waitForVisibility(ele);
		return ele.getText();
	}
}
