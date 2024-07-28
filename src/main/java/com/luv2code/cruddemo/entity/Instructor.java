package com.luv2code.cruddemo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="instructor_detail_id")
    private InstructorDetail instructorDetail;

// @OneToMany(mappedBy = "instructor",
// fetch = FetchType.EAGER,cascade = {CascadeType.PERSIST,CascadeType.MERGE,
//     CascadeType.DETACH,CascadeType.REFRESH})
// // create a list to pass multiple course
// private List<Course> course;

@OneToMany(mappedBy = "instructor",
fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,
    CascadeType.DETACH,CascadeType.REFRESH})
// create a list to pass multiple course
private List<Course> course;
// create getter and setter method for list of course
public List<Course> getCourses(){
    return course;
}
public void setCourses(List<Course>course){
    this.course=course;
}
// add convenence methods for bidirectional relationship

public void add(Course tempCourse){
    if(course==null){
        course=new ArrayList<>();
    }
    course.add(tempCourse);
    tempCourse.setInstructor(this);

}





    

    // No-argument constructor it is very important easy to use and without no argument constructor it cant allow hibernate to access the object
    public Instructor() {
    }

    // create constructor
    public Instructor(String firstName, String lastName, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    //create getter and setter methods
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // create getter and setter methods for instructor detail class
    public InstructorDetail getInstructorDetail() {
        return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetail instructorDetail) {
        this.instructorDetail = instructorDetail;
    }

    // to declare toString method
    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", instructorDetail=" + instructorDetail +
                '}';
    }
}
