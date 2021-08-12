package com.brunobr9.cursomc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.brunobr9.cursomc.exceptions.ServiceException;
import com.brunobr9.cursomc.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	@Bean
	public boolean initDatabase(DBService dbService) throws ServiceException {
		if (!"create".equals(strategy)) {
			return false;
		}

		dbService.initDatabase();

		return true;
	}
}
