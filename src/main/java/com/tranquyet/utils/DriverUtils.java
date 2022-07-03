package com.tranquyet.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.tranquyet.enums.DriverEnum;

public class DriverUtils {
	/**
	 * choose driver
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
			System.setProperty(DriverEnum.CHROME.getKey(), DriverEnum.CHROME.getValue());
			driver = new ChromeDriver();
			break chooseDriver;
		}
		default -> throw new Exception();
		}
		return driver;
	}
}
