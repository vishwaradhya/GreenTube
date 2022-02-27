package com.framework.actions;

public class NavigateAction extends BaseAbstract {

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
