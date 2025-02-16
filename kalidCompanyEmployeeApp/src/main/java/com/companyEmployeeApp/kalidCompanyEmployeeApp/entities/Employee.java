package com.companyEmployeeApp.kalidCompanyEmployeeApp.entities;

import jakarta.persistence.*;

@Entity
public class Employee {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "First_Name", nullable = false)
    private String fName;
    private String lName;
    @Column(name = "Department_Name", nullable = false)
    private String empDepartment;
    private int age;
    @Column(name = "Emp_Email", nullable = false,unique = true)
    private String email;
    private String address;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company",nullable = false)
    private Company company;


    public Employee(){}

    //creating constructor without id b/c id is generated automatically

    public Employee(String fName, String lName,
                    String empDepartment, int age, String email,
                    String address, Company company) {
        this.fName = fName;
        this.lName = lName;
        this.empDepartment = empDepartment;
        this.age = age;
        this.email = email;
        this.address = address;
        this.company = company;
    }


    //creating constructor with id ,(for safety) in case if i needed for object creation with id

    public Employee(long id, String fName, String lName,
                    String empDepartment, int age, String email,
                    String address, Company company) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.empDepartment = empDepartment;
        this.age = age;
        this.email = email;
        this.address = address;
        this.company = company;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmpDepartment() {
        return empDepartment;
    }

    public void setEmpDepartment(String empDepartment) {
        this.empDepartment = empDepartment;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    //generating to string method


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", empDepartment='" + empDepartment + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", company=" + company +
                '}';
    }
}
