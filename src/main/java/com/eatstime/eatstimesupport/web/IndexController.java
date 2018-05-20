package com.eatstime.eatstimesupport.web;

import com.eatstime.eatstimesupport.domain.Course;
import com.eatstime.eatstimesupport.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by rapa on 18/05/18.
 */
@Controller
public class IndexController {

    @Autowired
    private CourseRepository courseRepository;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String load(ModelMap modelMap) {

        final List<Course> courses = courseRepository.findAll();
        modelMap.put("theCourses", courses);

        return "index";
    }


    @RequestMapping(value = "/support", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {

        final List<Course> courses = courseRepository.findAll();
        modelMap.put("theCourses", courses);

        return "thank_you";
    }


}
