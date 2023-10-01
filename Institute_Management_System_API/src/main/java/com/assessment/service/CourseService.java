package com.assessment.service;

import java.util.List;

import com.assessment.entities.Courses;
import com.assessment.exception.ResourceNotFoundException;

public interface CourseService {
	
	public Courses addCourse(Courses courses);
	public Courses updateCourse(Courses courses,int cId) throws ResourceNotFoundException;
	public void deleteCourse(int id);
	public Courses getSingle(int cId) throws ResourceNotFoundException;
	public List<Courses> getAll();	
}