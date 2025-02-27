package com.companyEmployeeApp.kalidCompanyEmployeeApp.dto;


import com.companyEmployeeApp.kalidCompanyEmployeeApp.entities.Employee;

import java.util.List;

public class CompanyDto {
    private String companyName;
    private String companyEmail;
    private String companyType;
    private List<EmployeeDto> employeesDto;

    public CompanyDto(String companyName, String companyEmail,
                      String companyType, List<EmployeeDto> employeesDto) {
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.companyType = companyType;
        this.employeesDto = employeesDto;
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

    public List<EmployeeDto> getEmployeesDto() {
        return employeesDto;
    }

    public void setEmployeesDto(List<EmployeeDto> employeesDto) {
        this.employeesDto = employeesDto;
    }

    @Override
    public String toString() {
        return "CompanyDto{" +
                "companyName='" + companyName + '\'' +
                ", companyEmail='" + companyEmail + '\'' +
                ", companyType='" + companyType + '\'' +
                ", employeesDto=" + employeesDto +
                '}';
    }
}
