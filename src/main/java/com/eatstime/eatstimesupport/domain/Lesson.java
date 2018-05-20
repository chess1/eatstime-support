package com.eatstime.eatstimesupport.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by rapa on 18/05/18.
 */
@Getter
@Setter
@Entity
public class Lesson {
    @Id
    @GeneratedValue
    private String id;
    private Integer Number;
    private String name;

    /**
     * This is the course that this lesson belongs to
     */
    @ManyToOne
    private Course course;

}
