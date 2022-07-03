package com.tranquyet.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StepDTO {
	private Long stepId;
	private String action;
	private String locator;
	private String typeLocator;
	private String data;
	private String description;

	public void setLocator(String locator) {
		if (locator == null)
			return;
		String[] arr = locator.split(" ");
		this.typeLocator = arr[0];
		this.locator = arr[1];
	}
}
