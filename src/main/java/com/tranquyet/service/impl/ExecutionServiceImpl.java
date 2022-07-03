package com.tranquyet.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.tranquyet.constant.ComonConstant;
import com.tranquyet.dto.TestCaseDTO;
import com.tranquyet.service.ExcelHelper;
import com.tranquyet.service.ExecutionService;

@Service
@Transactional
public class ExecutionServiceImpl implements ExecutionService{
	
	

	@Override
	public void execute(TestCaseDTO test) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TestCaseDTO> getAll() {
		// TODO Auto-generated method stub
		return ExcelHelper.initializeData(ComonConstant.EXCEL_DATA_DIR);
	}

}
