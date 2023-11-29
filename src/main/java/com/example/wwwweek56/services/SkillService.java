package com.example.wwwweek56.services;

import com.example.wwwweek56.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillService {
    @Autowired
    SkillRepository repository;

}
