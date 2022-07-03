package com.tranquyet.execution;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.springframework.context.annotation.Configuration;

import com.tranquyet.constant.ComonConstant;
import com.tranquyet.dto.TestCaseDTO;
import com.tranquyet.enums.ActionEnum;
import com.tranquyet.utils.DriverUtils;

@Configuration
public class CentralExecution {
	public static boolean result = false;

	public static boolean execute(WebDriver driver, TestCaseDTO test, Actions builder) {

		test.getSteps().stream().forEach(p -> {
			switch (ActionEnum.fromKey(p.getAction())) {
			case CLICK -> {
				try {
					Thread.sleep(ComonConstant.TIMEOUT);
					WebElement signIn = driver.findElement(By.xpath(p.getLocator()));
					signIn.click();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				break;
			}
			case CHECK -> {
				try {
					Thread.sleep(ComonConstant.TIMEOUT);
					WebElement signIn = driver.findElement(By.xpath(p.getLocator()));
					result = (signIn.isDisplayed()); // action check
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case INPUT -> {
				try {
					Thread.sleep(ComonConstant.TIMEOUT);
					WebElement signIn = driver.findElement(By.xpath(p.getLocator()));
					Action action = builder.sendKeys(signIn, p.getData()).build();
					action.perform();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case NAVIGATE -> {
				driver.get(p.getData());
				break;
			}
			case WAIT -> {
				try {
					Thread.sleep(ComonConstant.TIMEOUT);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			case SELECT_DROPDOWN -> {
				try {
					Thread.sleep(ComonConstant.TIMEOUT);
//					WebElement signIn = driver.findElement(By.xpath(p.getLocator()));
					Select sel = new Select(driver.findElement(By.xpath(p.getLocator())));
					sel.selectByVisibleText(p.getData());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			}
			default -> {
				break;
			}
			}
		});
		return result;
	}

	public static boolean checkEmail(Integer numbSt, WebDriver driver) {
		DriverUtils.createNewTab(numbSt + 1, driver);
		driver.get(ComonConstant.URL_EMAIL);
		// TODO: check email, website didn't send email
		return true;
	}
}
