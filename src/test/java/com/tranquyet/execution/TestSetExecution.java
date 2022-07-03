package com.tranquyet.execution;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
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

	/**
	 * 
	 */
	@Test(description = "Case_1: check faild to create new account", priority = 1)
	public void faildCreateAccount() {
		TestCaseDTO case_1 = cases.get(0);
		Assert.assertNotNull(cases);
		try {
			driver = DriverUtils.driverOption(DriverEnum.CHROME);
			driver.manage().window().minimize();
			Actions builder = new Actions(driver);
			boolean result = CentralExecution.execute(driver, case_1, builder);
			Assert.assertTrue(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(description = "Case_2: Create new account successfully", priority = 2)
	public void createNewAccountSuccess() {
		TestCaseDTO case_1 = cases.get(1);
		Assert.assertNotNull(cases);
		((JavascriptExecutor) driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		try {
//			driver = DriverUtils.driverOption(DriverEnum.CHROME);
//			driver.manage().window().minimize();
			Actions builder = new Actions(driver);
			boolean result = CentralExecution.execute(driver, case_1, builder);
			Assert.assertTrue(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterTest
	public void endTest() {
		try {
			Thread.sleep(15000);
			driver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
