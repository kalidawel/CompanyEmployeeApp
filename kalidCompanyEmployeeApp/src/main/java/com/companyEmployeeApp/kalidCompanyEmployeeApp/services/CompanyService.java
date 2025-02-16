package com.companyEmployeeApp.kalidCompanyEmployeeApp.services;

import com.companyEmployeeApp.kalidCompanyEmployeeApp.entities.Company;

import java.util.List;

public interface CompanyService {
    public List<Company> getAllCompany();
    public Company getCompanyById(long id) ;
    public Company createCompany(Company company);
    public Company updateCompany(Company company,long id);
    public void deleteCompany(long id);

}
