package com.tranquyet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

import com.tranquyet.service.ExecutionService;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
public class SeleniumApplication {

	@Autowired
	private ExecutionService exService;

	void test() {
		System.out.println(exService.getAll());
		;
	}

	public static void main(String[] args) {

		SpringApplication.run(SeleniumApplication.class, args);
	}

}
