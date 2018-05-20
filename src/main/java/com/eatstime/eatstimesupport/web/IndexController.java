package com.eatstime.eatstimesupport.web;

import com.eatstime.eatstimesupport.domain.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by rapa on 18/05/18.
 */
@Controller
public class IndexController {

    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    @Autowired
    ObjectMapper objectMapper;

//    @Autowired
//    private CourseRepository courseRepository;
//    @Autowired
//    private UserRepository userRepository;


    /**
     * This is hte on load
     *
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String load(ModelMap modelMap) {
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
                        @RequestParam String content) throws IOException {

        if (!validate(name, email, content)) {
            // TODO : handle in UI ??
            return "error";
        }


        df.format(new Date());
        String fileName = email.concat("_").concat(df.getCalendar().getTime().toString());

        // save in disk
        File targetFile = new File("src/main/resources/" + fileName);
        List<String> strings = new ArrayList<String>();
        strings.add(objectMapper.writeValueAsString(new User(name, email, content)));
        FileUtils.writeLines(targetFile, strings);


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

        if (StringUtils.isBlank(name)    ||
                StringUtils.isBlank(email) ||
                StringUtils.isBlank(content)) {

            return false;

        }


        return true;
    }


}
