package com.assessment.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.entities.Batch;
import com.assessment.entities.Courses;
import com.assessment.exception.ResourceNotFoundException;
import com.assessment.repository.BatchRepository;
import com.assessment.service.BatchService;
@Service
public class BatchServiceImpl implements BatchService {

	@Autowired
	private BatchRepository batchRepository; 
	
	@Autowired
	private CourseServiceImpl courseServiceImpl;
	
	@Override
	public Batch addBatch(Batch batch,int courseId) throws ResourceNotFoundException {
				
		Courses single = courseServiceImpl.getSingle(courseId);
		
		batch.setCourses(single);
										
		return batchRepository.save(batch);
	}

	@Override
	public Batch updateBatch(Batch batch, int batchId,int courseId) throws ResourceNotFoundException {
		
		Batch batchRecord = batchRepository.findById(batchId).orElseThrow(()-> new ResourceNotFoundException("Batch","Id", batchId));
		
		batchRecord.setBatch_duration(batch.getBatch_duration());
		batchRecord.setBatchName(batch.getBatchName());
		batchRecord.setBatchTime(batch.getBatchTime());
				
		Courses single = courseServiceImpl.getSingle(courseId);
		
		batchRecord.setCourses(single);		
		batchRecord.setEndDate(batch.getEndDate());
		batchRecord.setStartDate(batch.getStartDate());
		batchRecord.setFees(batch.getFees());
						
		return batchRepository.save(batchRecord);
	}
	@Override
	public void deletebatch(int batchId) throws ResourceNotFoundException {
				
		Batch batch = batchRepository.findById(batchId).orElseThrow(()->new ResourceNotFoundException("Batch","Id", batchId));	
		batchRepository.deleteById(batchId);
	}

	@Override
	public Batch getSingleBatch(int batchId) throws ResourceNotFoundException {
		
		return batchRepository.findById(batchId).orElseThrow(()->new ResourceNotFoundException("batch","id", batchId));
	}
	@Override
	public List<Batch> getAll() {
		
		return batchRepository.findAll();
	}
}
