package com.yuri.mypet.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.yuri.mypet.service.DBService;
import com.yuri.mypet.service.EmailService;
import com.yuri.mypet.service.MockEmailService;

@Configuration
@Profile("test")// todos os bins dessa classe vai ser ativo apenas quando o test tiver ativo no application properties
public class TestConfig  implements WebMvcConfigurer{

	@Autowired
	private DBService  dbService;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiateTestDataBase();
		return true;
	}
	
	@Bean // fica disponvel como um componente no sistema 
	public EmailService emailService() {
		return new MockEmailService();
	}
	
	
}
