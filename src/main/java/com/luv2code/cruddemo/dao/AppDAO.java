package com.luv2code.cruddemo.dao;

import java.util.List; // Correct import for List
import com.luv2code.cruddemo.entity.Course; // Make sure to import Course entity
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);
    Instructor findInstructorById(int theId);
    void deleteInstructorById(int theId);
    //  for bi-directional one-to-one
    InstructorDetail findInstructorDetailById(int theId);
    // delete using InstructorDetail
    void deleteInstructorDetailById(int theId);
    // method to find courses using instructor by id
    List<Course> findCoursesByInstructorId(int theId); // Corrected method name and import
}
