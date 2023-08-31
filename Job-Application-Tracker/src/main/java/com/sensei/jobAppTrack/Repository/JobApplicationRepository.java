package com.sensei.jobAppTrack.Repository;

import com.sensei.jobAppTrack.entity.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Integer>  {
        // Retrieve a list of job applications by their unique ID
        List<JobApplication> findAllById(int id);
}
