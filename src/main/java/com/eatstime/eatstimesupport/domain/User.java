package com.eatstime.eatstimesupport.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


/**
 * Created by rapa on 20/05/18.
 */
@Getter
@Setter
@NoArgsConstructor
public class User {


    private String name;
    private String email;
    private String content;

    public User(String name,String email,String content){

        this.name = name;
        this.email = email;
        this.content = content;
    }
}
