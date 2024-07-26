package com.luv2code.cruddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
@Repository
public class AppImpl implements AppDAO {
    // define entity manager
    private EntityManager entityManager;




    // insert entity manager
    @Autowired
    public AppImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist((theInstructor));
        
        
    }

    @Override
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class,theId);

       
    }
    @Override
    @Transactional
    public void deleteInstructorById(int theId){
        // reterive the instruction
        Instructor tempInstructor=entityManager.find(Instructor.class,theId);

        // delete the instruction
        entityManager.remove(tempInstructor);

    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
       return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteIntructorDetailById(int theId) {
        InstructorDetail tempInstructorDetail=entityManager.find(InstructorDetail.class, theId);
        // used to that special function 
        // it will helps to delete only one..
        // remove the associate object
        // tempInstructorDetail.geInstructor().setInstructorDetail(null);
        entityManager.remove(tempInstructorDetail);
        
    }

    
}
