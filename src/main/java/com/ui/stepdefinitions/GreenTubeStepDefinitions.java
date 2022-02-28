package com.ui.stepdefinitions;

import static org.junit.Assert.assertTrue;

import com.framework.actions.AllPageObjects;
import com.framework.commonutils.PropertiesFile;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.framework.commonutils.UserDataPath;

public class GreenTubeStepDefinitions implements AllPageObjects {

	@Given("^User launch \"([^\"]*)\"$")
	public void luanchUrl(String url) {

		navigateObj.launchUrl(url);

	}

	@Given("^user clicks on Sign In Button to navigate sign in or login page$")
	public void clickSignInButton() {

		greenTubehomePageObj.navigateToSingIn();

	}

	@Given("^user logs into automationpractice with valid credentials$")
	public void login() {

		greenTubehomePageObj.login();

	}

	@Given("^Search item \"([^\"]*)\" using search icon$")
	public void searchProductcriteria(String criteria) {

		greenTubehomePageObj.searchCriteria(criteria);

	}

	@Given("^Select first item and add to cart$")
	public void addItemToCart() throws InterruptedException {
		greenTubehomePageObj.addItemToCart();

	}

	@Then("^user verifies item added sucessfully$")
	public void verifyItem() throws Throwable {
		greenTubehomePageObj.verifyItemsAdded();
	}
	
	@When("^Select first item and add to cart and proceed to checkout$")
	public void selectItems() throws InterruptedException {
		greenTubehomePageObj.addItemToCartAndProceedCheckout();
	}

	@When("^user remove one product from the cart$")
	public void removeFromCart() {

		greenTubehomePageObj.removeItemFromCart();
	}

	@Then("^verify that product is removed from the cart$")
	public void verifyCart() {

		navigateObj.refreshPage();
		String out = greenTubehomePageObj.verifyCartItems();
		assertTrue("Validation Error", out.contains("Your shopping cart contains: 2 Products"));
	}

	@Then("^user logs out form the application")
	public void logOut() {

		greenTubehomePageObj.logout();
	}

	@Then("^user verifies the sucessful login$")
	public void verifyLoginPage() {

		String userName = PropertiesFile.getPropertyValue(UserDataPath.USER_DATA_PATH, "userName");

		assertTrue("User " + userName + " login was not sucessfull",
				userName.equalsIgnoreCase(greenTubehomePageObj.verifyLoginPage()));

	}

	@When("^user proceed to checkout$")
	public void checkout() throws Throwable {
		greenTubehomePageObj.checkout();
	}

	@When("^user select Proceed to checkout option and agree the condition$")
	public void proccedToCheckout() throws InterruptedException {

	}
}
