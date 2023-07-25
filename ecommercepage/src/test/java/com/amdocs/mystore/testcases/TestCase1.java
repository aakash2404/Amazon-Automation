package com.amdocs.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amdocs.mystore.actiondriver.Action;
import com.amdocs.mystore.base.BaseClass;
import com.amdocs.mystore.pageobjects.CartPage;
import com.amdocs.mystore.pageobjects.CheckOutPage;
import com.amdocs.mystore.pageobjects.HomePage;
import com.amdocs.mystore.pageobjects.IndexPage;
import com.amdocs.mystore.pageobjects.LoginPage;
import com.amdocs.mystore.pageobjects.ProductPage;
import com.amdocs.mystore.pageobjects.SearchResultPage;

public class TestCase1 extends BaseClass {
	Action action = new Action();
	@BeforeMethod
	public void setUp()
	{
		loadConfig();
		launchApp();
	}
	@Test
	public void login() throws InterruptedException {
		IndexPage index = new IndexPage();
		LoginPage loginPage = index.clickOnSignIn();
		HomePage home = loginPage.login();
		home.search();
		SearchResultPage srp = home.selectProduct();
		action.launchNewWindow();
		ProductPage product = srp.addToCart();
		CartPage cart = product.goToCart();
		CheckOutPage checkOut = cart.proceedToBuy();
		checkOut.checkOut();
		home.logOut();
	}
	@AfterMethod
	public static void driverClose()
	{
		closeDriver();
	}
}
