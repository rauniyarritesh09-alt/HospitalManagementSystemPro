
package com.ritesh.hospital.database.model;

public class Doctor {

    private int doctorId;
    private String name;
    private String specialization;
    private String qualification;
    private int experience;
    private String mobile;
    private String email;
    public Doctor() {
    }


    public Doctor(int doctorId, String name,
                  String specialization,
                  String qualification,
                  int experience,
                  String mobile,
                  String email) {

        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.qualification = qualification;
        this.experience = experience;
        this.mobile = mobile;
        this.email = email;
    }



    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}