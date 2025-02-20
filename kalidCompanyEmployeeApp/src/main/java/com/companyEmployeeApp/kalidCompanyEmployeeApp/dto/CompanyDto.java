package com.companyEmployeeApp.kalidCompanyEmployeeApp.dto;



public class CompanyDto {
    private String companyName;
    private String companyEmail;
    private String companyType;

    public CompanyDto(String companyName, String companyEmail, String companyType) {
        this.companyName = companyName;
        this.companyEmail = companyEmail;
        this.companyType = companyType;
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

    @Override
    public String toString() {
        return "CompanyDto{" +
                "companyName='" + companyName + '\'' +
                ", companyEmail='" + companyEmail + '\'' +
                ", companyType='" + companyType + '\'' +
                '}';
    }
}
