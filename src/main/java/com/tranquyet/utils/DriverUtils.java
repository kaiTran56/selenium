package com.tranquyet.utils;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tranquyet.enums.DriverEnum;

public class DriverUtils {
	/**
	 * choose driver
	 * 
	 * @param option
	 * @return
	 * @throws Exception
	 */
	public static WebDriver driverOption(DriverEnum option) throws Exception {
		WebDriver driver = null;
		chooseDriver: switch (option) {
		case CHROME -> {
			System.setProperty(DriverEnum.CHROME.getKey(), DriverEnum.CHROME.getValue());
			driver = new ChromeDriver();
			break chooseDriver;
		}
		case EDGE -> {
			System.setProperty(DriverEnum.EDGE.getKey(), DriverEnum.EDGE.getValue());
			driver = new EdgeDriver();
			break chooseDriver;
		}
		default -> throw new Exception();
		}
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		return driver;
	}

	public static void createNewTab(Integer numbSt, WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(numbSt));
	}

}
