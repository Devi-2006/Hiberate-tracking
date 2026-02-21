package com.scwellness.bean;

import java.math.BigDecimal;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SESSION_TBL")
public class Sessions {

    @Id
    @Column(name = "SESSION_ID")
    private int sessionID;

    @Column(name = "SENIOR_ID")
    private String seniorID;

    @Column(name = "PROGRAM_ID")
    private String programID;

    @Column(name = "SESSION_DATE")
    private Date sessionDate;

    @Column(name = "TIME_SLOT")
    private String timeSlot;

    @Column(name = "CLINICIAN_NAME")
    private String clinicianName;

    @Column(name = "BLOOD_PRESSURE")
    private String bloodPressure;

    @Column(name = "SUGAR_LEVEL")
    private BigDecimal sugarLevel;

    @Column(name = "SESSION_NOTES")
    private String sessionNotes;

    @Column(name = "STATUS")
    private String status;

    // Getters & Setters

    public int getSessionID() {
        return sessionID;
    }

    public void setSessionID(int sessionID) {
        this.sessionID = sessionID;
    }

    public String getSeniorID() {
        return seniorID;
    }

    public void setSeniorID(String seniorID) {
        this.seniorID = seniorID;
    }

    public String getProgramID() {
        return programID;
    }

    public void setProgramID(String programID) {
        this.programID = programID;
    }

    public Date getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getClinicianName() {
        return clinicianName;
    }

    public void setClinicianName(String clinicianName) {
        this.clinicianName = clinicianName;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public BigDecimal getSugarLevel() {
        return sugarLevel;
    }

    public void setSugarLevel(BigDecimal sugarLevel) {
        this.sugarLevel = sugarLevel;
    }

    public String getSessionNotes() {
        return sessionNotes;
    }

    public void setSessionNotes(String sessionNotes) {
        this.sessionNotes = sessionNotes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}