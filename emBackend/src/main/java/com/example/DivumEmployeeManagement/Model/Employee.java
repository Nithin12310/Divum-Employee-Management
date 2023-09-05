package com.example.DivumEmployeeManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class Employee {
    @Id
    private String emailid;

    private String fname;

    private String lname;

    private BigInteger mbno;

    private LocalDate dob;

    private String address;


    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public BigInteger getMbno() {
        return mbno;
    }

    public void setMbno(BigInteger mbno) {
        this.mbno = mbno;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
