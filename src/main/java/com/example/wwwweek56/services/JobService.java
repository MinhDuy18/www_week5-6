package com.example.wwwweek56.services;

import com.example.wwwweek56.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {
    @Autowired
    JobRepository repository;

}
