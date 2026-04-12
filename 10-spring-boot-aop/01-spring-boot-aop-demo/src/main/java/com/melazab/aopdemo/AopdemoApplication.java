package com.melazab.aopdemo;

import com.melazab.aopdemo.dao.AccountDAO;
import com.melazab.aopdemo.dao.AccountDAOImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AopdemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(AopdemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner (AccountDAO theAccountDAO){
		return runner ->{
			addAccount(theAccountDAO);
		};
	}

	private void addAccount(AccountDAO theAccountDAO) {
		// call the business method
		theAccountDAO.addAccount();
		theAccountDAO.addAccount();
	}
}
