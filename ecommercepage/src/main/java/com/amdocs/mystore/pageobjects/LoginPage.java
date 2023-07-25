package com.amdocs.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amdocs.mystore.actiondriver.Action;
import com.amdocs.mystore.base.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(xpath = "//*[@id=\"ap_email\"]")
	WebElement EmailInput;

	@FindBy(xpath = "//*[@id=\"continue\"]")
	WebElement ContinueButton;

	@FindBy(xpath = "//*[@id=\"ap_password\"]")
	WebElement PasswordInput;

	@FindBy(xpath = "//*[@id=\"signInSubmit\"]")
	WebElement SignInButton;

	Action action = new Action();

	public LoginPage() {
		PageFactory.initElements(driver, this); 
	}

	public HomePage login() throws InterruptedException
	{
		action.type(EmailInput, prop.getProperty("mobNo"));
		action.waitForElement(10, ContinueButton);
		action.click(ContinueButton);
		action.type(PasswordInput, prop.getProperty("password"));
		action.waitForElement(10, SignInButton);
		action.click(SignInButton);
		return new HomePage();
	}
}
