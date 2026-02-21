package com.scwellness.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SENIOR_TBL")
public class Senior {

    @Id
    @Column(name = "Senior_ID")
    private String seniorID;

    @Column(name = "Full_Name")
    private String fullName;

    @Column(name = "Age")
    private int age;

    @Column(name = "Gender")
    private String gender;

    @Column(name = "Primary_Phone")
    private String primaryPhone;

    @Column(name = "Chronic_Conditions")
    private String chronicConditions;

    @Column(name = "Emergency_Contact_Name")
    private String emergencyContactName;

    @Column(name = "Emergency_Contact_Phone")
    private String emergencyContactPhone;

    @Column(name = "Status")
    private String status;

    public String getSeniorID() {
        return seniorID;
    }
    public void setSeniorID(String seniorID) {
        this.seniorID = seniorID;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getPrimaryPhone() {
        return primaryPhone;
    }
    public void setPrimaryPhone(String primaryPhone) {
        this.primaryPhone = primaryPhone;
    }
    public String getChronicConditions() {
        return chronicConditions;
    }
    public void setChronicConditions(String chronicConditions) {
        this.chronicConditions = chronicConditions;
    }
    public String getEmergencyContactName() {
        return emergencyContactName;
    }
    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }
    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }
    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}