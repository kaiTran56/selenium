package com.tranquyet.constant;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComonConstant {

	public static final String NAME_TEST_OUTPUT_FOLDER="test-output";
	
	public static String DIR_PARRENT = System.getProperty("user.dir")+ "\\" ;
	
	public static String EXCEL_DATA_DIR = DIR_PARRENT+"TES_GMO_SELENIUM.xlsx";
	
	public static final Integer TIMEOUT=3000;
	
	public static final String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

	public static final String URL_EMAIL = "https://mail.google.com/mail/u/0/#inbox";
}
