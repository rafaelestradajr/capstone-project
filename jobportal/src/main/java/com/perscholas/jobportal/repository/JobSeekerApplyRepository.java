package com.perscholas.jobportal.repository;

import com.perscholas.jobportal.entity.JobPostActivity;
import com.perscholas.jobportal.entity.JobSeekerApply;
import com.perscholas.jobportal.entity.JobSeekerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerApplyRepository extends JpaRepository<JobSeekerApply,Integer> {

    List<JobSeekerApply> findByUserId(JobSeekerProfile userId);

    List<JobSeekerApply> findByJob(JobPostActivity job);
}
