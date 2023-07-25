package com.amdocs.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amdocs.mystore.actiondriver.Action;
import com.amdocs.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass {

	@FindBy(xpath = "//*[@id=\"add-to-cart-button\"]")
	WebElement AddToCartButton;

	Action action = new Action();

	public SearchResultPage()
	{
		PageFactory.initElements(driver, this);
	}

	public ProductPage addToCart()
	{
		action.waitForElement(10, AddToCartButton);
		action.click(AddToCartButton);
		return new ProductPage();
	}


}
