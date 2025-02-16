package com.companyEmployeeApp.kalidCompanyEmployeeApp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long companyId;
    @Column(name = "Company_Name", nullable = false)
    private String companyName;
    @Column(name = "Company_Email", nullable = false,unique = true)
    private String companyEmail;
    private String companyType;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Employee> employees;

  public Company(){}

    //creating constructor without id b/c id is generated automatically


    public Company(String companyName, String companyEmail,
                   String companyType, List<Employee> employees) {
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.companyType = companyType;
        this.employees = employees;
    }

    public Company(String companyName, String companyEmail, String companyType) {
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.companyType = companyType;
    }

    public Company(long companyId, String companyName, String companyEmail,
                   String companyType, List<Employee> employees) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.companyType = companyType;
        this.employees = employees;
    }

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", companyEmail='" + companyEmail + '\'' +
                ", companyType='" + companyType + '\'' +
                ", employees=" + employees +
                '}';
    }
}
