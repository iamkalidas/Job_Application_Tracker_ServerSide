package com.sensei.jobAppTrack.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "job_applications")
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; // Unique identifier for the job application

    private LocalDate dateApplied; // Date when the application was submitted
    private String company; // Company to which the application was sent
    private String position; // Position applied for
    private String applicationMethod; // Method used to submit the application (online, email, etc.)
    private String contactInfo; // Contact information for the application
    private String status; // Current status of the application (pending, reviewed, etc.)
    private String notes; // Any additional notes related to the application

    /*
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user; // User associated with the application
     */

    // Default constructor
    public JobApplication() {
    }

    // Parameterized constructor
    public JobApplication(int id, LocalDate dateApplied, String company, String position, String applicationMethod, String contactInfo, String status, String notes) {
        this.id = id;
        this.dateApplied = dateApplied;
        this.company = company;
        this.position = position;
        this.applicationMethod = applicationMethod;
        this.contactInfo = contactInfo;
        this.status = status;
        this.notes = notes;
//        this.user = user;
    }

    // Getter and setter for 'id'
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and setter for 'dateApplied'
    public LocalDate getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(LocalDate dateApplied) {
        this.dateApplied = dateApplied;
    }

    // Getter and setter for 'company'
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    // Getter and setter for 'position'
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    // Getter and setter for 'applicationMethod'
    public String getApplicationMethod() {
        return applicationMethod;
    }

    public void setApplicationMethod(String applicationMethod) {
        this.applicationMethod = applicationMethod;
    }

    // Getter and setter for 'contactInfo'
    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    // Getter and setter for 'status'
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Getter and setter for 'notes'
    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
/*
    // Getter and setter for 'user'
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
 */
}
