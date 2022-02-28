package com.framework.actions;

import com.framework.initialization.DriverInitalization;

public class NavigateAction extends DriverInitalization {

	/**
	 * Method to launch url
	 * 
	 * @param url
	 */
	public void launchUrl(String url) {

		driver.get(url);

	}
	/**
	 * Method to launch url
	 * 
	 * @param url
	 */
	public void refreshPage() {

		driver.navigate().refresh();

	}
	

}
