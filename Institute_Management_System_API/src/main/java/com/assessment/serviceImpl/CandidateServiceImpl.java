package com.assessment.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.entities.Batch;
import com.assessment.entities.Candidate;
import com.assessment.exception.ResourceNotFoundException;
import com.assessment.repository.CandidateRepository;
import com.assessment.service.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService{

	@Autowired
	private CandidateRepository candidateRepository;
	
	@Autowired
	private BatchServiceImpl batchServiceImpl;
	
	@Override
	public Candidate addCandidate(Candidate candidate,int batchId) throws ResourceNotFoundException {
				
		Batch singleBatch = this.batchServiceImpl.getSingleBatch(batchId);
		
		System.out.println(singleBatch);
		candidate.setBatch(singleBatch);
		//candidate.setBatch(singleBatch);
		
		return candidateRepository.save(candidate);
	}

	@Override
	public Candidate updateCandidate(Candidate candidate,int candidateId,int batchId) throws ResourceNotFoundException {
		
		Candidate candidate2 = this.candidateRepository.findById(candidateId).orElseThrow(()-> new ResourceNotFoundException("Candidate","id",candidateId));		
		Batch singleBatch = this.batchServiceImpl.getSingleBatch(batchId); 
		System.out.println(singleBatch);
		candidate2.setLastName(candidate.getLastName());
		candidate2.setFirstName(candidate.getFirstName());
		candidate2.setEmail(candidate.getEmail());
		candidate2.setFees(candidate.getFees());
		
		candidate2.setBatch(singleBatch);		
		candidate2.setBatchMode(candidate.getBatchMode());
		
		//candidate2.setBatch(candidate.getBatch());
		
		return this.candidateRepository.save(candidate2);
	}

	@Override
	public Candidate getSingleCandidate(int candidateId) throws ResourceNotFoundException {
		//get single candidate object by its Id
		
		Candidate findByEmail = this.candidateRepository.findById(candidateId).orElseThrow(()-> new ResourceNotFoundException("Candidate","Id", candidateId));
		
		return findByEmail;
	}

	@Override
	public void deleteCandidate(int id) {
		
		this.candidateRepository.deleteById(id);
		
	}

	@Override
	public List<Candidate> getAllCandidate() {
		// TODO Auto-generated method stub
		return this.candidateRepository.findAll();
	}
}
