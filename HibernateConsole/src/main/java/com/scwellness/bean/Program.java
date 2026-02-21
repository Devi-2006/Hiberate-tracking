package com.scwellness.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PROGRAM_TBL")
public class Program {

    @Id
    @Column(name = "Program_ID")
    private String programID;

    @Column(name = "Program_Name")
    private String programName;

    @Column(name = "Category")
    private String category;

    @Column(name = "Recommended_Duration_Weeks")
    private int recommendedDurationWeeks;

    @Column(name = "Session_Frequency")
    private String sessionFrequency;

    @Column(name = "Status")
    private String status;

    public String getProgramID() {
        return programID;
    }
    public void setProgramID(String programID) {
        this.programID = programID;
    }
    public String getProgramName() {
        return programName;
    }
    public void setProgramName(String programName) {
        this.programName = programName;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public int getRecommendedDurationWeeks() {
        return recommendedDurationWeeks;
    }
    public void setRecommendedDurationWeeks(int recommendedDurationWeeks) {
        this.recommendedDurationWeeks = recommendedDurationWeeks;
    }
    public String getSessionFrequency() {
        return sessionFrequency;
    }
    public void setSessionFrequency(String sessionFrequency) {
        this.sessionFrequency = sessionFrequency;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}