package com.kenmeister.comprehensiveApplication.service;


import com.kenmeister.comprehensiveApplication.dataobjects.JobMatchResponse;
import com.kenmeister.comprehensiveApplication.dataobjects.JobTargetRequest;
import com.kenmeister.comprehensiveApplication.dataobjects.JobTargetResponse;
import com.kenmeister.comprehensiveApplication.entity.JobMatchEntity;
import com.kenmeister.comprehensiveApplication.entity.JobTargetEntity;
import com.kenmeister.comprehensiveApplication.repository.JobMatchRepository;
import com.kenmeister.comprehensiveApplication.repository.JobTargetRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class JobFinderService {

    private static final Long MOCKID = 5L;
    private final JobMatchRepository jobMatchRepository;
    private final JobTargetRepository jobTargetRepository;

    //READ
    public List<JobMatchResponse> retrieveAllJobMatch() {
        //call the context to get the id;
        List<JobMatchEntity> jobMatchEntityList = jobMatchRepository.findAllById(List.of(MOCKID));

        //turn entities to job match response
        return null;
    }

    //Create
    public JobTargetResponse addJob(JobTargetRequest jobTargetRequest) {
        ModelMapper modelMapper = new ModelMapper();
        JobTargetEntity entity = modelMapper.map(jobTargetRequest, JobTargetEntity.class);
        JobTargetEntity savedEntity = jobTargetRepository.save(entity);
        return modelMapper.map(savedEntity, JobTargetResponse.class);
    }
}
