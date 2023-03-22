package com.devansh.springboot.model;

import com.devansh.springboot.SpringDataRepository.MentorSpringDataRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
public class Intern {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

//    @Size(min = 1,message = "Intern's First Name should have atleast 1 character")
    @NotBlank(message = "Intern's first name cannot be null")
    private String firstName;
//    @Size(min = 1,message = "Intern's Last Name should have atleast 1 character")
    @NotBlank(message = "Intern's last name cannot be null")
    private String lastName;
    private String college;

    @ManyToOne
    @JoinColumn(name="mentor_id")
    private Mentor mentor;
    @ManyToMany
    private List<Course> assignedCourses=new ArrayList<>();


    public Intern(){

    }
    public Intern(InternBuilder internBuilder){
        this.id= internBuilder.getId();
        this.firstName=internBuilder.getFirstName();
        this.lastName=internBuilder.getLastName();
        this.college=internBuilder.getCollege();
        this.mentor=internBuilder.getMentor();
        this.assignedCourses=internBuilder.getAssignedCourses();
    }

    public Intern(String firstName, String lastName, String college,Mentor mentor) {
//        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.college = college;
        this.mentor=mentor;

//        this.coursesAssigned=coursesAssigned;
    }
    public Intern(int id, String firstName, String lastName, String college, Mentor mentor) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.college = college;
        this.mentor = mentor;
    }


    @Override
    public String toString() {
        return firstName+" "+lastName;
    }

//    public List<Course> getCoursesAssigned() {
//        return coursesAssigned;
//    }

//    public void setCoursesAssigned(ArrayList<Course> coursesAssigned) {
//        this.coursesAssigned = coursesAssigned;
//    }

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

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }


//    @JsonProperty("mentor")
//    public String getMentorName(){
//        if(mentor!=null)
//        return mentor.getName();
//        return null;
//    }
    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }


    public List<Course> getAssignedCourses() {
        return assignedCourses;
    }


    public void setAssignedCourses(List<Course> assignedCourses) {
        this.assignedCourses = assignedCourses;
    }


    public static class InternBuilder{
        private int id;
        private String firstName;
        private String lastName;
        private String college;
        private Mentor mentor;
        private List<Course> assignedCourses=new ArrayList<>();


        public Intern build(){
            Intern newIntern=new Intern(this);
            return newIntern;
        }


        public int getId() {
            return id;
        }

        public InternBuilder setId(int id) {
            this.id = id;
            return this;
        }

        public String getFirstName() {
            return firstName;
        }

        public InternBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public String getLastName() {
            return lastName;
        }

        public InternBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public String getCollege() {
            return college;
        }

        public InternBuilder setCollege(String college) {
            this.college = college;
            return this;
        }

        public Mentor getMentor() {
            return mentor;
        }

        public InternBuilder setMentor(Mentor mentor) {
            this.mentor = mentor;
            return this;
        }

        public List<Course> getAssignedCourses() {
            return assignedCourses;
        }

        public InternBuilder setAssignedCourses(List<Course> assignedCourses) {
            this.assignedCourses = assignedCourses;
            return this;
        }




    }



}
