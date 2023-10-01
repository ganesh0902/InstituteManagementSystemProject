package com.assessment.service;

import java.util.List;

import com.assessment.entities.Batch;
import com.assessment.exception.ResourceNotFoundException;

public interface BatchService {

	public Batch addBatch(Batch batch,int courseId) throws ResourceNotFoundException;
	public Batch updateBatch(Batch batch,int batchId,int courseId) throws ResourceNotFoundException;
	public void deletebatch(int batchId) throws ResourceNotFoundException;
	public Batch getSingleBatch(int batchId) throws ResourceNotFoundException;
	public List<Batch> getAll();
}