package com.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.entities.ApiResponse;
import com.assessment.entities.Courses;
import com.assessment.exception.ResourceNotFoundException;
import com.assessment.serviceImpl.CourseServiceImpl;

@RestController
@RequestMapping("/course")
public class CourseController {

	@Autowired
	private CourseServiceImpl courseServiceImpl;
	
	@PostMapping("/")
	public ResponseEntity<?> addCourse(@RequestBody Courses courses)
	{
		Courses addCourse = courseServiceImpl.addCourse(courses);
		
		return ResponseEntity.status(HttpStatus.OK).body(addCourse);
	}
	@PutMapping("/{cId}")
	public ResponseEntity<Courses> updateCourse(@RequestBody Courses course,@PathVariable("cId") int cId) throws ResourceNotFoundException
	{
		Courses updateCourse = courseServiceImpl.updateCourse(course, cId);
		
		return ResponseEntity.status(HttpStatus.OK).body(updateCourse);
	}
	@GetMapping("/")
	public ResponseEntity<List<Courses>> getAll()
	{
		List<Courses> all = this.courseServiceImpl.getAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(all);
	}
	@GetMapping("/{cId}")
	public ResponseEntity<Courses> getSingle(@PathVariable("cId") int cId) throws ResourceNotFoundException
	{
		Courses single = courseServiceImpl.getSingle(cId);
		
		return ResponseEntity.status(HttpStatus.OK).body(single);
	}
	@DeleteMapping("/{cId}")
	public ResponseEntity<ApiResponse> deleteCourse(@PathVariable("cId") int cId)
	{
		courseServiceImpl.deleteCourse(cId);
		
		return new ResponseEntity(new ApiResponse("course deleted Successfully",true),HttpStatus.OK);
	}
}
