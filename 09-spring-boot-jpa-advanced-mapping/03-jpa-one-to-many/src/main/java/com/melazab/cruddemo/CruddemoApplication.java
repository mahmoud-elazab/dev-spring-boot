package com.melazab.cruddemo;

import com.melazab.cruddemo.dao.AppDAO;
import com.melazab.cruddemo.entity.Course;
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
			 // createInstructor(appDAO);

			// findInstructor(appDAO);
			
			// deleteInstructor(appDAO);

			// findInstructorDetail(appDAO);

			// deleteInstructorDetail(appDAO);

			createInstructorWithCourses(appDAO);
		};
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		// create the instructor
		Instructor tempInstructor = new Instructor("Pep", "Guardiola", "pep.g@uni.com");

		// create the instructor detail
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("www.pepG.com","Football");

		// associate the objects
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		// create some courses
		Course tempCourse1 = new Course("Coaching for Beginners");
		Course tempCourse2 = new Course("Coaching for Professionals");

		// add courses to instructor
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		// save instructor
		System.out.println("Saving Instructor: "+ tempInstructor);
		System.out.println("The courses: "+ tempInstructor.getCourses());
		appDAO.save(tempInstructor);
		System.out.println("Done!");


	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 3;
		System.out.println("Deleting instructor detail with id: " + theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done!");
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

	private void createInstructor(AppDAO appDAO) {
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
