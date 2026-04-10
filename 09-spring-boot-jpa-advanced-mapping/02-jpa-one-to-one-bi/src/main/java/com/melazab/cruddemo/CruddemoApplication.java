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
			// createInstrcutor(appDAO);

			// findInstructor(appDAO);
			
			// deleteInstructor(appDAO);

			findInstructorDetail(appDAO);
		};
	}

	private void findInstructorDetail(AppDAO appDAO) {
		// get the instructor detail object
		int theId = 2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);

		// print the instructor detail
		System.out.println("tempInstructorDetail: " + tempInstructorDetail);

		// print the associated instructor
		System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

		System.out.println("Done!");
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId =1;
		System.out.println("Deleting instructor id: " + theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("Done!");
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

	private void findInstructor(AppDAO appDAO){
		int theId = 1;
		System.out.println("Finding instructor id: "+ theId);

		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstrcutor: " + tempInstructor);
		System.out.println("The associated intructorDetail: " + tempInstructor.getInstructorDetail());



	}

}
