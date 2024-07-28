package com.luv2code.cruddemo;

import java.util.List; // Correct import for List
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {
        return runner -> {
            // createInstructor(appDAO);
            // findInstructor(appDAO);
            // deleteInstructor(appDAO);
            // findInstructorDetail(appDAO);
            // deleteInstructorDetail(appDAO);
            // createInstructorWithCourses(appDAO);
            // findInstructorWithCourses(appDAO);
            findCoursesForInstructor(appDAO);
        };
    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int theId = 8;
        System.out.println("Finding courses for instructor ID: " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("Instructor: " + tempInstructor);

        // to find courses using instructor id
        System.out.println("Finding courses using instructor ID: " + theId);
        List<Course> courses = appDAO.findCoursesByInstructorId(theId);

        tempInstructor.setCourses(courses);
        System.out.println("Courses for the instructor: " + courses);
        System.out.println("Completed successfully");
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int theId = 8;
        System.out.println("Finding instructor ID: " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("Instructor: " + tempInstructor);
        System.out.println("Associated courses: " + tempInstructor.getCourses());
        System.out.println("Successfully completed");
    }

    private void createInstructorWithCourses(AppDAO appDAO) {
        Instructor tempInstructor = new Instructor("Susan", "Venue", "susan2@gmail.com");
        InstructorDetail tempInstructorDetail = new InstructorDetail("https://susan.www.com", "cricket");
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        Course tempCourse1 = new Course("Attitude is Everything");
        Course tempCourse2 = new Course("Round Robin");

        // add courses
        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);

        // save the instructor
        System.out.println("Saving instructor with courses: " + tempInstructor);
        appDAO.save(tempInstructor);
        System.out.println("Successfully completed");
    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int theId = 6;
        System.out.println("Deleting instructor detail ID: " + theId);
        appDAO.deleteInstructorDetailById(theId);
        System.out.println("Deleted successfully");
    }

    private void findInstructorDetail(AppDAO appDAO) {
        int theId = 6;
        InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
        System.out.println("Instructor detail: " + tempInstructorDetail);
        System.out.println("Associated instructor: " + tempInstructorDetail.geInstructor());
        System.out.println("Done working bidirectionally");
    }

    private void deleteInstructor(AppDAO appDAO) {
        int theId = 2;
        System.out.println("Deleting instructor ID: " + theId);
        appDAO.deleteInstructorById(theId);
        System.out.println("Done completed successfully");
    }

    private void findInstructor(AppDAO appDAO) {
        int theId = 3;
        System.out.println("Finding instructor with ID: " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);
        System.out.println("Instructor found: " + tempInstructor);
        System.out.println("Associated InstructorDetail: " + tempInstructor.getInstructorDetail());
    }

    private void createInstructor(AppDAO appDAO) {
        Instructor tempInstructor = new Instructor("Srinivasan", "J", "srinivasan@gmail.com");
        InstructorDetail tempInstructorDetail = new InstructorDetail("www.srini", "badminton");
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);
        System.out.println("Done");
    }
}
