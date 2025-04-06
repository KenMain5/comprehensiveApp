package com.kenmeister.comprehensiveApplication.controller;

import com.kenmeister.comprehensiveApplication.dataobjects.JobMatchResponse;
import com.kenmeister.comprehensiveApplication.dataobjects.JobTargetRequest;
import com.kenmeister.comprehensiveApplication.dataobjects.JobTargetResponse;
import com.kenmeister.comprehensiveApplication.service.JobFinderService;
import com.kenmeister.comprehensiveApplication.scheduled.WebScrapeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(name = JobFinderController.PATH, consumes = MediaType.APPLICATION_JSON_VALUE)
public class JobFinderController {
    public static final String PATH = "/job";

    private final JobFinderService jobFinderService;
    private final WebScrapeService webScrapeService;

    public JobFinderController(JobFinderService jobFinderService, WebScrapeService webScrapeService) {
        this.jobFinderService = jobFinderService;
        this.webScrapeService = webScrapeService;
    }

    @PostMapping()
    public ResponseEntity<JobTargetResponse> createJobTarget(JobTargetRequest jobTargetRequest){
        jobFinderService.addJob(jobTargetRequest);
        return new ResponseEntity<>(null, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<JobMatchResponse>> getResults(){
        List<JobMatchResponse> jobResultsList= jobFinderService.retrieveAllJobMatch();
        return new ResponseEntity<>(jobResultsList, HttpStatus.OK);
    }

    @GetMapping("/test")
    public ResponseEntity<Void> testingPurposes() throws IOException {
        webScrapeService.checkJobListings();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}








