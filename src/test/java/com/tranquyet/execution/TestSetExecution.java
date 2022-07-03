package com.tranquyet.execution;

import java.util.List;

import org.junit.Assert;
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

//	@Parameters("driverType")
	@BeforeTest
	public void initialize() throws Exception {
		String path = ComonConstant.DIR_PARRENT + ComonConstant.NAME_TEST_OUTPUT_FOLDER;
		if (IOUtils.isExist(path)) {
			IOUtils.deleteFile(path);
		}
		cases = ExecutionService.source();
//		if (driverType.equalsIgnoreCase("chrome")) {

//		} else if (driverType.equalsIgnoreCase("edge")) {
//			driver = DriverUtils.driverOption(DriverEnum.EDGE);
//		}

	}

	/**
	 * @throws Exception
	 * 
	 */
	@Test(description = "Case_1: check faild to create new account", priority = 1)
	public void faildCreateAccount() throws Exception {
		driver = DriverUtils.driverOption(DriverEnum.CHROME);
		TestCaseDTO case_1 = cases.get(0);
		Assert.assertNotNull(cases);

		Actions builder = new Actions(driver);
		boolean result = CentralExecution.execute(driver, case_1, builder);
		Assert.assertTrue(result);

	}

	@Test(description = "Case_3: Create newsletter", priority = 2)
	public void createNewsletter() {
		Integer numbSt = 1;
		TestCaseDTO case_1 = cases.get(2);
		DriverUtils.createNewTab(numbSt, driver);
		Actions builder = new Actions(driver);
		boolean result = CentralExecution.execute(driver, case_1, builder);
		boolean checkEmail = CentralExecution.checkEmail(numbSt, driver);
		Assert.assertTrue(result);
		Assert.assertTrue(checkEmail);

	}

	@Test(description = "Case_4: Send contact Us", priority = 3)
	public void sendContactUs() {
		Integer numbSt = 3;
		TestCaseDTO case_1 = cases.get(3);
		Assert.assertNotNull(cases);
		DriverUtils.createNewTab(numbSt, driver);
		Actions builder = new Actions(driver);
		boolean result = CentralExecution.execute(driver, case_1, builder);
		boolean checkEmail = CentralExecution.checkEmail(numbSt, driver);
		Assert.assertTrue(checkEmail);
		Assert.assertTrue(result);

	}

	@Test(description = "Case_2: Create new account successfully", priority = 5)
	public void createNewAccountSuccess() {
		Integer numbSt = 6;
		TestCaseDTO case_1 = cases.get(1);
		Assert.assertNotNull(cases);
		DriverUtils.createNewTab(numbSt, driver);

		Actions builder = new Actions(driver);
		boolean result = CentralExecution.execute(driver, case_1, builder);
		Assert.assertTrue(result);
	}

	@Test(description = "Case_5: check search function", priority = 4)
	public void checkSearchFunction() throws Exception {
		Integer numbSt = 5;
		TestCaseDTO case_1 = cases.get(4);
		Assert.assertNotNull(cases);
		DriverUtils.createNewTab(numbSt, driver);
		Actions builder = new Actions(driver);
		boolean result = CentralExecution.execute(driver, case_1, builder);
		Assert.assertTrue(result);
	}

	@Test(description = "Case_6: Buy sale product")
	public void buySaleProduct() throws Exception {
		WebDriver driverEdge = DriverUtils.driverOption(DriverEnum.EDGE);
		driverEdge.manage().window().minimize();

//		Integer numbSt = 7;
		TestCaseDTO case_1 = cases.get(5);
		Assert.assertNotNull(cases);
//		DriverUtils.createNewTab(numbSt, driver);

		Actions builder = new Actions(driverEdge);
		boolean result = CentralExecution.execute(driverEdge, case_1, builder);
		Assert.assertTrue(result);
	}

	@AfterTest
	public void endTest() {
		try {
			Thread.sleep(10000);
			driver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
