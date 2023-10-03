package com.assessment.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Courses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cId;
	private String courseName;
	
	@OneToMany(mappedBy = "courses",fetch =  FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Batch> batch;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	private Teacher teacher;
	
	public Courses() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Courses(int cId, String courseName) {
		super();
		this.cId = cId;
		this.courseName = courseName;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
//	public List<Batch> getBatch() {
//		return batch;
//	}
//	public void setBatch(List<Batch> batch) {
//		this.batch = batch;
//	}
	@Override
	public String toString() {
		return "Courses [cId=" + cId + ", courseName=" + courseName + "]";
	}	
}