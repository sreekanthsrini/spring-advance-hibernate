package com.luv2code.cruddemo;

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
            //   createInstructor(appDAO);
            //  findInstructor(appDAO);
            // deleteInstructor(appDAO);
            // findInstructorDetail(appDAO);
            // deleteInstructorDetail(appDAO);
            createInstructorwithcourses(appDAO);
        };
    }
    private void createInstructorwithcourses(AppDAO appDAO){
        Instructor tempInstructor=new Instructor("susan","venue","susan2gmail.com");
        InstructorDetail tempInstructorDetail=new InstructorDetail("httpsusan.www.com","cricket");
        tempInstructor.setInstructorDetail(tempInstructorDetail);
        Course tempCourse1=new Course("attitude is everything");
        Course tempCourse2=new Course("round robin");
        // add course
        tempInstructor.add(tempCourse1);
        tempInstructor.add(tempCourse2);

        // save the instructor
        System.out.println("saving courses"+tempInstructor);
        System.out.println("list of courses used"+tempInstructor.getCourses());
        appDAO.save(tempInstructor);

        System.out.println("successfullycompleted");
        




    }





    private void deleteInstructorDetail(AppDAO appDAO){
        int theId=6;
        System.out.println("instructordetail id delete"+theId);
        appDAO.deleteIntructorDetailById(theId);
        System.out.println("delete successwfully");
    }
    // bidirection one to one
    // first we can refer and analayze a data from instructor table
    // in here we can fetch a data from instructordetail table
    // with the help of foreign key we can bi direction both table
    private void findInstructorDetail(AppDAO appDAO){
        int theId=6;
        InstructorDetail tempInstructorDetail=appDAO.findInstructorDetailById(theId);
        System.out.println("tempinstructordetail"+tempInstructorDetail);
        System.out.println("the associate instructor"+tempInstructorDetail.geInstructor());
        System.out.println("done working bidirection");

    }

    private void deleteInstructor(AppDAO appDAO) {
        int theId=2;
        System.out.println("delete id"+theId);
        appDAO.deleteInstructorById(theId);
        System.out.println("done completed successfully");

        
    }

    private void findInstructor(AppDAO appDAO) {
        int theId = 3;
        System.out.println("Finding instructor with ID: " + theId);
        Instructor tempInstructor = appDAO.findInstructorById(theId);
       
            System.out.println("Instructor found: " + tempInstructor);
            System.out.println("Associated InstructorDetail: " + tempInstructor.getInstructorDetail());
       
    }

    private void createInstructor(AppDAO appDAO) {
        Instructor tempInstructor = new Instructor("srinivasan", "J", "srinivasan@gmail.com");
        InstructorDetail tempInstructorDetail = new InstructorDetail("www.srini", "batmitton");
        tempInstructor.setInstructorDetail(tempInstructorDetail);

        System.out.println("Saving instructor: " + tempInstructor);
        appDAO.save(tempInstructor);
        System.out.println("Done");
    }
}
    
