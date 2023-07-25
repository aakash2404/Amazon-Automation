package com.amdocs.mystore.pageobjects;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amdocs.mystore.actiondriver.Action;
import com.amdocs.mystore.base.BaseClass;

public class CheckOutPage extends BaseClass {

	@FindBy(xpath = "//*[@id=\"shipToThisAddressButton\"]")
	WebElement UseThisAddressButton;

	@FindBy(xpath = "//span[@class='a-color-base a-text-bold'][normalize-space()='Cash on Delivery/Pay on Delivery']")
	WebElement CODRadioButton;

	@FindBy(xpath = "//span[@class='a-button-inner']//input[@name='ppw-widgetEvent:SetPaymentPlanSelectContinueEvent']")
	WebElement UseThisPaymentMetodButton;

	@FindBy(xpath = "//input[@aria-labelledby='submitOrderButtonId-announce']")
	WebElement PlaceYourOrderButton;

	@FindBy(xpath = "//span[normalize-space()='& Orders']")
	WebElement Orders;

	@FindBy(xpath = "//a[@id='a-autoid-2-announce']")
	WebElement TrackPackageButton;

	Action action = new Action();

	public CheckOutPage()
	{
		PageFactory.initElements(driver, this);
	}

	public void checkOut() throws InterruptedException
	{
		action.waitForElement(10, UseThisAddressButton);
		action.click(UseThisAddressButton);
		action.waitForElement(20, CODRadioButton);
		action.click(CODRadioButton);
		action.waitForElement(10, UseThisPaymentMetodButton);
		action.click(UseThisPaymentMetodButton);
		action.waitForElement(10, PlaceYourOrderButton);
		action.click(PlaceYourOrderButton);
		action.waitForElement(10, Orders);
		action.click(Orders);
		String actualText = TrackPackageButton.getText();
		assertTrue(actualText.contains("Track package"), "Verify that order is placed.");
	}
}
