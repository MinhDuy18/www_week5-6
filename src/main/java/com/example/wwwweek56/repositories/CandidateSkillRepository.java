package com.example.wwwweek56.repositories;

import com.example.wwwweek56.ids.CandidateSkillID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface CandidateSkillRepository extends JpaRepository<com.example.wwwweek56.models.CandidateSkill, CandidateSkillID> {
}