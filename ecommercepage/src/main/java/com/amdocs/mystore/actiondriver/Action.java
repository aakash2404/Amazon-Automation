package com.amdocs.mystore.actiondriver;

import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.amdocs.mystore.base.BaseClass;

public class Action extends BaseClass {


	public void click(WebElement webElement)
	{
		Assert.assertTrue(webElement.isDisplayed(), "Verify that "+webElement+" is Visible");
		Assert.assertTrue(webElement.isEnabled(), "Verify that "+webElement+" is Clickable");
		webElement.click();
	}

	public void type(WebElement webElement, String text)
	{
		Assert.assertTrue(webElement.isDisplayed(), "Verify that "+webElement+" is Visible");
		webElement.clear();
		webElement.sendKeys(text);
	}

	public void waitForElement(long time, WebElement webElement) {
		new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(webElement));
	}

	public void hover(WebElement webElement)
	{
		Actions actions = new Actions(driver);
		Assert.assertTrue(webElement.isDisplayed(), "Verify that "+webElement+" is Visible");
		actions.moveToElement(webElement).perform();
	}

	public void launchNewWindow() {
		String currentWindowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String windowHandle : windowHandles) {
			if (!windowHandle.equals(currentWindowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
	}
}
