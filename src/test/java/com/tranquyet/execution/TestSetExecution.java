package com.tranquyet.execution;

import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.tranquyet.constant.CommonConstant;
import com.tranquyet.utils.IOUtils;
@SpringBootTest
public class TestSetExecution {
	@BeforeSuite
	public void initialize() {
		String path = CommonConstant.DIR_PARRENT + CommonConstant.NAME_TEST_OUTPUT_FOLDER; 
		if(IOUtils.isExist(path)) {
			IOUtils.deleteFile(path);
		}
	}
	
	@Test(description = "Check")
	public void check() {
		Assert.assertTrue(1==1);
	}
	@Test
	public void check_1() {
		Assert.assertTrue(1==1);
	}
	@Test
	public void check_2() {
		Assert.assertTrue(true);
	}
	@Test
	public void check_3() {
		Assert.assertTrue(1==1);
	}
}
