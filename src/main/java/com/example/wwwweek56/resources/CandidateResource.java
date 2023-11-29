package com.example.wwwweek56.resources;

import com.example.wwwweek56.services.CandidateService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateResource {
    private final CandidateService service;

    public CandidateResource(CandidateService service) {
        this.service = service;
    }
}
