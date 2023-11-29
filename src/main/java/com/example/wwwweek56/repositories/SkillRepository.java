package com.example.wwwweek56.repositories;

import com.example.wwwweek56.models.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SkillRepository extends JpaRepository<Skill, Long> {
}