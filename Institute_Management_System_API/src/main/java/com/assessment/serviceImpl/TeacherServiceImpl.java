package com.assessment.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.entities.Teacher;
import com.assessment.exception.ResourceNotFoundException;
import com.assessment.repository.TeacherRepository;
import com.assessment.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherRepository teacherRepository;
	
	@Override
	public Teacher addTeacher(Teacher teacher) {
		
		return this.teacherRepository.save(teacher);
	}

	@Override
	public Teacher updateTeacher(Teacher teacher, int teacherId) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		
		Teacher teacher2 = this.teacherRepository.findById(teacherId).orElseThrow(()-> new ResourceNotFoundException("Teacher","Id", teacherId));
		
		teacher2.setEducation(teacher.getEducation());
		teacher2.setExperience(teacher.getExperience());
		teacher2.setTeacherName(teacher.getTeacherName());
		teacher2.setGithub(teacher.getGithub());
		teacher2.setLinkedUrl(teacher.getLinkedUrl());
		
		
		return this.teacherRepository.save(teacher2);
	}

	@Override
	public Teacher getSingleTeacher(int teacherId) throws ResourceNotFoundException {
		
		return this.teacherRepository.findById(teacherId).orElseThrow(()-> new ResourceNotFoundException("Teacher","Id", teacherId));
	}

	@Override
	public List<Teacher> getAll() {
		// TODO Auto-generated method stub
		return this.teacherRepository.findAll();
	}

	@Override
	public void deleteTeacher(int teacherId) throws ResourceNotFoundException {
		
		
		Teacher orElseThrow = this.teacherRepository.findById(teacherId).orElseThrow(()-> new ResourceNotFoundException("Teacher","Id", teacherId));
		
		this.teacherRepository.deleteById(teacherId);				
	}

}
