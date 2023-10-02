package com.assessment.entities;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Batch {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int batchId;
	private String batchName;
	private String mode;
	private String fees;
	private String batch_duration;
	private String startDate;
	private String endDate;
	private int numberOfSeatch;
	private String batchTime;
	
	@ManyToOne
	private Courses courses;

//	@OneToMany
//	private List<Candidate> candidate;
//	
	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Batch(int batchId, String batchName, String mode, String fees, String batch_duration, String startDate,
			String endDate, int numberOfSeatch, String batchTime) {
		super();
		this.batchId = batchId;
		this.batchName = batchName;
		this.mode = mode;
		this.fees = fees;
		this.batch_duration = batch_duration;
		this.startDate = startDate;
		this.endDate = endDate;
		this.numberOfSeatch = numberOfSeatch;
		this.batchTime = batchTime;
		
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public String getBatchName() {
		return batchName;
	}

	public void setBatchName(String batchName) {
		this.batchName = batchName;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getFees() {
		return fees;
	}

	public void setFees(String fees) {
		this.fees = fees;
	}

	public String getBatch_duration() {
		return batch_duration;
	}

	public void setBatch_duration(String batch_duration) {
		this.batch_duration = batch_duration;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getNumberOfSeatch() {
		return numberOfSeatch;
	}

	public void setNumberOfSeatch(int numberOfSeatch) {
		this.numberOfSeatch = numberOfSeatch;
	}

	public String getBatchTime() {
		return batchTime;
	}

	public void setBatchTime(String batchTime) {
		this.batchTime = batchTime;
	}	

	public Courses getCourses() {
		return courses;
	}

	public void setCourses(Courses courses) {
		this.courses = courses;
	}	
	
//	public List<Candidate> getCandidate() {
//		return candidate;
//	}
//
//	public void setCandidate(List<Candidate> candidate) {
//		this.candidate = candidate;
//	}

	@Override
	public String toString() {
		return "Batch [batchId=" + batchId + ", batchName=" + batchName + ", mode=" + mode + ", fees=" + fees
				+ ", batch_duration=" + batch_duration + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", numberOfSeatch=" + numberOfSeatch + ", batchTime=" + batchTime + ", courses=" + courses
				+ ", candidate]";
	}
	
}
