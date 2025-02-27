package com.companyEmployeeApp.kalidCompanyEmployeeApp.dto;


import com.companyEmployeeApp.kalidCompanyEmployeeApp.entities.Company;

public class EmployeeDto {
    private String fName;
    private String lName;
    private String empDepartment;
    private int age;
    private String email;
    private String address;
    private Company company;

    public EmployeeDto(String fName, String lName, String empDepartment,
                       int age, String email, String address, Company company) {
        this.fName = fName;
        this.lName = lName;
        this.empDepartment = empDepartment;
        this.age = age;
        this.email = email;
        this.address = address;
        this.company = company;
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

    @Override
    public String toString() {
        return "EmployeeDto{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", empDepartment='" + empDepartment + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", company=" + company +
                '}';
    }
}
