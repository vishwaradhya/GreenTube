package com.framework.actions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils extends BaseAbstract {


	public void waitForVisibility(WebElement element) {
		new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElementClickable(WebElement element) {
		new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	

}
