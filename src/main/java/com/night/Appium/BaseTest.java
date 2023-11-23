package com.night.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import Objects.LoginObjects;
public class BaseTest {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeMethod
	public void ConfigureAppium() throws MalformedURLException { 

		//Set Capabilities
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName", "Test");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("browserName", "chrome");
		cap.setCapability("chromedriverExecutableDir", System.getProperty("user.data")+ "/drivers");
		
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),cap);
		
		//Go to Saucedemo Website
		driver.get("https://www.saucedemo.com");
	
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
	 
}
