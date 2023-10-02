package com.assessment.service;

import java.util.List;

import com.assessment.entities.Candidate;
import com.assessment.exception.ResourceNotFoundException;

public interface CandidateService {

	public Candidate addCandidate(Candidate candidate,int batchId) throws ResourceNotFoundException;
	public Candidate updateCandidate(Candidate candidate,int candidateId,int batchId) throws ResourceNotFoundException;
	public Candidate getSingleCandidate(int candidateId) throws ResourceNotFoundException;
	public void deleteCandidate(int id);
	public List<Candidate> getAllCandidate();
}
