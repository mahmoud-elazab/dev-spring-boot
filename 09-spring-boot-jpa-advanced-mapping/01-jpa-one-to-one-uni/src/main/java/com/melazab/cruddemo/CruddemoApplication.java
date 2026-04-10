package com.melazab.cruddemo;

import com.melazab.cruddemo.dao.AppDAO;
import com.melazab.cruddemo.entity.Instructor;
import com.melazab.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner ->{
			createInstrcutor(appDAO);
		};
	}

	private void createInstrcutor(AppDAO appDAO) {
		// create the instructor
		Instructor tempInstructor = new Instructor("Falk", "Howar", "falk.howar@uni.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("www.falk.howar.com","Swimming");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// save the instructor
		System.out.println("Saving the instructor: "+ tempInstructor);
		appDAO.save(tempInstructor);

		System.out.println("Done!");
	}

}
