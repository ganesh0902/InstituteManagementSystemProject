package com.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.entities.Batch;
import com.assessment.entities.Courses;

public interface BatchRepository extends JpaRepository<Batch,Integer>{

}
