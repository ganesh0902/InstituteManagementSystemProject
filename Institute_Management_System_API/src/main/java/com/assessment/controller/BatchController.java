package com.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
import com.assessment.entities.Batch;
import com.assessment.exception.ResourceNotFoundException;
import com.assessment.serviceImpl.BatchServiceImpl;

@RequestMapping("/batch")
@RestController
public class BatchController {

	@Autowired
	private BatchServiceImpl batchServiceImpl;
	
	@PostMapping("/{courseId}")
	public ResponseEntity<Batch> addbatch(@RequestBody Batch batch,@PathVariable("courseId") int courseId) throws ResourceNotFoundException
	{
		Batch addBatch = batchServiceImpl.addBatch(batch,courseId);
		
		return ResponseEntity.status(HttpStatus.OK).body(addBatch);
	}
	@PutMapping("/{batchId}/{courseId}")
	public ResponseEntity<Batch> updateBatch(@RequestBody Batch batch,@PathVariable("batchId") int bId,@PathVariable("courseId") int courseId) throws ResourceNotFoundException
	{
		Batch updateBatch = batchServiceImpl.updateBatch(batch, bId,courseId);
		
		return ResponseEntity.status(HttpStatus.OK).body(updateBatch);
	}
	@GetMapping("/{batchId}")
	public ResponseEntity<Batch> getSingleBatch(@PathVariable("batchId") int batchId) throws ResourceNotFoundException
	{
		Batch singleBatch = batchServiceImpl.getSingleBatch(batchId);
		
		return ResponseEntity.status(HttpStatus.OK).body(singleBatch);
	}
	@DeleteMapping("/{batchId}")
	public ResponseEntity<Batch> deleteBatch(@PathVariable("batchId") int batchId) throws ResourceNotFoundException
	{
		this.batchServiceImpl.deletebatch(batchId);
		
		return new ResponseEntity(new ApiResponse("Batch Deleted Successfully",true),HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<List<Batch>> getAllRecord()
	{		
		List<Batch> all = this.batchServiceImpl.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(all);
	}
}
