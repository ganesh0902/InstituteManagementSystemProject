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
import com.assessment.entities.Teacher;
import com.assessment.exception.ResourceNotFoundException;
import com.assessment.serviceImpl.TeacherServiceImpl;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private TeacherServiceImpl teacherServiceImpl;
	
	@PostMapping("/")
	public ResponseEntity<Teacher> addteacher(@RequestBody Teacher teacher)
	{
		
		Teacher addTeacher = this.teacherServiceImpl.addTeacher(teacher);
		
		return ResponseEntity.status(HttpStatus.OK).body(addTeacher);
	}
	@PutMapping("/{teacherId}")
	public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher ,@PathVariable("teacherId") int teacherId) throws ResourceNotFoundException
	{
		
		Teacher updateTeacher = this.teacherServiceImpl.updateTeacher(teacher, teacherId);
		
		return ResponseEntity.status(HttpStatus.OK).body(updateTeacher);
	}
	@GetMapping("/{teacherId}")
	public ResponseEntity<Teacher> getSingleTeacher(@PathVariable("teacherId") int teacherId) throws ResourceNotFoundException
	{
		Teacher singleTeacher = this.teacherServiceImpl.getSingleTeacher(teacherId);
		
		return ResponseEntity.status(HttpStatus.OK).body(singleTeacher);
	}
	@GetMapping("/")
	public ResponseEntity<List<Teacher>> getAll()
	{
		List<Teacher> all = this.teacherServiceImpl.getAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(all);
	}
	@DeleteMapping("/{teacherId}")
	public ResponseEntity<ApiResponse> deleteTeacher(@PathVariable("teacherId") int teacherId) throws ResourceNotFoundException
	{
		
		this.teacherServiceImpl.deleteTeacher(teacherId);
		
		return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse("teacher Record Deleted Successfully",true));
	}
}
