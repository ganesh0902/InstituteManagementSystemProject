package com.assessment.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.assessment.entities.Courses;
import com.assessment.exception.ResourceNotFoundException;
import com.assessment.repository.CourseRepository;
import com.assessment.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	private CourseRepository courseRepository;
	
	@Override
	public Courses addCourse(Courses courses) {
						
		return courseRepository.save(courses);
	}
	@Override
	public Courses updateCourse(Courses courses, int cId) throws ResourceNotFoundException {
		
		Courses courses2 = courseRepository.findById(cId).orElseThrow(()-> new ResourceNotFoundException("course","Id",cId));
		
		courses2.setCourseName(courses.getCourseName());
		
		return courseRepository.save(courses2);
	}

	@Override
	public void deleteCourse(int id) {
		
		courseRepository.deleteById(id);
	}

	@Override
	public Courses getSingle(int cId) throws ResourceNotFoundException {
		
		Courses courses = courseRepository.findById(cId).orElseThrow(()->new ResourceNotFoundException("course","Id", cId));		
		return courses;
	}

	@Override
	public List<Courses> getAll() {
		// TODO Auto-generated method stub
		return courseRepository.findAll();
	}
}