package com.luv2code.jobportal.services;


import com.luv2code.jobportal.entity.JobPostActivity;
import com.luv2code.jobportal.entity.JobSeekerProfile;
import com.luv2code.jobportal.entity.JobSeekerSave;
import com.luv2code.jobportal.repository.JobSeekerApplyRepository;
import com.luv2code.jobportal.repository.JobSeekerSaveRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerSaveService {

   // private final JobSeekerApplyRepository jobSeekerApplyRepository;
    private final JobSeekerSaveRepository jobSeekerSaveRepository;

    public JobSeekerSaveService( JobSeekerSaveRepository jobSeekerSaveRepository) {
       // this.jobSeekerApplyRepository = jobSeekerApplyRepository;
        this.jobSeekerSaveRepository = jobSeekerSaveRepository;
    }
    public List<JobSeekerSave> getCandidatesJob(JobSeekerProfile userAccountId){
        return jobSeekerSaveRepository.findByUserId(userAccountId);
    }

    public List<JobSeekerSave> getJobCandidates(JobPostActivity job){
        return jobSeekerSaveRepository.findByJob(job);
    }

    public void addNew(JobSeekerSave jobSeekerSave) {
        jobSeekerSaveRepository.save(jobSeekerSave);
    }
}


