package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor theInstructor);
     Instructor findInstructorById(int theId);
     void deleteInstructorById(int theId);
    //  for bi direction one to one
    InstructorDetail findInstructorDetailById(int theId);
    // delete using instructordetail
    void deleteIntructorDetailById(int theId);
    
}
