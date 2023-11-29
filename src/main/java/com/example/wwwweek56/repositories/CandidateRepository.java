package com.example.wwwweek56.repositories;

import com.example.wwwweek56.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "Candidate")
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}