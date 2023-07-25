package com.amdocs.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
    public static  WebDriver driver;
    public static Properties prop;

    @BeforeTest
    public void loadConfig() {
        try {
            prop = new Properties();
            FileInputStream io = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\Config.properties");
            prop.load(io);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void launchApp() {
        WebDriverManager.chromedriver().setup();
        String browserName = prop.getProperty("browser");
        if (browserName.contains("chrome")) {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));
    }
    
    public static void closeDriver()
    {
    	driver.quit();
    }
}
