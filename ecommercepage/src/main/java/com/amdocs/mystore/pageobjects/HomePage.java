package com.amdocs.mystore.pageobjects;

import org.openqa.selenium.support.PageFactory;

public class HomePage extends IndexPage {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
}
