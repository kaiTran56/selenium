package com.tranquyet.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionUtils extends Actions {

	private static WebDriver driver;

	private static Actions action;

	public ActionUtils(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static ActionUtils initialize(WebDriver Idriver, Actions Iaction) {
		driver = Idriver;
		action = Iaction;
		return null;
	}

//	public static ActionUtils click() {
//		return null;
//	}
}
