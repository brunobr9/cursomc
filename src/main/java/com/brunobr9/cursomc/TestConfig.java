package com.brunobr9.cursomc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.brunobr9.cursomc.exceptions.ServiceException;
import com.brunobr9.cursomc.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {

    @Bean
    public boolean initDatabase(DBService dbService) throws ServiceException {
	dbService.initDatabase();
	return true;
    }
}
