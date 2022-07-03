package com.tranquyet.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TestCaseDTO extends BasedDTO<TestCaseDTO> {
	private String title;
	private String expectedResult;
	private String category;
	private String preCondition;
	private List<StepDTO> steps;

	public void add(StepDTO step) {
		if (step == null) {
			return;
		}
		steps.add(step);
	}
}
