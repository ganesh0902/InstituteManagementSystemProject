package com.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Integer>{

}
