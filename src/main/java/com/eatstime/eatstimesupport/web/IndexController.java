package com.eatstime.eatstimesupport.web;

import com.eatstime.eatstimesupport.domain.Course;
import com.eatstime.eatstimesupport.domain.User;
import com.eatstime.eatstimesupport.repositories.CourseRepository;
import com.eatstime.eatstimesupport.repositories.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by rapa on 18/05/18.
 */
@Controller
public class IndexController {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private UserRepository userRepository;


    /**
     * This is hte on load
     *
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String load(ModelMap modelMap) {

        final List<Course> courses = courseRepository.findAll();
        modelMap.put("theCourses", courses);

        return "index";
    }


    /**
     * This is the support for eatstime product
     *
     * @param name
     * @param email
     * @param content
     * @return
     */
    @RequestMapping(value = "/support", method = RequestMethod.POST,
            params = {"name", "email", "content"})
    public String index(@RequestParam String name,
                        @RequestParam String email,
                        @RequestParam String content) {

        if (!validate(name, email, content)) {
            // TODO : handle in UI ??
            return "error";
        }

        /**
         * store in persist layer
         */
        userRepository.save(new User(name, email, content));

        /**
         * Return view
         */
        return "thank_you";
    }

    /**
     * Validation section
     *
     * @param name
     * @param email
     * @param content
     * @return
     */
    private boolean validate(String name, String email, String content) {

        if (StringUtils.isBlank(name) ||
                StringUtils.isBlank(email) ||
                StringUtils.isBlank(content)) {

            return false;

        }


        return true;
    }


}
