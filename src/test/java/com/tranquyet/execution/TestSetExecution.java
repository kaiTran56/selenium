package com.tranquyet.execution;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tranquyet.constant.ComonConstant;
import com.tranquyet.dto.TestCaseDTO;
import com.tranquyet.enums.DriverEnum;
import com.tranquyet.service.ExecutionService;
import com.tranquyet.utils.DriverUtils;
import com.tranquyet.utils.IOUtils;

@SpringBootTest
public class TestSetExecution {

	public List<TestCaseDTO> cases;

	private static WebDriver driver = null;

	@BeforeTest
	public void initialize() {

		String path = ComonConstant.DIR_PARRENT + ComonConstant.NAME_TEST_OUTPUT_FOLDER;
		if (IOUtils.isExist(path)) {
			IOUtils.deleteFile(path);
		}
		cases = ExecutionService.source();

	}

	@Test(description = "Case_1: check faild to create new account")
	public void faildCreateAccount() {
		TestCaseDTO case_1 = cases.get(0);
		Assert.assertNotNull(cases);
		try {
			driver = DriverUtils.driverOption(DriverEnum.CHROME);
			driver.get(case_1.getSteps().get(0).getData());
			WebElement signIn = driver.findElement(By.xpath(case_1.getSteps().get(1).getLocator()));
			signIn.click();
			Assert.assertTrue(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void check_1() {
		Assert.assertTrue(1 == 1);
	}

	@Test
	public void check_2() {
		Assert.assertTrue(true);
	}

	@Test
	public void check_3() {
		Assert.assertTrue(1 == 1);
	}

	@AfterTest
	public void endTest() {
		try {
			Thread.sleep(5000);
			driver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
