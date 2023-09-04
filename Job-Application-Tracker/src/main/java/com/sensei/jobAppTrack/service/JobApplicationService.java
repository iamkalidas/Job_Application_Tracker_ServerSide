package com.sensei.jobAppTrack.service;

import com.sensei.jobAppTrack.Repository.JobApplicationRepository;
import com.sensei.jobAppTrack.entity.JobApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationService {
    @Autowired
    JobApplicationRepository applicationRepository;

    // Retrieve a list of job applications associated with a specific user
    public List<JobApplication> findApplicationsByUser(int id) {
        return applicationRepository.findAllById(id);
    }

    // Get a job application by its unique ID
    public JobApplication getApplicationById(int id) {
        return applicationRepository.findById(id).orElse(null);
    }

    // Get a list of all job applications
    public List<JobApplication> getAllApplications() {
        return applicationRepository.findAll();
    }

    // Add a new job application
    public JobApplication addApplication(JobApplication application) {
        return applicationRepository.save(application);
    }

    // Update an existing job application by ID
    public JobApplication updateApplication(int id, JobApplication application) {
        JobApplication existingApplication = applicationRepository.findById(id).orElse(null);
        if (existingApplication != null) {
            // Update fields of existingApplication using data from application
            existingApplication.setDateApplied(application.getDateApplied());
            existingApplication.setCompany(application.getCompany());
            existingApplication.setPosition(application.getPosition());
            existingApplication.setApplicationMethod(application.getApplicationMethod());
            existingApplication.setContactInfo(application.getContactInfo());
            existingApplication.setStatus(application.getStatus());
            existingApplication.setNotes(application.getNotes());

            return applicationRepository.save(existingApplication);
        }
        return null;
    }

    // Delete a job application by ID
    public void deleteApplication(int id) {
        applicationRepository.deleteById(id);
    }

    // Get a paginated list of job applications
    public Page<JobApplication> getPaginatedApplications(Pageable pageable) {
        return applicationRepository.findAll(pageable);
    }
}
