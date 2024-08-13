package com.perscholas.jobportal.repository;

import com.perscholas.jobportal.entity.JobPostActivity;
import com.perscholas.jobportal.entity.JobSeekerProfile;
import com.perscholas.jobportal.entity.JobSeekerSave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JobSeekerSaveRepository extends JpaRepository<JobSeekerSave,Integer> {

    List<JobSeekerSave> findByUserId(JobSeekerProfile userAccountId);

    List<JobSeekerSave> findByJob(JobPostActivity job);

}
