package com.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.entities.Courses;

public interface CourseRepository extends JpaRepository<Courses,Integer>{

}
