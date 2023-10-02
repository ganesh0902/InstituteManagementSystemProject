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
import com.assessment.entities.Candidate;
import com.assessment.exception.ResourceNotFoundException;
import com.assessment.serviceImpl.CandidateServiceImpl;

@RequestMapping("/candidate")
@RestController
public class CandidateController {
	
	@Autowired
	private CandidateServiceImpl candidateServiceImpl;
	
	
	@PostMapping("/{batchId}")
	public ResponseEntity<Candidate> addCandidate(@RequestBody Candidate candidate,@PathVariable("batchId") int batchId) throws ResourceNotFoundException
	{
		Candidate addCandidate = this.candidateServiceImpl.addCandidate(candidate, batchId);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(addCandidate);
	
	}
	@PutMapping("/{candidateId}/{batchId}")
	public ResponseEntity<Candidate> updateCandidate(@RequestBody Candidate candidate,@PathVariable("candidateId") int candidateId,@PathVariable("batchId")int batchId) throws ResourceNotFoundException
	{		
		Candidate updateCandidate = this.candidateServiceImpl.updateCandidate(candidate, candidateId,batchId);
		
		return ResponseEntity.status(HttpStatus.OK).body(updateCandidate);
	}
	@DeleteMapping("/{candidateId}")
	public ResponseEntity<ApiResponse> deleteCandidate(@PathVariable("candidateId")int candidateId)
	{
		this.candidateServiceImpl.deleteCandidate(candidateId);
		
		return new ResponseEntity(new ApiResponse("Candidate deleted Successfully",true),HttpStatus.OK);
	}
	@GetMapping("/{candidateInd}")
	public ResponseEntity<Candidate> getSingleObject(@PathVariable("candidateInd") int candidateInd) throws ResourceNotFoundException
	{
		Candidate singleCandidate = this.candidateServiceImpl.getSingleCandidate(candidateInd);
		
		return ResponseEntity.status(HttpStatus.OK).body(singleCandidate);
	}
	@GetMapping("/")
	public ResponseEntity<List<Candidate>> getAllCandidate()
	{
		List<Candidate> allCandidate = this.candidateServiceImpl.getAllCandidate();
		
		return ResponseEntity.status(HttpStatus.OK).body(allCandidate);
	}
}
