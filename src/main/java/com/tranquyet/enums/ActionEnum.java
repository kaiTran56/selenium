package com.tranquyet.enums;

import java.util.Arrays;

import lombok.Getter;

@Getter
public enum ActionEnum {
	CLICK("click"), INPUT("input"), NAVIGATE("navigate"), 
	CHECK("check"), SELECT_DROPDOWN("select_dropdown"),
	WAIT("wait");

	private String key;

	ActionEnum(String key) {
		this.key = key;
	}

	public static ActionEnum fromKey(String key) {
		return Arrays.stream(values())
				.filter(p -> p.key.equalsIgnoreCase(key)).findFirst().get();
	}
}
