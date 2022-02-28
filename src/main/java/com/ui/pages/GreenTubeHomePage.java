package com.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.framework.actions.BasicActions;
import com.framework.actions.WaitUtils;
import com.framework.commonutils.PropertiesFile;
import com.framework.commonutils.UserDataPath;
import com.framework.initialization.ConfigurationPath;
import com.framework.initialization.DriverInitalization;

import org.apache.log4j.Logger;

public class GreenTubeHomePage extends DriverInitalization {

	BasicActions commonActions = new BasicActions();
	WaitUtils wait = new WaitUtils();

	static Logger log = Logger.getLogger(GreenTubeHomePage.class.getName());

	public GreenTubeHomePage() {

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}

	@FindBy(className = "login")
	WebElement signIn;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "passwd")
	WebElement passwd;

	@FindBy(id = "SubmitLogin")
	WebElement submitLogin;

	@FindBy(className = "logout")
	WebElement logout;

	@FindBy(id = "search_query_top")
	WebElement searchIcon;

	@FindBy(name = "submit_search")
	WebElement submitSearch;

	@FindBy(className = "product_img_link")
	WebElement prodcutImageLink;

	@FindBy(id = "add_to_cart")
	WebElement addTocart;

	@FindBy(className = "cross")
	WebElement closePopUp;

	@FindBy(className = "shopping_cart")
	WebElement shoppingCart;

	@FindBy(className = "cart_quantity_delete")
	WebElement cartQuantityDelete;

	
	@FindBy(id = "cart_title")
	WebElement cartTitle;
	
	@FindBy(className = "account")
	WebElement accountName;
	
	@FindBy(className = "standard-checkout")
	WebElement standardCheckout;
	
	@FindBy(id = "cgv")
	WebElement agreeCheckBox;
	
	@FindBy(xpath = "//*[contains(text(),'Proceed to checkout')]")
	WebElement proccedToCheckout;
	

	@FindBy(id = "layer_cart")
	WebElement layerCart;
	

	WaitUtils waitTime = new WaitUtils();

	public void navigateToSingIn() {
		waitTime.waitForVisibility(signIn);
		commonActions.clickElement(signIn);
	}

	public void login(){

		commonActions.isElementAvailable(email);
		commonActions.enterText(email, PropertiesFile.getPropertyValue(UserDataPath.USER_DATA_PATH, "Email"));
		commonActions.enterText(passwd, PropertiesFile.getPropertyValue(UserDataPath.USER_DATA_PATH, "password"));
		commonActions.clickElement(submitLogin);
		commonActions.isElementAvailable(logout);

	}

	public void logout() {

		commonActions.isElementAvailable(logout);

		commonActions.clickElement(logout);
	}

	public void searchCriteria(String criteria) {

		commonActions.clearText(searchIcon);
		commonActions.enterText(searchIcon, criteria);
		commonActions.clickElement(submitSearch);

	}

	public void addItemToCart() throws InterruptedException {

		commonActions.isElementAvailable(prodcutImageLink);
		commonActions.clickElementJavaScript(prodcutImageLink);

		Thread.sleep(5000);
		commonActions.scrollTo(addTocart);
		commonActions.clickElement(addTocart);

		commonActions.isElementAvailable(closePopUp);
		commonActions.clickElement(closePopUp);

	}

	public void removeItemFromCart() {
		commonActions.clickElement(shoppingCart);
		commonActions.clickElement(cartQuantityDelete);

	}

	public String verifyCartItems() {

		commonActions.clickElement(shoppingCart);
				return commonActions.getText(cartTitle);
	}

	public String verifyLoginPage() {
		
		return commonActions.getText(accountName);
	}

	public void checkout() throws InterruptedException {
		Thread.sleep(5000);
		commonActions.clickElementJavaScript(shoppingCart);
		Thread.sleep(5000);
//		commonActions.clickElement(standardCheckout);
//		commonActions.isElementAvailable(standardCheckout);
//		commonActions.clickElement(standardCheckout);
//		commonActions.isElementAvailable(agreeCheckBox);
//		commonActions.clickElement(agreeCheckBox);
		
		
	}

	public void addItemToCartAndProceedCheckout() throws InterruptedException {
	
		commonActions.isElementAvailable(prodcutImageLink);
		commonActions.clickElementJavaScript(prodcutImageLink);

		Thread.sleep(5000);
		commonActions.scrollTo(addTocart);
		commonActions.clickElement(addTocart);
		
		commonActions.clickElement(proccedToCheckout);
		
		commonActions.scrollTo(proccedToCheckout);
		commonActions.clickElementJavaScript(proccedToCheckout);
		commonActions.scrollTo(proccedToCheckout);
		commonActions.clickElementJavaScript(proccedToCheckout);
		
		
	}

	public void verifyItemsAdded() {
		
		System.out.println("check "+commonActions.getText(layerCart));
	} 

}
