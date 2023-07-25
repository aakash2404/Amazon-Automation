package com.amdocs.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amdocs.mystore.actiondriver.Action;
import com.amdocs.mystore.base.BaseClass;

public class ProductPage extends BaseClass {

	@FindBy(xpath = "//*[@id=\"sw-gtc\"]/span/a")
	WebElement CartButton;

	Action action = new Action();

	public ProductPage()
	{
		PageFactory.initElements(driver, this);
	}

	public CartPage goToCart()
	{
		action.waitForElement(10, CartButton);
		action.click(CartButton);
		return new CartPage();
	}
}
