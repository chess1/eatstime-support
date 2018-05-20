package com.eatstime.eatstimesupport.repositories;

import com.eatstime.eatstimesupport.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rapa on 19/05/18.
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
