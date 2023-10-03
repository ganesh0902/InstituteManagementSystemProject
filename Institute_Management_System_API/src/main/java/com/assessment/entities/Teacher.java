package com.assessment.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tId;
	private String teacherName;
	private String education;
	private String subject;
	private String experience;
	private String linkedUrl;
	private String github;
	
//	@OneToMany(mappedBy = "teacher")
//	private List<Batch> batch;
	
	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Teacher(int tId, String teacherName, String education, String experience, String linkedUrl, 
			String github,String subject) {
		super();
		this.tId = tId;
		this.teacherName = teacherName;
		this.education = education;
		this.experience = experience;
		this.linkedUrl = linkedUrl;		
		this.github = github;
		
		this.subject=subject;
				
	}
	public int gettId() {
		return tId;
	}
	public void settId(int tId) {
		this.tId = tId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
				
		this.experience = experience;
	}
	public String getLinkedUrl() {
		return linkedUrl;
	}
	public void setLinkedUrl(String linkedUrl) {
		this.linkedUrl = linkedUrl;
	}		
	public String getGithub() {
		return github;
	}			
	public void setGithub(String github) {
		this.github = github;
	}	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Teacher [tId=" + tId + ", teacherName=" + teacherName + ", education=" + education + ", subject="
				+ subject + ", experience=" + experience + ", linkedUrl=" + linkedUrl +  
				 ", github=" + github + "]";
	}		
	
}