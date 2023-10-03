package com.assessment.service;

import java.util.List;

import com.assessment.entities.Teacher;
import com.assessment.exception.ResourceNotFoundException;

public interface TeacherService {

	public Teacher addTeacher(Teacher teacher);
	public Teacher updateTeacher(Teacher teacher,int teacherId) throws ResourceNotFoundException;
	public Teacher getSingleTeacher(int teacherId) throws ResourceNotFoundException;
	public List<Teacher> getAll();
	public void deleteTeacher(int teacherId) throws ResourceNotFoundException;	
}