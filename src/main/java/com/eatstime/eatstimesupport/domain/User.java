package com.eatstime.eatstimesupport.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by rapa on 20/05/18.
 */
@Getter
@Setter
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;
    private String content;

    public User(String name,String email,String content){

        this.name = name;
        this.email = email;
        this.content = content;
    }
}
