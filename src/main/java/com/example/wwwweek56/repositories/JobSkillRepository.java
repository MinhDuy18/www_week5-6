package com.example.wwwweek56.repositories;

import com.example.wwwweek56.ids.JobSkillID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface JobSkillRepository extends JpaRepository<com.example.wwwweek56.models.JobSkill, JobSkillID> {
}