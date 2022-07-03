package com.tranquyet.service;

import java.util.List;

import com.tranquyet.constant.ComonConstant;
import com.tranquyet.dto.TestCaseDTO;

public interface ExecutionService {
	static List<TestCaseDTO> source(){
		return ExcelHelper.initializeData(ComonConstant.EXCEL_DATA_DIR);
	}

	void execute(TestCaseDTO test);

	List<TestCaseDTO> getAll();
}
