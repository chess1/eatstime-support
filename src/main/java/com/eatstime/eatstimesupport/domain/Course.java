//package com.eatstime.eatstimesupport.domain;
//
//import lombok.Setter;
//import lombok.Getter;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * Created by rapa on 18/05/18.
// */
//@Getter
//@Setter
//@Entity
//public class Course {
//
//    @Id
//    @GeneratedValue
//    private Long id;
//    private String name;
//    private String description;
//
//    @OneToMany(mappedBy = "course")
//    private Set<Lesson> lessons = new HashSet<>();
//
//}
