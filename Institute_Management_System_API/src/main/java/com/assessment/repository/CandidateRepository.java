package com.assessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assessment.entities.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate,Integer>{

	public Candidate findByEmail(String email);
}
