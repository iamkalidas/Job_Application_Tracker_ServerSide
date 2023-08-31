package com.sensei.jobAppTrack.controller;

import com.sensei.jobAppTrack.entity.JobApplication;
import com.sensei.jobAppTrack.entity.User;
import com.sensei.jobAppTrack.service.JobApplicationService;
import com.sensei.jobAppTrack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/applications")
public class JobApplicationController {

    @Autowired
    private final JobApplicationService applicationService;
    @Autowired
    private UserService userService;

    @Autowired
    public JobApplicationController(JobApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    // Get all applications for the authenticated user by user ID
    /*
    @GetMapping("/user/{id}")
    public ResponseEntity<List<JobApplication>> getAllApplicationsForAuthenticatedUser(@PathVariable int id) {
        User authenticatedUser = userService.getAuthenticatedUser();

        if (authenticatedUser != null) {
            List<JobApplication> applications = applicationService.findApplicationsByUser(id);
            return ResponseEntity.ok(applications);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }*/

    // Get all applications for a specific user by username
    @GetMapping("/username/{username}")
    public List<JobApplication> getAllApplicationsByUser(@PathVariable String username) {
        User user = userService.findUserByUsername(username);
        if (user != null) {
            return applicationService.findApplicationsByUser(user.getId());
        } else {
            return Collections.emptyList();
        }
    }

    // Get all applications from the database irrespective of username
    @GetMapping("/all")
    public List<JobApplication> getAllApplications() {
        return applicationService.getAllApplications();
    }

    // Get application by ID
    @GetMapping("/{id}")
    public ResponseEntity<JobApplication> getApplicationById(@PathVariable int id) {
        JobApplication application = applicationService.getApplicationById(id);
        if (application != null) {
            return ResponseEntity.ok(application);
        } else {
            return ResponseEntity.notFound().build(); // Return a 404 response if application not found
        }
    }

    // Add a new application
    @PostMapping
    public ResponseEntity<JobApplication> addApplication(@RequestBody JobApplication application) {
        JobApplication newApplication = applicationService.addApplication(application);
        return ResponseEntity.ok(newApplication);
    }

    // Update an application
    @PutMapping("/{id}")
    public ResponseEntity<JobApplication> updateApplication(@PathVariable int id, @RequestBody JobApplication application) {
        JobApplication updatedApplication = applicationService.updateApplication(id, application);
        if (updatedApplication != null) {
            return ResponseEntity.ok(updatedApplication);
        }
        return ResponseEntity.notFound().build();
    }

    // Delete an application
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteApplication(@PathVariable int id) {
        applicationService.deleteApplication(id);
        return ResponseEntity.noContent().build();
    }
}
