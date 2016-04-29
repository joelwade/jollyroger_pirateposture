package database;

import java.util.Date;

/**
 * Created by p4068830 on 19/04/16.
 */
public class Patient {

    private int PatientID;
    private String FirstName;
    private String SurName;
    private Date DoB;
    private String Gender;

    //Constructors
    public void Patient(String str1, String str2)
    {

    }

    public void Patient(int PatientID, String FirstName, String SurName, Date DoB, String Gender, Date DateLastSeen, String ImageLink)
    {
        this.PatientID = PatientID;
        this.FirstName = FirstName;
        this.SurName = SurName;
        this.DoB = DoB;
        this.Gender = Gender;
    }


    public int getPatientID() {
        return PatientID;
    }

    public void setPatientID(int patientID) {
        PatientID = patientID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getSurName() {
        return SurName;
    }

    public void setSurName(String surName) {
        SurName = surName;
    }

    public Date getDoB() {
        return DoB;
    }

    public void setDoB(Date doB) {
        DoB = doB;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}
