package com.example.wwwweek56.services;

import com.example.wwwweek56.repositories.CandidateRepository;
import com.example.wwwweek56.repositories.CandidateSkillRepository;
import com.example.wwwweek56.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CandidateSkillService {
    CandidateSkillRepository repository;
    CandidateRepository candidateRepository;
    SkillRepository skillRepository;

    @Autowired
    public CandidateSkillService(CandidateSkillRepository repository, CandidateRepository candidateRepository, SkillRepository skillRepository) {
        this.repository = repository;
        this.candidateRepository = candidateRepository;
        this.skillRepository = skillRepository;
    }

}
