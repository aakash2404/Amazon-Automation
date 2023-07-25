package com.amdocs.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amdocs.mystore.actiondriver.Action;
import com.amdocs.mystore.base.BaseClass;


public class IndexPage extends BaseClass {

	@FindBy(xpath = "//*[@id=\"nav-link-accountList\"]/span")
	WebElement AccountAndList;

	@FindBy(xpath = "//*[@id=\"twotabsearchtextbox\"]")
	WebElement SearchInput;

	@FindBy(xpath = "//*[@id=\"nav-search-submit-button\"]")
	WebElement SearchButton;

	@FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[2]/div/div/div/div/div[2]/div[2]/h2/a/span")
	WebElement SelectedProductSpanPrice;

	@FindBy(xpath = "//*[@id=\"nav-item-signout\"]/span")
	WebElement SignOutLink;

	Action action = new Action();

	public IndexPage() {
		PageFactory.initElements(driver, this);
	}

	public LoginPage clickOnSignIn() {
		action.waitForElement(10, AccountAndList);
		action.click(AccountAndList);
		return new LoginPage();
	}

	public void search()
	{
		action.waitForElement(20, SearchInput);
		action.type(SearchInput, prop.getProperty("search"));
		action.waitForElement(10, SearchButton);
		action.click(SearchButton);
	}

	public SearchResultPage selectProduct()
	{
		action.waitForElement(10, SelectedProductSpanPrice);
		action.click(SelectedProductSpanPrice);
		return new SearchResultPage();
	}

	public void logOut()
	{
		action.hover(AccountAndList);
		action.click(SignOutLink);
	}

}
