package com.tranquyet;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
public class SeleniumApplication {

	public static void main(String[] args) {

		SpringApplication.run(SeleniumApplication.class, args);
		check();
	}

	public static void check() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL 7510\\Downloads\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Launch Website
		driver.navigate().to("http://www.javatpoint.com/");

		// Maximize the browser
		driver.manage().window().maximize();

		// Scroll down the webpage by 5000 pixels
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0, 5000)");

	}

}
