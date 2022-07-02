package com.tranquyet.constant;

import java.util.Arrays;

import lombok.Getter;

@Getter
public enum DriverEnum {
	CHROME("webdriver.chrome.driver", "C:\\Users\\DELL 7510\\Downloads\\chromedriver.exe"), 
	EDGE(null, null),
	FIREFOX(null, null);

	private String key;
	private String value;

	DriverEnum(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public static DriverEnum fromKey(String key) {
		return Arrays.stream(values()).filter(p -> p.key.equalsIgnoreCase(key)).findFirst().get();
	}
}
